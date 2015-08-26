package com.lawyer.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class LoginActivity extends BaseUIActivity{

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);

        setHeadTitle(R.string.login_title);

    }


    public void loginClick(View view){
        intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }


    /**
     * 注册
     * @param view
     */
    public void registerClick(View view){
        intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    /**
     * 忘记密码
     * @param view
     */
    public void forgetPasswordClick(View view){
        intent=new Intent(this,ForgetPasswordActivity.class);
        startActivity(intent);
    }
}
