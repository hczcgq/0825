package com.lawyer.android.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.lawyer.android.R;
import com.lawyer.android.base.BaseUIActivity;
import com.lawyer.android.bean.PersonEntity;
import com.lawyer.android.http.FileHelper;
import com.lawyer.android.http.httpUtils;
import com.lawyer.android.util.Constants;
import com.lawyer.android.util.LoadingDialog;
import com.lawyer.android.util.PreferencesUtils;
import com.lawyer.android.util.StringUtils;
import com.lawyer.android.util.ToastUtils;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenguoquan on 9/14/15.
 */
public class UpdateCertificateActivity extends BaseUIActivity {

    private ImageView ImageView01, ImageView02;
    private LoadingDialog mLoadingDialog;
    private Intent intent;
    public static final int CODE_AVATER1 = 110;
    public static final int CODE_AVATER2 = 111;
    private String image_path1, image_path2;

    private ImageLoader imageLoader;

    private RequestData mRequestData;

    private PersonEntity.LawyerEntity personEntity;

    @Override
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.view_upload_certificate);
        imageLoader = ImageLoader.getInstance();
        personEntity= (PersonEntity.LawyerEntity) getIntent().getSerializableExtra("person");
        initView();

    }

    /**
     * 初始化控件
     */
    private void initView() {
        //标题
        setHeadTitle(R.string.lawyer_upload_certificate);
        showLeftButton();
        addLeftButtonClick(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mLoadingDialog = new LoadingDialog(this);
        ImageView01 = (ImageView) findViewById(R.id.ImageView01);
        ImageView02 = (ImageView) findViewById(R.id.ImageView02);

        ImageView01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(UpdateCertificateActivity.this, SelectDialogActivity.class);
                intent.putExtra("tag", 1);
                startActivityForResult(intent, CODE_AVATER1);
            }
        });

        ImageView02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(UpdateCertificateActivity.this, SelectDialogActivity.class);
                intent.putExtra("tag", 2);
                startActivityForResult(intent, CODE_AVATER2);
            }
        });

        if(personEntity!=null){
            String lawyerCertificatePhoto=personEntity.getLawyerCertificatePhoto();
            String recordUrl=personEntity.getRecordUrl();
            if(!StringUtils.isEmpty(lawyerCertificatePhoto)){
                imageLoader.displayImage(lawyerCertificatePhoto, ImageView01, options);
            }
            if(!StringUtils.isEmpty(recordUrl)){
                imageLoader.displayImage(recordUrl, ImageView02, options);
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CODE_AVATER1 && resultCode == PersonActivity.CODE_AVATER) { //头像
            image_path1 = data.getStringExtra("image");
            if (StringUtils.isEmpty(image_path1)) {
                return;
            }
            String url = "file:///" + image_path1;
            imageLoader.displayImage(url, ImageView01, options);
        } else if (requestCode == CODE_AVATER2 && resultCode == PersonActivity.CODE_AVATER) { //头像
            image_path2 = data.getStringExtra("image");
            if (StringUtils.isEmpty(image_path2)) {
                return;
            }
            String url = "file:///" + image_path2;
            imageLoader.displayImage(url, ImageView02, options);
        }

    }

    public void uploadClick(View view) {
        String lawyerID = PreferencesUtils.getString(this, Constants.PRE_LAWYERID);
        String mac = PreferencesUtils.getString(UpdateCertificateActivity.this, Constants.PRE_MAC);
        Map<String, String> map = new HashMap<String, String>();
        map.put("v", "1.0");
        map.put("ts", StringUtils.getCurrentTimes());
        map.put("appKey", Constants.APP_KEY);
        map.put("method", getString(R.string.lawyer_update_url));
        map.put("id", lawyerID);
        map.put("mac", mac);
        map.put("nvl", "true");
        map.put("photo1", "photo1");
        map.put("photo2", "photo2");
        map.put("sign", httpUtils.sign(map, Constants.APP_SECRET));
        loadDate(map);
    }

    /**
     * 加载数据
     *
     * @param map
     */
    private void loadDate(Map<String, String> map) {
        if (mRequestData != null
                && mRequestData.getStatus() != AsyncTask.Status.FINISHED)
            mRequestData.cancel(true);
        mRequestData = new RequestData(map);
        mRequestData.execute();
    }

    class RequestData extends AsyncTask<String, Void, PersonEntity> {
        private Map<String, String> map;

        public RequestData(Map<String, String> map) {
            this.map = map;
        }

        @Override
        protected PersonEntity doInBackground(String... params) {
            PersonEntity item = null;
            try {
                String result = FileHelper.uploadHttpClient(UpdateCertificateActivity.this, getString(R.string.base_url), map, image_path1,image_path2);
                Log.e("----",result);
                item = new Gson().fromJson(result, PersonEntity.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return item;
        }

        @Override
        protected void onPostExecute(PersonEntity result) {
            super.onPostExecute(result);
            if (result != null && result.getSuccess()) {
                if (StringUtils.isEmpty(image_path1)) {
                    return;
                }
                String url = "file:///" + image_path1;
                imageLoader.displayImage(url, ImageView01, options);
                if (StringUtils.isEmpty(image_path2)) {
                    return;
                }
                String url1 = "file:///" + image_path2;
                imageLoader.displayImage(url1, ImageView02, options);
            } else {
                if (result != null) {
                    ToastUtils.showToastShort(UpdateCertificateActivity.this, result.getMessage());
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
