package com.example.paul.adapterdelegatessample.model;

import android.support.annotation.ColorInt;

/**
 * @author Paul Zin
 */
public class User implements DisplayableItem {
    @ColorInt
    private int avatarColor;
    private String fullName;
    private String email;

    public User(@ColorInt int avatarColor, String fullName, String email) {
        this.avatarColor = avatarColor;
        this.fullName = fullName;
        this.email = email;
    }

    public int getAvatarColor() {
        return avatarColor;
    }

    public void setAvatarColor(int avatarColor) {
        this.avatarColor = avatarColor;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
