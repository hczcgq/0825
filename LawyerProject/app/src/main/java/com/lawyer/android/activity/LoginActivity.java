package com.lawyer.android.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;
import com.lawyer.android.bean.LoginItem;
import com.lawyer.android.http.HttpHelper;
import com.lawyer.android.http.httpUtils;
import com.lawyer.android.util.Constants;
import com.lawyer.android.util.LoadingDialog;
import com.lawyer.android.util.SHA1;
import com.lawyer.android.util.StringUtils;
import com.lawyer.android.util.ToastUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class LoginActivity extends BaseUIActivity{

    private RequestData mRequestData;

    private LoadingDialog mLoadingDialog;

    private Intent intent;

    private TextView mobileEditText,passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);

        initView();
    }

    private void initView(){
        //标题
        setHeadTitle(R.string.login_title);

        mLoadingDialog=new LoadingDialog(this);
        mobileEditText= (TextView) findViewById(R.id.mobileEditText);
        passwordEditText= (TextView) findViewById(R.id.passwordEditText);
    }

    public void LoginClick(View view){

        String mobile=mobileEditText.getText().toString();
        String password=passwordEditText.getText().toString();
        if(StringUtils.isEmpty(mobile)){
            ToastUtils.showToastShort(this,R.string.input_mobile);
            return;
        }
        if(StringUtils.isEmpty(password)){
            ToastUtils.showToastShort(this,R.string.input_password);
            return;
        }


        Map<String, String> map=new HashMap<String, String>();
        map.put("v","1.0");
        map.put("ts",StringUtils.getCurrentTimes());
        map.put("appKey", Constants.APP_KEY);
        map.put("method",getString(R.string.lawyer_login_url));
        map.put("loginCode", mobile);
        map.put("password", password);
        map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
        //appKeyios01loginCode18516276648methodlawyer.loginpassword123456ts1440756604170v1.0fdsh4vrFDSvjfds94
        loadDate(map);
    }


    /**
     * 注册
     * @param view
     */
    public void RegisterClick(View view){
        intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * 忘记密码
     * @param view
     */
    public void ForgetPasswordClick(View view){
        intent=new Intent(this,ForgetPasswordActivity.class);
        startActivity(intent);
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
    class RequestData extends AsyncTask<String,Void,LoginItem>{

        private  Map<String, String> map;
        public RequestData(Map<String, String> map) {
            this.map=map;
        }

        @Override
        protected LoginItem doInBackground(String... params) {
            LoginItem item =null;
            try {
                String result= HttpHelper.doRequestForString(LoginActivity.this,getString(R.string.base_url),HttpHelper.HTTP_POST ,map);
                item = new Gson().fromJson(result,LoginItem.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return item;
        }

        @Override
        protected void onPostExecute(LoginItem result) {
            super.onPostExecute(result);
            mLoadingDialog.dismiss();
            if(result!=null){
                if(result.isSuccess()){
                    ToastUtils.showToastShort(LoginActivity.this,"Success");
                    intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
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
