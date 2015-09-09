package com.lawyer.android.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;
import com.lawyer.android.bean.AdviceEntity;
import com.lawyer.android.util.StringUtils;

/**
 * Created by chenguoquan on 9/6/15.
 */
public class UserActivity extends BaseUIActivity{


    private TextView nameTextView,nickNameTextView,mobileTextView,idCardTextView;

    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_user);

        initView();
        initData();

    }

    //初始化控件
    private void initView() {
        //标题
        setHeadTitle(R.string.user);
        showLeftButton();
        addLeftButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        nameTextView = (TextView) findViewById(R.id.nameTextView);
        nickNameTextView = (TextView) findViewById(R.id.nickNameTextView);
        mobileTextView = (TextView) findViewById(R.id.mobileTextView);
        idCardTextView = (TextView) findViewById(R.id.idCardTextView);

    }


    private void initData() {
        AdviceEntity.ConsultsEntity.UserEntity userEntity= (AdviceEntity.ConsultsEntity.UserEntity) getIntent().getSerializableExtra("User");
        nameTextView.setText(userEntity.getName());
        if(!StringUtils.isEmpty(userEntity.getName())) {
            nickNameTextView.setText(userEntity.getName());
        }
        mobileTextView.setText(userEntity.getMobile());
        idCardTextView.setText(userEntity.getIdCard());
    }
}
