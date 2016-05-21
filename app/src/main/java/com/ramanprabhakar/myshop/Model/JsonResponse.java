package com.ramanprabhakar.myshop.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Raman on 5/20/2016.
 */
public class JsonResponse implements Serializable {

    @SerializedName("responseHeader")
    ResponseHeader responseHeader;

    @SerializedName("response")
    Response response;

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.responseHeader = responseHeader;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
