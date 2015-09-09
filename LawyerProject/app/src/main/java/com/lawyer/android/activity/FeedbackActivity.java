package com.lawyer.android.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;
import com.lawyer.android.bean.PersonEntity;
import com.lawyer.android.http.HttpHelper;
import com.lawyer.android.http.httpUtils;
import com.lawyer.android.util.Constants;
import com.lawyer.android.util.LoadingDialog;
import com.lawyer.android.util.PreferencesUtils;
import com.lawyer.android.util.StringUtils;
import com.lawyer.android.util.ToastUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class FeedbackActivity extends BaseUIActivity{


    private EditText feedbackEditText;

    private LoadingDialog mLoadingDialog;

    private RequestData mRequestData;


    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_feedback);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView(){
        //标题控件
        setHeadTitle(R.string.feedback);
        showLeftButton();
        addLeftButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        feedbackEditText= (EditText) findViewById(R.id.feedbackEditText);
        mLoadingDialog=new LoadingDialog(this);
    }

    public void submitClick(View view){
        String message=feedbackEditText.getText().toString();

        if(StringUtils.isEmpty(message)){
            ToastUtils.showToastShort(this,R.string.feedback_des_is_empty);
            return;
        }

        Map<String, String> map=new HashMap<String, String>();
        map.put("v","1.0");
        map.put("ts",StringUtils.getCurrentTimes());
        map.put("appKey", Constants.APP_KEY);
        map.put("method",getString(R.string.lawyer_feedback_save_url));
        map.put("title", message);
        map.put("userType", "LAWYER");
        map.put("extId", PreferencesUtils.getString(this,Constants.PRE_LAWYERID));
        map.put("nvl", "true");
        map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
        loadDate(map);
    }

    /**
     * 加载数据
     * @param map 请求数据
     */
    private void loadDate( Map<String, String> map) {
        if (mRequestData != null
                && mRequestData.getStatus() != AsyncTask.Status.FINISHED)
            mRequestData.cancel(true);
        mRequestData = new RequestData(map);
        mRequestData.execute();
    }


    /**
     * 登录请求
     */
    class RequestData extends AsyncTask<String,Void,PersonEntity> {

        private Map<String, String> map;
        public RequestData(Map<String, String> map) {
            this.map=map;
        }

        @Override
        protected PersonEntity doInBackground(String... params) {
            PersonEntity item =null;
            try {
                String result= HttpHelper.doRequestForString(FeedbackActivity.this, getString(R.string.base_url), HttpHelper.HTTP_POST, map);
                item = new Gson().fromJson(result, PersonEntity.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return item;
        }

        @Override
        protected void onPostExecute(PersonEntity result) {
            super.onPostExecute(result);
            mLoadingDialog.dismiss();
            if(result!=null){
                if(result.getSuccess()){
                    ToastUtils.showToastShort(FeedbackActivity.this,"反馈信息提交成功");
                    finish();
                }else{
                    ToastUtils.showToastShort(FeedbackActivity.this,result.getMessage());
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

