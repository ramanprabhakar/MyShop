package com.ramanprabhakar.myshop.Services;

import com.ramanprabhakar.myshop.Model.JsonResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by Raman on 5/20/2016.
 */
public interface RestService {

//    public static final String HomePage1 = "http://103.224.241.148:2000/solr/zupigo/select?q=%2A&fl=pid,large_image_url,title&rows=30&wt=json";
//    public static final String HomePage2 = "http://103.224.241.148:2000/solr/zupigo/select?q=%2A&rows=30&start=31&fl=pid,large_image_url,title&wt=json";
//    public static final String Filter1 = "http://103.224.241.148:2000/solr/zupigo/select?q=%2A&fq=manufacturer:DooDa&fl=pid,large_image_url,title&rows=30&wt=json";
//    public static final String Filter2 = "http://103.224.241.148:2000/solr/zupigo/select?q=%2A&fq=manufacturer:DooDa&fl=pid,large_image_url,title&rows=30&start=31&wt=json";
//    public static final String Detail = "http://103.224.241.148:2000/solr/zupigo/select?q=%2A&fq=pid:AZ1926800&fl=pid,large_image_url,title&rows=1&wt=json";

    @GET("/select")
    public void getHomePage1(@Query("q") String q, @Query("fl") List<String> flList, @Query("rows") String rows,
                             @Query("wt") String wt, Callback<JsonResponse> callback);

    @GET("/select")
    public void getHomePage2(@Query("q") String q, @Query("fl") List<String> flList,
                             @Query("rows") String rows, @Query("start") String start, @Query("wt") String wt, Callback<JsonResponse> callback);

    @GET("/select")
    public void getFilter1(@Query("q") String q, @Query("fq") String fq, @Query("fl") List<String> flList,
                           @Query("rows") String rows, @Query("wt") String wt, Callback<JsonResponse> callback);

    @GET("/select")
    public void getFilter2(@Query("q") String q, @Query("fq") String fq, @Query("fl") List<String> flList,
                           @Query("rows") String rows, @Query("start") String start, @Query("wt") String wt, Callback<JsonResponse> callback);

    @GET("/select")
    public void getDetails(@Query("q") String q, @Query("fq") String fq, @Query("fl") List<String> flList,
                           @Query("rows") String rows, @Query("wt") String wt, Callback<JsonResponse> callback);

}
