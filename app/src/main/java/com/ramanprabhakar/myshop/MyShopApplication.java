package com.ramanprabhakar.myshop;

import android.app.Application;

import com.ramanprabhakar.myshop.Services.HttpService;

/**
 * Created by Raman on 5/21/2016.
 */
public class MyShopApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpService.getInstance().setUp(getApplicationContext());
    }

}
