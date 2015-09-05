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
 * 登录
 *
 * Created by chenguoquan on 2015/8/26.
 */
public class LoginActivity extends BaseUIActivity{

    private RequestData mRequestData;

    private LoadingDialog mLoadingDialog;

    private Intent intent;

    private TextView mobileEditText,passwordEditText;

    public static final int REQUEST_REGISTER=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);

        initView();
    }

    /**
     * 初始化控件
     */
    private void initView(){
        //标题
        setHeadTitle(R.string.login_title);

        mLoadingDialog=new LoadingDialog(this);
        mobileEditText= (TextView) findViewById(R.id.mobileEditText);
        passwordEditText= (TextView) findViewById(R.id.passwordEditText);
    }


    /**
     * 登录点击
     * @param view
     */
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
        loadDate(map);
    }


    /**
     * 注册
     * @param view
     */
    public void RegisterClick(View view){
        intent=new Intent(this,RegisterActivity.class);
//        startActivity(intent);
        startActivityForResult(intent,REQUEST_REGISTER);
    }

    /**
     * 忘记密码
     * @param view
     */
    public void ForgetPasswordClick(View view){
        intent=new Intent(this,ForgetPasswordActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_REGISTER&&resultCode==REQUEST_REGISTER){
            finish();
        }
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
    class RequestData extends AsyncTask<String,Void,PersonEntity>{

        private  Map<String, String> map;
        public RequestData(Map<String, String> map) {
            this.map=map;
        }

        @Override
        protected PersonEntity doInBackground(String... params) {
            PersonEntity item =null;
            try {
                String result= HttpHelper.doRequestForString(LoginActivity.this,getString(R.string.base_url),HttpHelper.HTTP_POST ,map);
                Log.e("---",result);
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
                    //保存用户名和密码
                    PreferencesUtils.putString(LoginActivity.this, Constants.PRE_MOBILE, mobileEditText.getText().toString());
                    PreferencesUtils.putString(LoginActivity.this,Constants.PRE_PASSWORD,passwordEditText.getText().toString());
                    //保存律师ID
                    PreferencesUtils.putString(LoginActivity.this, Constants.PRE_LAWYERID, result.getLawyer().getId()+"");
                    PreferencesUtils.putString(LoginActivity.this,Constants.PRE_MAC,result.getLawyer().getMac());
                    finish();
                }else{
                    ToastUtils.showToastShort(LoginActivity.this,result.getMessage());
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
