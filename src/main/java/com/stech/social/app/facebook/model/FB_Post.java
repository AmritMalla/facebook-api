package com.stech.social.app.facebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "fbPosts")
public class FB_Post {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "message")
    private String message;

    @Column(name = "createdTime")
    private Date created_time;

    @Column(name = "totalLikes")
    private Long totalLikeCount;

    @Column(name = "totalComments")
    private Long totalCommentCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public Long getTotalLikeCount() {
        return totalLikeCount;
    }

    public void setTotalLikeCount(Long totalLikeCount) {
        this.totalLikeCount = totalLikeCount;
    }

    public Long getTotalCommentCount() {
        return totalCommentCount;
    }

    public void setTotalCommentCount(Long totalCommentCount) {
        this.totalCommentCount = totalCommentCount;
    }

    @Override
    public String toString() {
        return "FB_Post{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", created_time='" + created_time + '\'' +
                ", totalLikeCount=" + totalLikeCount +
                ", totalCommentCount=" + totalCommentCount +
                '}';
    }
}
