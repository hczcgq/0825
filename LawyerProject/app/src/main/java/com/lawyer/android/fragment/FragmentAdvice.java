package com.lawyer.android.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lawyer.android.R;
import com.lawyer.android.adapter.AdviceAdapter;
import com.lawyer.android.bean.AdviceEntity;
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
 * Created by hm-soft on 2015/8/26.
 */
public class FragmentAdvice extends Fragment {
    private RequestData mRequestData;
    private LoadingDialog mLoadingDialog;
    private ListView mListView;

    public FragmentAdvice() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_fragment_order, null);
        mLoadingDialog=new LoadingDialog(getActivity());
        mListView= (ListView) view.findViewById(R.id.mListView);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
    }

    private void initData(){
        String lawyerId= PreferencesUtils.getString(getActivity(), Constants.PRE_LAWYERID);
        Map<String, String> map=new HashMap<String, String>();
        map.put("v","1.0");
        map.put("ts", StringUtils.getCurrentTimes());
        map.put("appKey", Constants.APP_KEY);
        map.put("userType", "LAWYER");
        map.put("extId", "lawyerId");
        map.put("method", getString(R.string.lawyer_consult_list_url));
        map.put("nvl", "true");
        map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
        loadDate(map);
    }



    /**
     * 加载数据
     * @param map
     */
    private void loadDate( Map<String, String> map) {
        if (mRequestData != null
                && mRequestData.getStatus() != AsyncTask.Status.FINISHED)
            mRequestData.cancel(true);
        mRequestData = new RequestData(map);
        mRequestData.execute();
    }

    class RequestData extends AsyncTask<String,Void ,AdviceEntity> {
        private Map<String, String> map;

        public RequestData(Map<String, String> map) {
            this.map=map;
        }

        @Override
        protected AdviceEntity doInBackground(String... params) {
            AdviceEntity item=null;
            try {
                String result= HttpHelper.doRequestForString(getActivity(), getString(R.string.base_url), HttpHelper.HTTP_POST, map);
                item=new Gson().fromJson(result, new TypeToken<AdviceEntity>() {
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  item;
        }

        @Override
        protected void onPostExecute(AdviceEntity result) {
            super.onPostExecute(result);
            mLoadingDialog.dismiss();
            if(result!=null){
                if(result.getSuccess()){
                    List<AdviceEntity.ConsultsEntity> consults=result.getConsults();
                    mListView.setAdapter(new AdviceAdapter(getActivity(), consults));
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
