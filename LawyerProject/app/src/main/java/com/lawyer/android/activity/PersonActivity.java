package com.lawyer.android.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;
import com.lawyer.android.bean.LawyerItem;
import com.lawyer.android.http.HttpHelper;
import com.lawyer.android.http.httpUtils;
import com.lawyer.android.util.Constants;
import com.lawyer.android.util.LoadingDialog;
import com.lawyer.android.util.PreferencesUtils;
import com.lawyer.android.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenguoquan on 8/27/15.
 */
public class PersonActivity extends BaseUIActivity implements View.OnClickListener {

    private static final int REQUEST_GETPERSON = 100;  //{"success":true}
    private static final int REQUEST_UPDATEPERSON = 101;
    private RequestData mRequestData;
    private Intent intent;
    private LoadingDialog mLoadingDialog;
    private ImageView avaterImageView;
    private TextView updatePasswordTextView;  //修改密码
    private TextView nameTextView, firmTextView, numberTextView, yearTextView,
            typeTextView, desTextView, eduTextView, genderTextView, addressTextView;
    private String lawyerID;
    private String mac;

    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_person);

        initView();
        initEvent();
        initData();

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
        mLoadingDialog = new LoadingDialog(this);


        avaterImageView = (ImageView) findViewById(R.id.avaterImageView);
        updatePasswordTextView = (TextView) findViewById(R.id.updatePasswordTextView);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        firmTextView = (TextView) findViewById(R.id.firmTextView);
        numberTextView = (TextView) findViewById(R.id.numberTextView);
        yearTextView = (TextView) findViewById(R.id.yearTextView);
        typeTextView = (TextView) findViewById(R.id.typeTextView);
        desTextView = (TextView) findViewById(R.id.desTextView);
        eduTextView = (TextView) findViewById(R.id.eduTextView);
        genderTextView = (TextView) findViewById(R.id.genderTextView);
        addressTextView = (TextView) findViewById(R.id.addressTextView);

    }

    private void initEvent() {
        avaterImageView.setOnClickListener(this);
        updatePasswordTextView.setOnClickListener(this);
    }

    private void initData() {
        lawyerID = PreferencesUtils.getString(this, Constants.PRE_LAWYERID);
        Map<String, String> map = new HashMap<String, String>();
        map.put("v", "1.0");
        map.put("ts", StringUtils.getCurrentTimes());
        map.put("appKey", Constants.APP_KEY);
        map.put("method", getString(R.string.lawyer_get_url));
        map.put("lawyerId", lawyerID);
        map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
        loadDate(REQUEST_GETPERSON, map);
    }


    /**
     * 加载数据
     *
     * @param request_code 请求类型
     * @param map
     */
    private void loadDate(int request_code, Map<String, String> map) {
        if (mRequestData != null
                && mRequestData.getStatus() != AsyncTask.Status.FINISHED)
            mRequestData.cancel(true);
        mRequestData = new RequestData(request_code, map);
        mRequestData.execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.avaterImageView:
                break;
            case R.id.updatePasswordTextView:
                intent = new Intent(this, UpdatePasswordActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void LogoutClick(View view) {
//        lawyerID= PreferencesUtils.getString(this, Constants.PRE_LAWYERID);
//        mac=PreferencesUtils.getString(PersonActivity.this,Constants.PRE_MAC);
//        Map<String, String> map=new HashMap<String, String>();
//        map.put("v","1.0");
//        map.put("ts", StringUtils.getCurrentTimes());
//        map.put("appKey", Constants.APP_KEY);
//        map.put("method", getString(R.string.lawyer_update_url));
//        map.put("id",lawyerID);
//        map.put("mac",mac);
//        map.put("name","chenguoquan");
//        map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
//        loadDate(REQUEST_GETPERSON,map);

        PreferencesUtils.putString(this, Constants.PRE_MOBILE, "");
        PreferencesUtils.putString(this, Constants.PRE_PASSWORD, "");
        PreferencesUtils.putString(this, Constants.PRE_LAWYERID, "");

//        setResult(MainActivity.REQUEST_CODE);
//        finish();

        Intent intent = new Intent(PersonActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    class RequestData extends AsyncTask<String, Void, LawyerItem> {
        private int request_code;
        private Map<String, String> map;

        public RequestData(int request_code, Map<String, String> map) {
            this.request_code = request_code;
            this.map = map;
        }

        @Override
        protected LawyerItem doInBackground(String... params) {
            LawyerItem item = null;
            try {
                String result = HttpHelper.doRequestForString(PersonActivity.this, getString(R.string.base_url), HttpHelper.HTTP_POST, map);
                item = new Gson().fromJson(result, LawyerItem.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return item;
        }

        @Override
        protected void onPostExecute(LawyerItem result) {
            super.onPostExecute(result);

            if(result!=null&&result.isSuccess()){
                LawyerItem.LawyerEntity entity=result.getLawyer();
                nameTextView.setText(entity.getName());
            }
            mLoadingDialog.dismiss();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mLoadingDialog.dialogShow();
        }
    }
}
