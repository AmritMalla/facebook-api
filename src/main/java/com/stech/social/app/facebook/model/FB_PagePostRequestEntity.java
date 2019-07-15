package com.stech.social.app.facebook.model;

public class FB_PagePostRequestEntity {
    private String id;
    private String message;
    private String link;
    private Long scheduled_publish_time;
    private Boolean published;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Long getScheduled_publish_time() {
        return scheduled_publish_time;
    }

    public void setScheduled_publish_time(Long scheduled_publish_time) {
        this.scheduled_publish_time = scheduled_publish_time;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }
}
