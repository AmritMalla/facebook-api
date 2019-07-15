package com.stech.social.app.facebook.model;

import com.google.gson.annotations.SerializedName;

public class FB_Paging {
    @SerializedName("cursors")
    private FB_Cursors cursors;

    public FB_Cursors getCursors() {
        return cursors;
    }

    public void setCursors(FB_Cursors cursors) {
        this.cursors = cursors;
    }
}
