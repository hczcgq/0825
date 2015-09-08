package com.lawyer.android.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.Gson;
import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;
import com.lawyer.android.bean.PersonEntity;
import com.lawyer.android.http.FileHelper;
import com.lawyer.android.http.HttpHelper;
import com.lawyer.android.http.httpUtils;
import com.lawyer.android.util.AppUtils;
import com.lawyer.android.util.Constants;
import com.lawyer.android.util.LoadingDialog;
import com.lawyer.android.util.PreferencesUtils;
import com.lawyer.android.util.StringUtils;
import com.lawyer.android.util.ToastUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by chenguoquan on 8/27/15.
 */
public class PersonActivity extends BaseUIActivity implements View.OnClickListener {

    private static final int REQUEST_GETPERSON = 100;  //{"success":true}
    private static final int REQUEST_UPDATEPERSON = 101;
    private static final int REQUEST_UPDATEPERSONAVATER = 102;

    public static final int CODE_AVATER = 110;
    public static final int CODE_NAME = 111;
    public static final int CODE_BIRTHDAY = 112;
    public static final int CODE_SEX = 113;
    public static final int CODE_FIRST_PRACTICETIME = 114;
    public static final int CODE_EXPERTH = 115;
    public static final int CODE_MOBILE = 116;
    public static final int CODE_TEL = 117;
    public static final int CODE_CERTIFICATENO = 118;
    public static final int CODE_IDCARD = 119;
    public static final int CODE_FIRMNAME = 120;
    public static final int CODE_DATE = 121;


    private RequestData mRequestData;
    private Intent intent;
    private LoadingDialog mLoadingDialog;
    private ImageView avaterImageView;  //头像
    private TextView updatePasswordTextView;  //修改密码
    private TextView nameTextView, birthdayTextView, sexTextView, firstPracticeTimeTextView,
            expertInTextView, mobileTextView, telTextView, lawyerCertificateNoTextView, idCardTextView, lawFirmNameTextView;
    private String lawyerID;
    private String mac;

    private String image_path;//图像地址

    private PersonEntity.LawyerEntity temLawyerEntity;

    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_person);
        imageLoader = ImageLoader.getInstance();

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
        birthdayTextView = (TextView) findViewById(R.id.birthdayTextView);
        sexTextView = (TextView) findViewById(R.id.sexTextView);
        firstPracticeTimeTextView = (TextView) findViewById(R.id.firstPracticeTimeTextView);
        expertInTextView = (TextView) findViewById(R.id.expertInTextView);
        mobileTextView = (TextView) findViewById(R.id.mobileTextView);
        telTextView = (TextView) findViewById(R.id.telTextView);
        lawyerCertificateNoTextView = (TextView) findViewById(R.id.lawyerCertificateNoTextView);
        idCardTextView = (TextView) findViewById(R.id.idCardTextView);
        lawFirmNameTextView = (TextView) findViewById(R.id.lawFirmNameTextView);

    }

    private void initEvent() {
        avaterImageView.setOnClickListener(this);
        updatePasswordTextView.setOnClickListener(this);
        nameTextView.setOnClickListener(this);
        birthdayTextView.setOnClickListener(this);
        sexTextView.setOnClickListener(this);
        firstPracticeTimeTextView.setOnClickListener(this);
        expertInTextView.setOnClickListener(this);
        mobileTextView.setOnClickListener(this);
        telTextView.setOnClickListener(this);
        lawyerCertificateNoTextView.setOnClickListener(this);
        idCardTextView.setOnClickListener(this);
        lawFirmNameTextView.setOnClickListener(this);
    }

    private void initData() {
        image_path=Constants.SEND_IMAGE_PATH + "temp.jpg";
        if(!StringUtils.isEmpty(image_path)){
            String url="file:///"+image_path;
            imageLoader.displayImage(url, avaterImageView, options);
        }


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
                intent = new Intent(this, SelectDialogActivity.class);
                startActivityForResult(intent, CODE_AVATER);
                break;
            case R.id.updatePasswordTextView:
                intent = new Intent(this, UpdatePasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.nameTextView:
                intent = new Intent(this, UpdatePersonActivity.class);
                intent.putExtra("tag", CODE_NAME);
                intent.putExtra("name",nameTextView.getText().toString());
                startActivityForResult(intent, CODE_NAME);
                break;
            case R.id.birthdayTextView:
                intent = new Intent(this, DateDialogAvtivity.class);
                intent.putExtra("day", birthdayTextView.getText().toString());
                startActivityForResult(intent, CODE_BIRTHDAY);
                overridePendingTransition(R.anim.push_bottom_in,
                        R.anim.push_bottom_out);
                break;
            case R.id.sexTextView:
                intent = new Intent(this,
                        WheelDialogAvtivity.class);
                intent.putExtra("Tag", Constants.WHEEL_SEX);
                startActivityForResult(intent, CODE_SEX);
                overridePendingTransition(R.anim.push_bottom_in,
                        R.anim.push_bottom_out);
                break;
            case R.id.firstPracticeTimeTextView:
                intent = new Intent(this, DateDialogAvtivity.class);
                intent.putExtra("day", firstPracticeTimeTextView.getText().toString());
                startActivityForResult(intent, CODE_FIRST_PRACTICETIME);
                overridePendingTransition(R.anim.push_bottom_in,
                        R.anim.push_bottom_out);
                break;
            case R.id.expertInTextView:
                intent = new Intent(this, UpdatePersonActivity.class);
                intent.putExtra("tag", CODE_EXPERTH);
                intent.putExtra("name",expertInTextView.getText().toString());
                startActivityForResult(intent, CODE_EXPERTH);
                break;
            case R.id.mobileTextView:
                intent = new Intent(this, UpdatePersonActivity.class);
                intent.putExtra("tag", CODE_MOBILE);
                intent.putExtra("name",mobileTextView.getText().toString());
                startActivityForResult(intent, CODE_MOBILE);
                break;
            case R.id.telTextView:
                intent = new Intent(this, UpdatePersonActivity.class);
                intent.putExtra("tag", CODE_TEL);
                intent.putExtra("name",telTextView.getText().toString());
                startActivityForResult(intent, CODE_TEL);
                break;
            case R.id.lawyerCertificateNoTextView:
                intent = new Intent(this, UpdatePersonActivity.class);
                intent.putExtra("tag", CODE_CERTIFICATENO);
                intent.putExtra("name",lawyerCertificateNoTextView.getText().toString());
                startActivityForResult(intent, CODE_CERTIFICATENO);
                break;
            case R.id.idCardTextView:
                intent = new Intent(this, UpdatePersonActivity.class);
                intent.putExtra("tag", CODE_IDCARD);
                intent.putExtra("name",idCardTextView.getText().toString());
                startActivityForResult(intent, CODE_IDCARD);
                break;
            case R.id.lawFirmNameTextView:
                intent = new Intent(this, UpdatePersonActivity.class);
                intent.putExtra("tag", CODE_FIRMNAME);
                intent.putExtra("name",lawFirmNameTextView.getText().toString());
                startActivityForResult(intent, CODE_FIRMNAME);
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
        if (requestCode == CODE_AVATER && resultCode == CODE_AVATER) { //头像
            image_path = data.getStringExtra("image");
            if(StringUtils.isEmpty(image_path)){
                return;
            }
            map.put("photo", "photo");
            map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
            loadDate(REQUEST_UPDATEPERSONAVATER, map);
            Log.e("Avater:", image_path);
        } else if (requestCode == CODE_NAME && resultCode == CODE_NAME) {//姓名
            String name = data.getStringExtra("name");
            nameTextView.setText(name);
            map.put("name", name);
            map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
            loadDate(REQUEST_UPDATEPERSON, map);
        } else if (requestCode == CODE_BIRTHDAY && resultCode == CODE_DATE) {
            String birthday=data.getStringExtra("day");
            birthdayTextView.setText(birthday);
            map.put("birthday", String.valueOf(birthday));
            map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
            loadDate(REQUEST_UPDATEPERSON, map);
        } else if (requestCode == CODE_SEX && resultCode == CODE_SEX) {//性别
            String sex = data.getStringExtra("name");
            sexTextView.setText(sex);
            map.put("sex", sex);
            map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
            loadDate(REQUEST_UPDATEPERSON, map);
        } else if (requestCode == CODE_FIRST_PRACTICETIME && resultCode == CODE_DATE) {
            String firstPracticeTime=data.getStringExtra("day");
            firstPracticeTimeTextView.setText(firstPracticeTime);
            map.put("firstPracticeTime", String.valueOf(firstPracticeTime));
            map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
            loadDate(REQUEST_UPDATEPERSON, map);
        } else if (requestCode == CODE_EXPERTH && resultCode == CODE_EXPERTH) {
            String expertIn = data.getStringExtra("name");
            expertInTextView.setText(expertIn);
            map.put("expertIn", expertIn);
            map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
            loadDate(REQUEST_UPDATEPERSON, map);
        } else if (requestCode == CODE_MOBILE && resultCode == CODE_MOBILE) {
            String mobile = data.getStringExtra("name");
            mobileTextView.setText(mobile);
            map.put("mobile", mobile);
            map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
            loadDate(REQUEST_UPDATEPERSON, map);
        } else if (requestCode == CODE_TEL && resultCode == CODE_TEL) {
            String tel = data.getStringExtra("name");
            telTextView.setText(tel);
            map.put("tel", tel);
            map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
            loadDate(REQUEST_UPDATEPERSON, map);
        } else if (requestCode == CODE_CERTIFICATENO && resultCode == CODE_CERTIFICATENO) {
            String lawyerCertificateNo = data.getStringExtra("name");
            lawyerCertificateNoTextView.setText(lawyerCertificateNo);
            map.put("lawyerCertificateNo", lawyerCertificateNo);
            map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
            loadDate(REQUEST_UPDATEPERSON, map);
        } else if (requestCode == CODE_IDCARD && resultCode == CODE_IDCARD) {
            String idCard = data.getStringExtra("name");
            idCardTextView.setText(idCard);
            map.put("idCard", idCard);
            map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
            loadDate(REQUEST_UPDATEPERSON, map);
        } else if (requestCode == CODE_FIRMNAME && resultCode == CODE_FIRMNAME) {
            String lawFirmName = data.getStringExtra("name");
            lawFirmNameTextView.setText(lawFirmName);
            map.put("lawfirm", lawFirmName);
            map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
            loadDate(REQUEST_UPDATEPERSON, map);
        } else {
            return;
        }

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


    class RequestData extends AsyncTask<String, Void, PersonEntity> {
        private int request_code;
        private Map<String, String> map;

        public RequestData(int request_code, Map<String, String> map) {
            this.request_code = request_code;
            this.map = map;
        }

        @Override
        protected PersonEntity doInBackground(String... params) {
            PersonEntity item = null;
            try {
                if (request_code == REQUEST_UPDATEPERSONAVATER) {
                    String result = FileHelper.uploadHttpClient(PersonActivity.this, getString(R.string.base_url), map, image_path);
                    item = new Gson().fromJson(result, PersonEntity.class);
                } else {
                    String result = HttpHelper.doRequestForString(PersonActivity.this, getString(R.string.base_url), HttpHelper.HTTP_POST, map);
                    item = new Gson().fromJson(result, PersonEntity.class);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return item;
        }

        @Override
        protected void onPostExecute(PersonEntity result) {
            super.onPostExecute(result);
            if (result != null && result.getSuccess()) {
                if (request_code == REQUEST_GETPERSON) {
                    PersonEntity.LawyerEntity entity = result.getLawyer();
                    temLawyerEntity=entity;
                    showContent(entity,request_code);
                } else if (request_code == REQUEST_UPDATEPERSON) {
                    ToastUtils.showToastShort(PersonActivity.this, "修改成功");
                }else if (request_code == REQUEST_UPDATEPERSONAVATER) {
                    String url="file:///"+Constants.SEND_IMAGE_PATH + "temp.jpg";;
                    imageLoader.displayImage(url, avaterImageView, options);
                }
            } else {
                if (result != null) {
                    ToastUtils.showToastShort(PersonActivity.this, result.getMessage());
                }
                if (request_code == REQUEST_UPDATEPERSON) {
                    showContent(temLawyerEntity,request_code);
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

    private void showContent(PersonEntity.LawyerEntity entity,int request_code){
        if(entity!=null) {
            nameTextView.setText(entity.getName());
            if (entity.getBirthday() != 0) {
                birthdayTextView.setText(AppUtils.formatValidLongToDate(entity.getBirthday(),0));
            }
            sexTextView.setText(entity.getSex());
            if (entity.getFirstPracticeTime() != 0) {
                firstPracticeTimeTextView.setText(AppUtils.formatValidLongToDate(entity.getFirstPracticeTime(),0));
            }
            expertInTextView.setText(entity.getExpertIn());
            mobileTextView.setText(entity.getMobile());
            telTextView.setText(entity.getTel());
            lawyerCertificateNoTextView.setText(entity.getLawyerCertificateNo());
            idCardTextView.setText(entity.getIdCard());

            if (request_code == REQUEST_UPDATEPERSONAVATER) {
                String url="file:///"+image_path;
                imageLoader.displayImage(url, avaterImageView, options);
            } else {
                imageLoader.displayImage(entity.getUserLogoUrl(), avaterImageView, options);
            }
        }
    }
}
