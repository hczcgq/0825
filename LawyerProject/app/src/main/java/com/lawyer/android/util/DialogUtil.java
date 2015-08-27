package com.lawyer.android.util;

import android.content.Context;
import android.content.DialogInterface;

import com.lawyer.android.R;
import com.lawyer.android.view.CustomDialog;

/**
 * Created by chenguoquan on 8/27/15.
 */
public class DialogUtil {


    /**
     * 确认对话框
     *
     * @param context
     * @param title         标题
     * @param message       提示内容
     * @param clickListener 确认点击
     */
    public static void showCustomDialog(Context context, String title, String message, DialogInterface.OnClickListener clickListener) {
        CustomDialog.Builder customBuilder = new CustomDialog.Builder(context);
        customBuilder
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.confirm),
                        clickListener)
                .setNegativeButton(context.getString(R.string.cancel),
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.dismiss();
                            }
                        });

        customBuilder.create().show();
    }
}
