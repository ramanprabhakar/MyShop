package com.ramanprabhakar.myshop;

import android.content.Context;
import android.util.LruCache;

import com.ramanprabhakar.myshop.Model.JsonResponse;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Raman on 5/20/2016.
 */
public class HttpService {

    private static HttpService instance = new HttpService();
    private Context context;
    private LruCache<String, Object> cache = new LruCache<>(4 * 1024 * 1024);
    private RestService restService;

    private HttpService() {
    }

    public static HttpService getInstance() {
        return instance;
    }

    public void setUp(Context context) {
        this.context = context;

        OkHttpClient okHttpClient = new OkHttpClient();
        OkClient okClient = new OkClient(okHttpClient);

        Cache cache = new Cache(context.getCacheDir(), 1024);
        okHttpClient.setCache(cache);
        RestAdapter jsonRestAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL).setLog(new AndroidLog("Retrofit"))
                .setEndpoint(AppConstants.HOST)
                .setClient(okClient)
                .build();
        restService = jsonRestAdapter.create(RestService.class);
    }


    public void getHomePage1(String q, List<String> flList, String rows, String wt, Callback<JsonResponse> callback) {
        restService.getHomePage1(q, flList, rows, wt, callback);
    }


    public void getHomePage2(String q, List<String> flList, String rows, String start, String wt, Callback<JsonResponse> callback) {
        restService.getHomePage2(q, flList, rows, start, wt, callback);
    }

    public void getFilter1(String q, String fq, List<String> flList, String rows, String wt, Callback<JsonResponse> callback) {
        restService.getFilter1(q, fq, flList, rows, wt, callback);
    }

    public void getFilter2(String q, String fq, List<String> flList, String rows, String start, String wt, Callback<JsonResponse> callback) {
        restService.getFilter2(q, fq, flList, rows, start, wt, callback);
    }

    public void getDetails(String q, String token, List<String> flList, String rows, String wt, Callback<JsonResponse> callback) {
        String fq = AppConstants.PID_COLON + token;
        restService.getDetails(q, fq, flList, rows, wt, callback);
    }
}
