package me.codeminions.common.bean;

import android.support.annotation.IdRes;

public class SettingItem {

    @IdRes
    private int iconResId;
    private String title;
    private String tip;

    public SettingItem(int iconResId, String title, String tip) {
        this.iconResId = iconResId;
        this.title = title;
        this.tip = tip;
    }

    public SettingItem(int iconResId, String title){
        this(iconResId, title, "");
    }

    public String getTip() {
        return tip;
    }

    public int getIconResId() {
        return iconResId;
    }

    public String getTitle() {
        return title;
    }
}
