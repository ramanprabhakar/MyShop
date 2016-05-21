package com.ramanprabhakar.myshop.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Raman on 5/20/2016.
 */
public class Doc implements Serializable {

    @SerializedName("pid")
    String pid;

    @SerializedName("large_image_url")
    String large_image_url;

    @SerializedName("title")
    String title;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getLarge_image_url() {
        return large_image_url;
    }

    public void setLarge_image_url(String large_image_url) {
        this.large_image_url = large_image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
