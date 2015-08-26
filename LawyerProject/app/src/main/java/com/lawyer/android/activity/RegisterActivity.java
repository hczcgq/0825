package com.lawyer.android.activity;

import android.os.Bundle;
import android.view.View;

import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class RegisterActivity extends BaseUIActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_register);

        initView();
    }

    private void initView(){
        setHeadTitle(R.string.register);
        showLeftButton();
        addLeftButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
