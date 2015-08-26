package com.lawyer.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.lawyer.android.R;
import com.lawyer.android.util.Constants;
import com.lawyer.android.util.PreferencesUtils;


public class SplashActivity extends Activity {

    private Intent intent;
    private boolean isFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.view_splash);

        isFirst= PreferencesUtils.checkExist(this, Constants.ISFIRST);

        if (isFirst) { //首次进入进入到引导页
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // 设置跳转的Intent
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
        } else {   //跳转到登录页
            PreferencesUtils.putBoolean(this,Constants.ISFIRST,true);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    intent = new Intent(SplashActivity.this,
                            GuideActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, 2000);
        }
    }
}
