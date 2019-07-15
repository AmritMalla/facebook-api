package com.stech.social.app.facebook.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FB_PagePostListResponseEntity {
    @SerializedName("data")
    private List<FB_PagePost> data;

    public List<FB_PagePost> getData() {
        return data;
    }

    public void setData(List<FB_PagePost> data) {
        this.data = data;
    }
}
