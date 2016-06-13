package com.example.paul.adapterdelegatessample.model;

import android.support.annotation.ColorInt;

/**
 * @author Paul Zin
 */
public class Article implements DisplayableItem {
    @ColorInt
    private int backgroundColor;
    private String title;
    private String description;

    public Article(int backgroundColor, String title, String description) {
        this.backgroundColor = backgroundColor;
        this.title = title;
        this.description = description;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(@ColorInt int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
