package com.lawyer.android.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;
import com.lawyer.android.bean.SuccessEntity;
import com.lawyer.android.http.HttpHelper;
import com.lawyer.android.http.httpUtils;
import com.lawyer.android.util.Constants;
import com.lawyer.android.util.LoadingDialog;
import com.lawyer.android.util.PreferencesUtils;
import com.lawyer.android.util.StringUtils;
import com.lawyer.android.util.ToastUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 修改密码
 * Created by chenguoquan on 8/29/15.
 */
public class UpdatePasswordActivity extends BaseUIActivity{
    private RequestData mRequestData;
    private LoadingDialog mLoadingDialog;

    private TextView oldPasswordEditText;
    private TextView newPasswordEditText;
    private TextView confirmNewPasswordEditText;

    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_update_password);

        initView();

    }

    /**
     * 初始化控件
     */
    private void initView(){
        setHeadTitle(R.string.update_password);
        showLeftButton();
        addLeftButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mLoadingDialog=new LoadingDialog(this);
        oldPasswordEditText= (TextView) findViewById(R.id.oldPasswordEditText);
        newPasswordEditText= (TextView) findViewById(R.id.newPasswordEditText);
        confirmNewPasswordEditText= (TextView) findViewById(R.id.confirmNewPasswordEditText);
    }


    /**
     * 修改点击
     * @param view
     */
    public void ConfirmClick(View view){
        String lawyerId= PreferencesUtils.getString(this, Constants.PRE_LAWYERID);
        String mac=PreferencesUtils.getString(this,Constants.PRE_MAC);
        String password=PreferencesUtils.getString(this,Constants.PRE_PASSWORD);

        String oldPassword=oldPasswordEditText.getText().toString();
        String newPassword=newPasswordEditText.getText().toString();
        String confirmPassword=confirmNewPasswordEditText.getText().toString();


        if(StringUtils.isEmpty(oldPassword)){
            ToastUtils.showToastShort(this, R.string.input_old_passowrd);
            return;
        }

        if(!password.equals(oldPassword)){
            ToastUtils.showToastShort(this, R.string.input_old_passowrd_error);
            return;
        }

        if(StringUtils.isEmpty(newPassword)){
            ToastUtils.showToastShort(this, R.string.input_new_passowrd);
            return;
        }
        if(newPassword.equals(oldPassword)){
            ToastUtils.showToastShort(this, R.string.old_passowrd_equle_new);
            return;
        }
        if(StringUtils.isEmpty(confirmPassword)){
            ToastUtils.showToastShort(this, R.string.input_confirm_new_passowrd);
            return;
        }
        if(!confirmPassword.equals(newPassword)){
            ToastUtils.showToastShort(this, R.string.input_two_new_passowrd_no_equle);
            return;
        }


        //TODO
        Map<String, String> map=new HashMap<String, String>();
        map.put("v","1.0");
        map.put("ts",StringUtils.getCurrentTimes());
        map.put("appKey", Constants.APP_KEY);
        map.put("method", getString(R.string.lawyer_update_password_url));
        map.put("lawyerId", lawyerId);
        map.put("password", newPassword);
        map.put("mac", mac);
        map.put("nvl", "true");
        map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
        loadDate(map);

    }

    /**
     * 加载数据
     * @param map
     */
    private void loadDate(Map<String, String> map) {
        if (mRequestData != null
                && mRequestData.getStatus() != AsyncTask.Status.FINISHED)
            mRequestData.cancel(true);
        mRequestData = new RequestData(map);
        mRequestData.execute();
    }


    /**
     * 请求数据
     */
    class RequestData extends AsyncTask<String,Void ,SuccessEntity> {
        private Map<String, String> map;

        public RequestData(Map<String, String> map) {
            this.map=map;
        }

        @Override
        protected SuccessEntity doInBackground(String... params) {
            SuccessEntity item=null;
            try {
                String result= HttpHelper.doRequestForString(UpdatePasswordActivity.this, getString(R.string.base_url), HttpHelper.HTTP_POST, map);
                item=new Gson().fromJson(result,SuccessEntity.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  item;
        }

        @Override
        protected void onPostExecute(SuccessEntity result) {
            super.onPostExecute(result);
            mLoadingDialog.dismiss();
            if(result!=null){
                if(result.getSuccess()){
                    PreferencesUtils.putString(UpdatePasswordActivity.this,Constants.PRE_PASSWORD,newPasswordEditText.getText().toString());
                    ToastUtils.showToastShort(UpdatePasswordActivity.this,"修改成功");
                    finish();
                }else{
                    ToastUtils.showToastShort(UpdatePasswordActivity.this,result.getMessage());
                }
            }

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingDialog.dialogShow();
        }
    }
}
