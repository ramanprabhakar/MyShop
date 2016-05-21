package com.ramanprabhakar.myshop.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Raman on 5/20/2016.
 */
public class ResponseHeader implements Serializable {

    @SerializedName("status")
    int status;

    @SerializedName("QTime")
    int QTime;

    @SerializedName("params")
    Params params;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQTime() {
        return QTime;
    }

    public void setQTime(int QTime) {
        this.QTime = QTime;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }
}
