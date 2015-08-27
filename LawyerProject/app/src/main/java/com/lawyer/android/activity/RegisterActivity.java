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
public class RegisterActivity extends BaseUIActivity{


    private EditText mobileEditText,verifyEditText,passwordEditText,confirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_register);

        initView();
    }

    private void initView(){
        //标题
        setHeadTitle(R.string.register);
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
        confirmPasswordEditText= (EditText) findViewById(R.id.confirmPasswordEditText);
    }

    /**
     * 获取验证码
     * @param view
     */
    public void VerifyClick(View view){
        String mobile=mobileEditText.getText().toString();
        if(StringUtils.isEmpty(mobile)){
            ToastUtils.showToastShort(this, R.string.input_mobile);
            return;
        }

        //TODO
    }

    /**
     * 确认注册
     * @param view
     */
    public void ConfirmClick(View view){
        String mobile=mobileEditText.getText().toString();
        String verify=verifyEditText.getText().toString();
        String password=passwordEditText.getText().toString();
        String repassword=confirmPasswordEditText.getText().toString();

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

        if(StringUtils.isEmpty(repassword)){
            ToastUtils.showToastShort(this,R.string.input_password_again);
            return;
        }

        if(!password.equals(repassword)){
            ToastUtils.showToastShort(this,R.string.input_password_not_eque);
            return;
        }
        //TODO
    }
}
