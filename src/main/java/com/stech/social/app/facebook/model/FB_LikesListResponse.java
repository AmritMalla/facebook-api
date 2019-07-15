package com.stech.social.app.facebook.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FB_LikesListResponse {
    @SerializedName("data")
    private List<FB_UserShort> data;

    @SerializedName("paging")
    private FB_Paging paging;

    @SerializedName("summary")
    private FB_LikesSummary summary;


    public List<FB_UserShort> getData() {
        return data;
    }

    public void setData(List<FB_UserShort> data) {
        this.data = data;
    }

    public FB_Paging getPaging() {
        return paging;
    }

    public void setPaging(FB_Paging paging) {
        this.paging = paging;
    }

    public FB_LikesSummary getSummary() {
        return summary;
    }

    public void setSummary(FB_LikesSummary summary) {
        this.summary = summary;
    }
}
