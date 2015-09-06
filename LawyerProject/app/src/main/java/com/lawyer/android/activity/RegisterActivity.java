package com.lawyer.android.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;
import com.lawyer.android.bean.PersonEntity;
import com.lawyer.android.http.HttpHelper;
import com.lawyer.android.http.httpUtils;
import com.lawyer.android.util.Constants;
import com.lawyer.android.util.LoadingDialog;
import com.lawyer.android.util.PreferencesUtils;
import com.lawyer.android.util.StringUtils;
import com.lawyer.android.util.ToastUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class RegisterActivity extends BaseUIActivity{


    private static final int REQUEST_VALIDATIONCODE=100;  //{"success":true}
    private static final int REQUEST_REGISTER=101; //{"lawyer":{"consultNum":0,"id":2,"loginCode":"18516276648","mac":"3A51F6C84B09630022B257359BBE6E8484325937","orderNum":0,"registerDate":1440755520708,"status":"VALID"},"success":true}
    private RequestData mRequestData;


    private LoadingDialog mLoadingDialog;
    private EditText mobileEditText,verifyEditText,passwordEditText,confirmPasswordEditText;
    private Button vevifyButton;

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

        mLoadingDialog=new LoadingDialog(this);
        mobileEditText= (EditText) findViewById(R.id.mobileEditText);
        verifyEditText= (EditText) findViewById(R.id.verifyEditText);
        passwordEditText= (EditText) findViewById(R.id.passwordEditText);
        confirmPasswordEditText= (EditText) findViewById(R.id.confirmPasswordEditText);
        vevifyButton= (Button) findViewById(R.id.vevifyButton);
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
        if(mobile.length()!=11){
            ToastUtils.showToastShort(this, R.string.input_right_mobile);
            return;
        }

        startTimer();
        addMessageHandler();


        Map<String, String> map=new HashMap<String, String>();
        map.put("v","1.0");
        map.put("ts",StringUtils.getCurrentTimes());
        map.put("appKey", Constants.APP_KEY);
        map.put("method", getString(R.string.lawyer_validationcode_url));
        map.put("cellPhone", mobile);
        map.put("userType", "LAWYER");
        map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
        loadDate(REQUEST_VALIDATIONCODE, map);



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
        Map<String, String> map=new HashMap<String, String>();
        map.put("v","1.0");
        map.put("ts",StringUtils.getCurrentTimes());
        map.put("appKey", Constants.APP_KEY);
        map.put("method", getString(R.string.lawyer_register_url));
        map.put("loginCode", mobile);
        map.put("password", password);
        map.put("verifyCode", verify);
        map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
        loadDate(REQUEST_REGISTER,map);
    }


    /**
     * 加载数据
     * @param request_code 请求类型
     * @param map
     */
    private void loadDate(int request_code, Map<String, String> map) {
        if (mRequestData != null
                && mRequestData.getStatus() != AsyncTask.Status.FINISHED)
            mRequestData.cancel(true);
        mRequestData = new RequestData(request_code,map);
        mRequestData.execute();
    }


    class RequestData extends AsyncTask<String,Void ,PersonEntity> {
        private int request_code;
        private Map<String, String> map;

        public RequestData(int request_code, Map<String, String> map) {
            this.request_code=request_code;
            this.map=map;
        }

        @Override
        protected PersonEntity doInBackground(String... params) {
            PersonEntity item=null;
            try {
               String result=HttpHelper.doRequestForString(RegisterActivity.this, getString(R.string.base_url), HttpHelper.HTTP_POST, map);
                item=new Gson().fromJson(result,PersonEntity.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  item;
        }

        @Override
        protected void onPostExecute(PersonEntity result) {
            super.onPostExecute(result);
            mLoadingDialog.dismiss();
            if(result!=null){
                if(result.getSuccess()){
                    if(request_code==REQUEST_REGISTER){
                        //保存用户名和密码
                        PreferencesUtils.putString(RegisterActivity.this, Constants.PRE_MOBILE, mobileEditText.getText().toString());
                        PreferencesUtils.putString(RegisterActivity.this,Constants.PRE_PASSWORD,passwordEditText.getText().toString());
                        //保存律师ID
                        PreferencesUtils.putString(RegisterActivity.this, Constants.PRE_LAWYERID, result.getLawyer().getId()+"");
                        PreferencesUtils.putString(RegisterActivity.this,Constants.PRE_MAC,result.getLawyer().getMac());
                        setResult(LoginActivity.REQUEST_REGISTER);
                        finish();
                    }
                }else{
                    ToastUtils.showToastShort(RegisterActivity.this,result.getMessage());
                }
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingDialog.dialogShow();
        }
    }

    private Handler iHandler;

    private Timer timer = null;

    private TimerTask timerTask = null;

    private final int LOAD_PROGRESS = 0;

    private final int CLOSE_PROGRESS = 1;

    private int recLen = 60;

    private void addMessageHandler() {
        iHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case LOAD_PROGRESS:
                        vevifyButton.setText(recLen+"");
                        vevifyButton.setEnabled(false);
                        if (recLen == 0) {
                            closeTimer();
                        }
                        break;
                    case CLOSE_PROGRESS:
                        vevifyButton.setText(getString(R.string.verify));
                        vevifyButton.setEnabled(true);
                        break;
                }
                super.handleMessage(msg);
            }
        };
    }


    /**
     * 开始计时器
     */
    private void startTimer() {
        if (timerTask == null) {
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    recLen--;
                    Message msg = new Message();
                    msg.what = LOAD_PROGRESS;
                    msg.arg1 = recLen;
                    iHandler.sendMessage(msg);
                }
            };
            timer = new Timer();
            timer.schedule(timerTask, 1000, 1000);
        }
    }

    /**
     * 关闭计时器
     */
    private void closeTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timerTask != null) {
            timerTask = null;
        }
        recLen = 61;
        iHandler.sendEmptyMessage(CLOSE_PROGRESS);
    }
}
