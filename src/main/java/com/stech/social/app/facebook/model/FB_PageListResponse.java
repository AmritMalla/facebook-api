package com.stech.social.app.facebook.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FB_PageListResponse {
    @SerializedName("data")
    private List<FB_Page> data;

    public List<FB_Page> getData() {
        return data;
    }

    public void setData(List<FB_Page> data) {
        this.data = data;
    }
}
