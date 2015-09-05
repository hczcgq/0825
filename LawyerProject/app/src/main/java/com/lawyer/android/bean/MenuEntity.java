package com.lawyer.android.bean;

/**
 * 左侧菜单实体
 * Created by hm-soft on 2015/8/26.
 */
public class MenuEntity {

    private int icon;
    private int name;

    public MenuEntity(int icon, int name) {
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
