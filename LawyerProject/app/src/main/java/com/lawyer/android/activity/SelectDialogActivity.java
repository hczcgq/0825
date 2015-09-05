package com.lawyer.android.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.lawyer.android.R;
import com.lawyer.android.util.FileUtils;
import com.lawyer.android.util.PhotoUtils;

import java.io.File;

/**
 * Created by chenguoquan on 8/27/15.
 */
public class SelectDialogActivity extends Activity {
    private Button btn_one, btn_two, btn_cancel;

    private String image_path;

    @SuppressWarnings({"deprecation", "static-access"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_select_dialog);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        // 设置窗口的大小及透明度
        layoutParams.width = LinearLayout.LayoutParams.FILL_PARENT;
        layoutParams.height = layoutParams.FILL_PARENT;
        window.setAttributes(layoutParams);

        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);

        btn_one.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                image_path= PhotoUtils.takePicture(SelectDialogActivity.this);
            }
        });
        btn_two.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                PhotoUtils.selectPhoto(SelectDialogActivity.this);
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                onfinish();
            }
        });
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int height = findViewById(R.id.pop_layout).getTop();
        int y = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (y < height) {
                onfinish();
            }
        }
        return true;
    }


    private void onfinish() {
        finish();
        overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PhotoUtils.INTENT_REQUEST_CODE_ALBUM:
                if (data == null) {
                    return;
                }
                if (resultCode == RESULT_OK) {
                    if (data.getData() == null) {
                        return;
                    }
                    if (!FileUtils.isSdcardExist()) {
                        return;
                    }
                    Uri selectedImageUri = data.getData();
                    image_path = FileUtils.getPath(selectedImageUri,
                            SelectDialogActivity.this);
                    PhotoUtils.startPhotoZoom(SelectDialogActivity.this,
                            Uri.fromFile(new File(image_path)), 150, 150); // 裁剪图片
                } else {
                    image_path = null;
                }
                break;

            case PhotoUtils.INTENT_REQUEST_CODE_CAMERA:
                if (resultCode == RESULT_OK) {
                    if (image_path != null) {
                        PhotoUtils.startPhotoZoom(SelectDialogActivity.this,
                                Uri.fromFile(new File(image_path)), 150, 150);
                    }
                } else {
                    image_path = null;
                }
                break;
            case PhotoUtils.INTENT_REQUEST_CODE_CROP:
                if (data != null) {
                    Bitmap bitmap = data.getParcelableExtra("data");
                    if (bitmap != null) {
                        image_path = PhotoUtils.savePhotoToSDCard(bitmap);
                    } else {
                        image_path = null;
                    }
                } else {
                    image_path = null;
                }
                Intent intent=new Intent();
                intent.putExtra("image",image_path);
                setResult(PersonActivity.CODE_AVATER,intent);
                onfinish();
                break;
        }
    }


}
