package com.lawyer.android.activity;

import android.os.Bundle;
import android.view.View;

import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class ForgetPasswordActivity extends BaseUIActivity{

    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_forget_password);
        initView();
    }

    private void initView(){
        setHeadTitle(R.string.forget_password);
        showLeftButton();
        addLeftButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
