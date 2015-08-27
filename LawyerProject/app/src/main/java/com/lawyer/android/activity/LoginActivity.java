package com.lawyer.android.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;
import com.lawyer.android.http.HttpHelper;
import com.lawyer.android.http.httpUtils;
import com.lawyer.android.util.StringUtils;
import com.lawyer.android.util.ToastUtils;

import org.apache.http.protocol.HTTP;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class LoginActivity extends BaseUIActivity{

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



//        intent=new Intent(this,MainActivity.class);
//        startActivity(intent);

        String appSecret="fdsh4vrFDSvjfds94";
        Map<String, String> params=new HashMap<String, String>();
        String ts=String.valueOf(System.currentTimeMillis());
        params.put("v","1.0");
        params.put("ts",ts);
        params.put("appKey","ios01");
        params.put("method","item.get");
        params.put("itemId", "1");
        params.put("sign", httpUtils.sign(params,appSecret));

        new GetDataTask(params).execute();



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


    class GetDataTask extends AsyncTask<String,Void,String>{

        private Map<String, String> paramsmap;

        public GetDataTask(Map<String, String> paramsmap) {
            this.paramsmap=paramsmap;
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                String result= HttpHelper.doRequestForString(LoginActivity.this,"http://api.shuofatang.com/router",HttpHelper.HTTP_POST ,paramsmap);
                Log.e("---",result);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
