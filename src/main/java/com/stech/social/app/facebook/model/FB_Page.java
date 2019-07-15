package com.stech.social.app.facebook.model;

import com.google.gson.annotations.SerializedName;

public class FB_Page {
    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    @SerializedName("category")
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "FB_Page{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
