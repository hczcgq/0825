package com.lawyer.android.util;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author Administrator
 * 
 */
public class PhotoUtils {
    // 相册的RequestCode
    public static final int INTENT_REQUEST_CODE_ALBUM = 1;

    // 照相的RequestCode
    public static final int INTENT_REQUEST_CODE_CAMERA = 2;

    // 裁剪照片的RequestCode
    public static final int INTENT_REQUEST_CODE_CROP = 3;

    /**
     * 通过手机相册获取图片
     * 
     * @param activity
     */
    public static void selectPhoto(Activity activity) {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        activity.startActivityForResult(intent, INTENT_REQUEST_CODE_ALBUM);
    }

    /**
     * 通过手机照相获取图片
     * 
     * @param activity
     * @return 照相后图片的路径
     */
    public static String takePicture(Activity activity) {
        FileUtils.createDirFile(Constants.TAKE_PHOTO_PATH);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        String path = Constants.TAKE_PHOTO_PATH
                + FileUtils.getImageFileNameByDate() + ".jpg";
        File file = FileUtils.createNewFile(path);
        if (file != null) {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        }
        activity.startActivityForResult(intent, INTENT_REQUEST_CODE_CAMERA);
        return path;
    }

    /**
     * 裁剪图片方法实现
     * 
     * @param uri
     */
    public static void startPhotoZoom(Activity activity, Uri uri, int outputX,
            int outputY) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", outputX);
        intent.putExtra("outputY", outputY);
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("return-data", true);
        activity.startActivityForResult(intent, INTENT_REQUEST_CODE_CROP);
    }

    /**
     * 删除单张图片
     */
    public static void deleteImageByPath(String image_path) {
        File localFile = new File(image_path);
        if (localFile.isFile() && localFile.exists()) {
            localFile.getAbsoluteFile().delete();
        }
    }

    /**
     * 保存bitmap图片到SD卡
     *
     * @param bitmap
     * @return
     */
    public static String savePhotoToSDCard(Bitmap bitmap,String name) {
        if (!FileUtils.isSdcardExist()) {
            return null;
        }
        FileUtils.createDirFile(Constants.SEND_IMAGE_PATH);
        String fileName = Constants.SEND_IMAGE_PATH + name;
        File myCaptureFile = new File(fileName);
        BufferedOutputStream bos = null;
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(myCaptureFile);
            bos = new BufferedOutputStream(out);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
        } catch (FileNotFoundException e1) {
            return null;
        } finally {
            try {
                bos.flush();
                bos.close();
                out.close();
            } catch (IOException e) {
                return null;
            }
        }
        return fileName;
    }
}
