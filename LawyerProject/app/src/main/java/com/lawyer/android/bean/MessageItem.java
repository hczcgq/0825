package com.lawyer.android.bean;

/**
 * Created by hm-soft on 2015/8/27.
 */
public class MessageItem {

    private String id;
    private String title;
    private String messageUrl;
    private String content;
    private String imgURL;
    private String messageType;
    private String createDate;


    public MessageItem(String id, String title, String messageUrl, String content, String imgURL, String messageType, String createDate) {
        this.id = id;
        this.title = title;
        this.messageUrl = messageUrl;
        this.content = content;
        this.imgURL = imgURL;
        this.messageType = messageType;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageUrl() {
        return messageUrl;
    }

    public void setMessageUrl(String messageUrl) {
        this.messageUrl = messageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
