package com.lawyer.android.bean;

import java.util.List;

/**
 * Created by chenguoquan on 8/29/15.
 */
public class ListMessageItem {

    private boolean success;
    private String message;
    private List<MessageItem> messages;

    public ListMessageItem(boolean success, String message, List<MessageItem> messages) {
        this.success = success;
        this.message = message;
        this.messages = messages;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<MessageItem> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageItem> messages) {
        this.messages = messages;
    }
}
