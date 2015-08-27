package com.lawyer.android.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;
import com.lawyer.android.util.StringUtils;
import com.lawyer.android.util.ToastUtils;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class FeedbackActivity extends BaseUIActivity{


    private EditText feedbackEditText;


    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_feedback);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView(){
        //标题控件
        setHeadTitle(R.string.feedback);
        showLeftButton();
        addLeftButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        feedbackEditText= (EditText) findViewById(R.id.feedbackEditText);
    }

    public void submitClick(View view){
        String message=feedbackEditText.getText().toString();

        if(StringUtils.isEmpty(message)){
            ToastUtils.showToastShort(this,R.string.feedback_des_is_empty);
            return;
        }
    }
}

