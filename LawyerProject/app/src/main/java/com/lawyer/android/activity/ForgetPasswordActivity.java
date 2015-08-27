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
public class ForgetPasswordActivity extends BaseUIActivity{

    private EditText mobileEditText,verifyEditText,passwordEditText;

    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_forget_password);
        initView();
    }

    private void initView(){
        //设置标题
        setHeadTitle(R.string.forget_password);
        showLeftButton();
        addLeftButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mobileEditText= (EditText) findViewById(R.id.mobileEditText);
        verifyEditText= (EditText) findViewById(R.id.verifyEditText);
        passwordEditText= (EditText) findViewById(R.id.passwordEditText);
    }


    /**
     * 获取验证码
     * @param view
     */
    public void VeviryClick(View view){
        String mobile=mobileEditText.getText().toString();
        if(StringUtils.isEmpty(mobile)){
            ToastUtils.showToastShort(this,R.string.input_mobile);
            return;
        }

        //TODO
    }

    /**
     * 确认提交
     * @param view
     */
    public void ConfirmClick(View view){
        String mobile=mobileEditText.getText().toString();
        String verify=verifyEditText.getText().toString();
        String password=passwordEditText.getText().toString();

        if(StringUtils.isEmpty(mobile)){
            ToastUtils.showToastShort(this,R.string.input_mobile);
            return;
        }
        if(StringUtils.isEmpty(verify)){
            ToastUtils.showToastShort(this,R.string.input_veviry);
            return;
        }
        if(StringUtils.isEmpty(password)){
            ToastUtils.showToastShort(this,R.string.input_password);
            return;
        }

        //TODO

    }
}
