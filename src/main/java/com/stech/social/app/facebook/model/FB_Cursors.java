package com.stech.social.app.facebook.model;

import com.google.gson.annotations.SerializedName;

public class FB_Cursors {
    @SerializedName("before")
    private String before;
    @SerializedName("after")
    private String after;

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }
}
