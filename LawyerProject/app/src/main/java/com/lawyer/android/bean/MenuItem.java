package com.lawyer.android.bean;

/**
 * Created by hm-soft on 2015/8/26.
 */
public class MenuItem {

    private int icon;
    private int name;

    public MenuItem(int icon, int name) {
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
