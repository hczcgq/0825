package com.lawyer.android.activity;

import android.os.Bundle;
import android.view.View;

import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;

/**
 * Created by chenguoquan on 8/27/15.
 */
public class PersonActivity extends BaseUIActivity{

    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_person);

        initView();
    }

    //初始化控件
    private void initView() {
        //标题
        setHeadTitle(R.string.person);
        showLeftButton();
        addLeftButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
