package com.stech.social.app.facebook.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class FB_PagePost {

    @SerializedName("id")
    private String id;

    @SerializedName("story")
    private String story;

    @SerializedName("message")
    private String message;

    @SerializedName("created_time")
    private Date created_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreatedTime(Date createdTime) {
        this.created_time = createdTime;
    }
}
