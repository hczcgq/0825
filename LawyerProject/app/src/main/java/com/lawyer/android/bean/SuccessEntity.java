package com.lawyer.android.bean;

/**
 * 返回数据实体
 * Created by chenguoquan on 8/29/15.
 */
public class SuccessEntity {


    /**
     * body :
     * message :
     * success : true
     */

    private String body;
    private String message;
    private boolean success;

    public void setBody(String body) {
        this.body = body;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getBody() {
        return body;
    }

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }
}
