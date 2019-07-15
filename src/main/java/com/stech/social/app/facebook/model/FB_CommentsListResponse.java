package com.stech.social.app.facebook.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FB_CommentsListResponse {
    @SerializedName("data")
    private List<FB_Comment> data;

    @SerializedName("paging")
    private FB_Paging paging;

    @SerializedName("summary")
    private FB_CommentsSummary summary;

    public List<FB_Comment> getData() {
        return data;
    }

    public void setData(List<FB_Comment> data) {
        this.data = data;
    }

    public FB_Paging getPaging() {
        return paging;
    }

    public void setPaging(FB_Paging paging) {
        this.paging = paging;
    }

    public FB_CommentsSummary getSummary() {
        return summary;
    }

    public void setSummary(FB_CommentsSummary summary) {
        this.summary = summary;
    }
}
