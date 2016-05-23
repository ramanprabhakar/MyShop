package com.ramanprabhakar.myshop;

import android.app.Application;
import android.support.v7.widget.AppCompatTextView;

import com.ramanprabhakar.myshop.Services.HttpService;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Raman on 5/21/2016.
 */
public class MyShopApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpService.getInstance().setUp(getApplicationContext());

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                .addCustomStyle(AppCompatTextView.class, android.R.attr.textViewStyle)
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
