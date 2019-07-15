package com.stech.social.app.facebook.model;

import com.google.gson.annotations.SerializedName;

public class FB_CommentsSummary {
    @SerializedName("order")
    private String order;

    @SerializedName("total_count")
    private Long total_count;

    @SerializedName("can_comment")
    private Boolean can_comment;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Long getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Long total_count) {
        this.total_count = total_count;
    }

    public Boolean getCan_comment() {
        return can_comment;
    }

    public void setCan_comment(Boolean can_comment) {
        this.can_comment = can_comment;
    }
}
