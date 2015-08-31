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
import com.lawyer.android.util.ToastUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenguoquan on 8/27/15.
 */
public class PersonActivity extends BaseUIActivity implements View.OnClickListener {

    private static final int REQUEST_GETPERSON = 100;  //{"success":true}
    private static final int REQUEST_UPDATEPERSON = 101;

    public static final int CODE_NAME = 101;
    public static final int CODE_FIRM = 102;
    public static final int CODE_GENDER = 103;
    public static final int CODE_EDU = 104;

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
        nameTextView.setOnClickListener(this);
        firmTextView.setOnClickListener(this);
        eduTextView.setOnClickListener(this);
        genderTextView.setOnClickListener(this);
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.avaterImageView:
                break;
            case R.id.updatePasswordTextView:
                intent = new Intent(this, UpdatePasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.nameTextView:
                intent = new Intent(this, UpdatePersonActivity.class);
                intent.putExtra("tag", CODE_NAME);
                startActivityForResult(intent, CODE_NAME);
                break;
            case R.id.firmTextView:
                intent = new Intent(this, UpdatePersonActivity.class);
                intent.putExtra("tag", CODE_FIRM);
                startActivityForResult(intent, CODE_FIRM);
                break;
            case R.id.genderTextView:
                intent = new Intent(this,
                        WheelDialogAvtivity.class);
                intent.putExtra("Tag", Constants.WHEEL_SEX);
                startActivityForResult(intent, CODE_GENDER);
                overridePendingTransition(R.anim.push_bottom_in,
                        R.anim.push_bottom_out);
                break;
            case R.id.eduTextView:
                intent = new Intent(this,
                        WheelDialogAvtivity.class);
                intent.putExtra("Tag", Constants.WHEEL_EDU);
                startActivityForResult(intent, CODE_EDU);
                overridePendingTransition(R.anim.push_bottom_in,
                        R.anim.push_bottom_out);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        lawyerID = PreferencesUtils.getString(this, Constants.PRE_LAWYERID);
        mac = PreferencesUtils.getString(PersonActivity.this, Constants.PRE_MAC);
        Map<String, String> map = new HashMap<String, String>();
        map.put("v", "1.0");
        map.put("ts", StringUtils.getCurrentTimes());
        map.put("appKey", Constants.APP_KEY);
        map.put("method", getString(R.string.lawyer_update_url));
        map.put("id", lawyerID);
        map.put("mac", mac);
        if (requestCode == CODE_NAME && resultCode == CODE_NAME) {
            String name = data.getStringExtra("name");
            map.put("name", name);
        }if (requestCode == CODE_FIRM && resultCode == CODE_FIRM) {
            String name = data.getStringExtra("name");
            map.put("lawFirmName", name);
        }  else if (requestCode == CODE_GENDER && resultCode == CODE_GENDER) {
            String name = data.getStringExtra("name");
            map.put("sex", name);
        }
        map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
        loadDate(REQUEST_UPDATEPERSON, map);
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


    /**
     * 登出
     *
     * @param view
     */
    public void LogoutClick(View view) {
        PreferencesUtils.putString(this, Constants.PRE_MOBILE, "");
        PreferencesUtils.putString(this, Constants.PRE_PASSWORD, "");
        PreferencesUtils.putString(this, Constants.PRE_LAWYERID, "");
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
            if (result != null && result.isSuccess()) {
                if(request_code==REQUEST_GETPERSON) {
                    LawyerItem.LawyerEntity entity = result.getLawyer();
                    nameTextView.setText(entity.getName());
//                    firmTextView.setText(entity.g);
                    genderTextView.setText(entity.getSex());
                }else if(request_code==REQUEST_GETPERSON){
                    nameTextView.setText(map.get("name"));
                    firmTextView.setText(map.get("lawFirmName"));
                    genderTextView.setText(map.get("sex"));
                }
            }else{
                if(result!=null){
                    ToastUtils.showToastShort(PersonActivity.this,result.getMessage());
                }
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
