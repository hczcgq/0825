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

import com.lawyer.android.R;
import com.lawyer.android.bean.MessageEntity;
import com.lawyer.android.http.HttpHelper;
import com.lawyer.android.http.httpUtils;
import com.lawyer.android.util.Constants;
import com.lawyer.android.util.LoadingDialog;
import com.lawyer.android.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class FragmentMessage extends Fragment {
    private List<MessageEntity> messageEntities;
    private ListView mListView;
    private RequestData mRequestData;
    private LoadingDialog mLoadingDialog;
    public FragmentMessage() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_fragment_message, null);
        mListView = (ListView) view.findViewById(R.id.toolListView);
        mLoadingDialog=new LoadingDialog(getActivity());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData(){
        Map<String, String> map=new HashMap<String, String>();
        map.put("v","1.0");
        map.put("ts", StringUtils.getCurrentTimes());
        map.put("appKey", Constants.APP_KEY);
        map.put("method", getString(R.string.lawyer_message_get_url));
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

    class RequestData extends AsyncTask<String,Void ,String> {
        private Map<String, String> map;

        public RequestData(Map<String, String> map) {
            this.map=map;
        }

        @Override
        protected String doInBackground(String... params) {
            String item=null;
            try {
                String result= HttpHelper.doRequestForString(getActivity(), getString(R.string.base_url), HttpHelper.HTTP_POST, map);
                Log.e("---",result);
//  item=new Gson().fromJson(result,new TypeToken<ListMessageItem>() {}.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  item;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            mLoadingDialog.dismiss();
            if(result!=null){
//                if(result.isSuccess()){
//                    messageEntities =result.getMessages();
//                    mListView.setAdapter(new MessageAdapter(getActivity(), messageEntities));
//                }else{
//                    ToastUtils.showToastShort(getActivity(), result.getMessage());
//                }
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingDialog.dialogShow();
        }
    }
}