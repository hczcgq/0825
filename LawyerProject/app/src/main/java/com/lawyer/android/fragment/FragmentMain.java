package com.lawyer.android.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lawyer.android.R;
import com.lawyer.android.adapter.MainOrderAdapter;
import com.lawyer.android.bean.OrderEntity;
import com.lawyer.android.http.HttpHelper;
import com.lawyer.android.http.httpUtils;
import com.lawyer.android.util.Constants;
import com.lawyer.android.util.LoadingDialog;
import com.lawyer.android.util.PreferencesUtils;
import com.lawyer.android.util.StringUtils;
import com.lawyer.android.util.ToastUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenguoquan on 9/1/15.
 */
public class FragmentMain extends Fragment implements MainOrderAdapter.OrderListener{
    private RequestData mRequestData;
    private LoadingDialog mLoadingDialog;
    private ListView mListView;
    private RelativeLayout buttonRelativeLayout;
    private TextView noOrderTextView;
    private MainOrderAdapter adapter;
    private FragmentMain mContext;
    private TextView orderTextView;

    public static final int REQUEST_NEW=11;
    public static final int REQUEST_BIND=12;

    public FragmentMain() {
        mContext=this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_fragment_main, null);
        mLoadingDialog=new LoadingDialog(getActivity());
        mListView= (ListView) view.findViewById(R.id.mListView);
        buttonRelativeLayout= (RelativeLayout) view.findViewById(R.id.buttonRelativeLayout);
        noOrderTextView= (TextView) view.findViewById(R.id.noOrderTextView);
        orderTextView= (TextView) view.findViewById(R.id.orderTextView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData(){
        buttonRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String work= PreferencesUtils.getString(getActivity(),Constants.PRE_WORK);
                if(work.equals(Constants.WORK_ON)) {
                    orderTextView.setText("订单中");
                    Map<String, String> map = new HashMap<String, String>();
                    map.put("v", "1.0");
                    map.put("ts", StringUtils.getCurrentTimes());
                    map.put("appKey", Constants.APP_KEY);
                    map.put("method", getString(R.string.lawyer_order_newlist_url));
                    map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
                    loadDate(map,REQUEST_NEW);
                }else{
                    ToastUtils.showToastShort(getActivity(),"现在是下班时间,无法抢单！");
                }
            }
        });
    }



    /**
     * 加载数据
     * @param map
     */
    private void loadDate( Map<String, String> map,int request_code) {
        if (mRequestData != null
                && mRequestData.getStatus() != AsyncTask.Status.FINISHED)
            mRequestData.cancel(true);
        mRequestData = new RequestData(map,request_code);
        mRequestData.execute();
    }

    @Override
    public void onDetail(int no) {

    }

    @Override
    public void onOrder(int no) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("v", "1.0");
        map.put("ts", StringUtils.getCurrentTimes());
        map.put("appKey", Constants.APP_KEY);
        map.put("id", no+"");
        map.put("lawyerId", PreferencesUtils.getString(getActivity(),Constants.PRE_LAWYERID));
        map.put("mac", PreferencesUtils.getString(getActivity(),Constants.PRE_MAC));
        map.put("method", getString(R.string.lawyer_order_bind_url));
        map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
        loadDate(map,REQUEST_NEW);
    }




    class RequestData extends AsyncTask<String,Void ,OrderEntity>{
        private Map<String, String> map;
        private int request_code;
        public RequestData(Map<String, String> map, int request_code) {
            this.request_code=request_code;
            this.map=map;
        }




        @Override
        protected OrderEntity doInBackground(String... params) {
            OrderEntity item=null;
            try {
                String result= HttpHelper.doRequestForString(getActivity(), getString(R.string.base_url), HttpHelper.HTTP_POST, map);
                Log.e("---bang",result);
                item=new Gson().fromJson(result, new TypeToken<OrderEntity>() {
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  item;
        }

        @Override
        protected void onPostExecute(OrderEntity result) {
            super.onPostExecute(result);
            mLoadingDialog.dismiss();
            if(result!=null){
                if(result.getSuccess()){
                    List<OrderEntity.OrdersEntity> orders=result.getOrders();

                    if(orders!=null&&orders.size()>0){
                        mListView.setVisibility(View.VISIBLE);
                        noOrderTextView.setVisibility(View.GONE);
                        adapter=new MainOrderAdapter(getActivity(), orders);
                        adapter.setOrderListener(mContext);
                        mListView.setAdapter(adapter);
                    }else{
                        mListView.setVisibility(View.GONE);
                        noOrderTextView.setVisibility(View.VISIBLE);
                    }
                }else{
                    ToastUtils.showToastShort(getActivity(), result.getMessage());
                }
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingDialog.dialogShow();
        }
    }
}
