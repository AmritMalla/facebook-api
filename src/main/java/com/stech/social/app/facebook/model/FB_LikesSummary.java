package com.stech.social.app.facebook.model;

import com.google.gson.annotations.SerializedName;

public class FB_LikesSummary {
    @SerializedName("total_count")
    private Integer total_count;
    @SerializedName("can_like")
    private Boolean can_like;
    @SerializedName("has_liked")
    private Boolean has_liked;

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public Boolean getCan_like() {
        return can_like;
    }

    public void setCan_like(Boolean can_like) {
        this.can_like = can_like;
    }

    public Boolean getHas_liked() {
        return has_liked;
    }

    public void setHas_liked(Boolean has_liked) {
        this.has_liked = has_liked;
    }
}
