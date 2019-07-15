package com.stech.social.app.facebook.model;


import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class FB_Comment {
    @SerializedName("id")
    private String id;

    @SerializedName("can_comment")
    private Boolean can_comment;

    @SerializedName("can_remove")
    private Boolean can_remove;

    @SerializedName("can_hide")
    private Boolean can_hide;

    @SerializedName("can_like")
    private Boolean can_like;

    @SerializedName("can_reply_privately")
    private Boolean can_reply_privately;

    @SerializedName("comment_count")
    private Integer comment_count;

    @SerializedName("created_time")
    private Date created_time;

    @SerializedName("from")
    private FB_UserShort from;

    @SerializedName("like_count")
    private Integer like_count;

    @SerializedName("message")
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getCan_comment() {
        return can_comment;
    }

    public void setCan_comment(Boolean can_comment) {
        this.can_comment = can_comment;
    }

    public Boolean getCan_remove() {
        return can_remove;
    }

    public void setCan_remove(Boolean can_remove) {
        this.can_remove = can_remove;
    }

    public Boolean getCan_hide() {
        return can_hide;
    }

    public void setCan_hide(Boolean can_hide) {
        this.can_hide = can_hide;
    }

    public Boolean getCan_like() {
        return can_like;
    }

    public void setCan_like(Boolean can_like) {
        this.can_like = can_like;
    }

    public Boolean getCan_reply_privately() {
        return can_reply_privately;
    }

    public void setCan_reply_privately(Boolean can_reply_privately) {
        this.can_reply_privately = can_reply_privately;
    }

    public Integer getComment_count() {
        return comment_count;
    }

    public void setComment_count(Integer comment_count) {
        this.comment_count = comment_count;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public FB_UserShort getFrom() {
        return from;
    }

    public void setFrom(FB_UserShort from) {
        this.from = from;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
