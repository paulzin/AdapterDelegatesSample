package com.example.paul.adapterdelegatessample.model;

/**
 * @author Paul Zin
 */
public class Subhead implements DisplayableItem {
    private String text;

    public Subhead(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
