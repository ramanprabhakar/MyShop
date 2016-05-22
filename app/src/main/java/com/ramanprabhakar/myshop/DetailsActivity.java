package com.ramanprabhakar.myshop;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ramanprabhakar.myshop.Model.Doc;
import com.ramanprabhakar.myshop.Model.JsonResponse;
import com.ramanprabhakar.myshop.Services.HttpService;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DetailsActivity extends AppCompatActivity {

    Doc doc;
    ImageView ivDetails;
    TextView tvDetails;
    ImageView ivAndroidShare;
    ImageView ivWhatsappShare;
    ImageView ivDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        final int width = size.x;
        final int height = size.y;

        ivDetails = (ImageView) findViewById(R.id.iv_details);
        tvDetails = (TextView) findViewById(R.id.tv_details);
        ivAndroidShare = (ImageView) findViewById(R.id.iv_android_share);
        ivWhatsappShare = (ImageView) findViewById(R.id.iv_whatsapp_share);
        ivDownload = (ImageView) findViewById(R.id.iv_download);

        setOnClickListeners();

        String pid = getIntent().getStringExtra(AppConstants.PID);

        HttpService.getInstance().getDetails(AppConstants.ASTERISK, pid, AppConstants.FL_LIST, AppConstants.ROWS_1, AppConstants.JSON, new Callback<JsonResponse>() {
            @Override
            public void success(JsonResponse jsonResponse, Response response) {
                com.ramanprabhakar.myshop.Model.Response responseBody = jsonResponse.getResponse();
                doc = responseBody.getDocs().get(0);
                Picasso.with(DetailsActivity.this).load(doc.getLarge_image_url()).resize(width, width).into(ivDetails);
                tvDetails.setText(doc.getTitle());
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(DetailsActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setOnClickListeners() {

        ivAndroidShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailsActivity.this, "Android Share", Toast.LENGTH_SHORT).show();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, AppConstants.ANDROID_SHARE_HEADER + doc.getLarge_image_url());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

        ivWhatsappShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailsActivity.this, "WhatsApp Share", Toast.LENGTH_SHORT).show();
            }
        });

        ivDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailsActivity.this, "Download", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
