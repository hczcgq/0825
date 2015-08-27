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
import com.lawyer.android.util.Constants;
import com.lawyer.android.util.StringUtils;
import com.lawyer.android.util.ToastUtils;

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

        new GetDataTask().execute();
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


        intent=new Intent(this,MainActivity.class);
        startActivity(intent);


//

        new LoginTask(mobile,password).execute();




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


        @Override
        protected String doInBackground(String... params) {
            String appSecret="fdsh4vrFDSvjfds94";
            Map<String, String> map=new HashMap<String, String>();
            String ts=String.valueOf(System.currentTimeMillis());
            map.put("v","1.0");
            map.put("ts",ts);
            map.put("appKey","ios01");
            map.put("method","item.get");
            map.put("itemId", "1");
            map.put("sign", httpUtils.sign(map,appSecret));

            try {
                String result= HttpHelper.doRequestForString(LoginActivity.this,"http://api.shuofatang.com/router",HttpHelper.HTTP_POST ,map);
                Log.e("---",result);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /**
     * 登录请求
     */
    class LoginTask extends AsyncTask<String,Void,String>{

        private String mobile,password;

        public LoginTask(String mobile, String password) {
            this.mobile=mobile;
            this.password=password;
        }

        @Override
        protected String doInBackground(String... params) {
            String result="";
            Map<String, String> map=new HashMap<String, String>();
            map.put("v","1.0");
            map.put("ts",StringUtils.getCurrentTimes());
            map.put("appKey", Constants.APP_KEY);
            map.put("method",getString(R.string.lawyer_login_url));
            map.put("loginCode", mobile);
            map.put("password", password);
            map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
            try {
                result= HttpHelper.doRequestForString(LoginActivity.this,getString(R.string.base_url),HttpHelper.HTTP_POST ,map);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }


    }
}
