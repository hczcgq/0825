package com.lawyer.android.bean;

import java.io.Serializable;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class ToolItem implements Serializable{

    private int icon;
    private String name;
    private String message;
    private String url;


    public ToolItem(int icon, String name, String message, String url) {
        this.icon = icon;
        this.name = name;
        this.message = message;
        this.url = url;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
