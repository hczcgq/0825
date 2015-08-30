package com.lawyer.android.bean;

/**
 * 返回数据实体
 * Created by chenguoquan on 8/29/15.
 */
public class SuccessItem {


    /**
     * message : 数据校验异常，请和管理员联系！
     * success : false
     */

    private String message;
    private boolean success;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }
}
