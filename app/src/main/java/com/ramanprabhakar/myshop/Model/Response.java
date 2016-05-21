package com.ramanprabhakar.myshop.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Raman on 5/20/2016.
 */
public class Response implements Serializable {

    @SerializedName("numFound")
    long numFound;

    @SerializedName("start")
    int start;

    @SerializedName("docs")
    ArrayList<Doc> docs;

    public long getNumFound() {
        return numFound;
    }

    public void setNumFound(long numFound) {
        this.numFound = numFound;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public ArrayList<Doc> getDocs() {
        return docs;
    }

    public void setDocs(ArrayList<Doc> docs) {
        this.docs = docs;
    }
}
