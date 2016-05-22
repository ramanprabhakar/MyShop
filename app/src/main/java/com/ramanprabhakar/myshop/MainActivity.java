package com.ramanprabhakar.myshop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.ramanprabhakar.myshop.Model.Doc;
import com.ramanprabhakar.myshop.Model.JsonResponse;
import com.ramanprabhakar.myshop.Model.ResponseHeader;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tvNext;
    RecyclerView rvHome;
    RVAdapter rvAdapter;
    ArrayList<Doc> docs = new ArrayList<Doc>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvHome = (RecyclerView)findViewById(R.id.rv_home);
        rvHome.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        rvAdapter = new RVAdapter(MainActivity.this);
        rvHome.setAdapter(rvAdapter);

        getData();

        tvNext = (TextView)findViewById(R.id.tv_next_page);
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpService.getInstance().getHomePage2(AppConstants.ASTERISK, AppConstants.FL_LIST, AppConstants.ROWS_30, AppConstants.START_31, AppConstants.JSON, new Callback<JsonResponse>() {
                    @Override
                    public void success(JsonResponse jsonResponse, Response response) {
                        com.ramanprabhakar.myshop.Model.Response responseBody = jsonResponse.getResponse();
                        docs = responseBody.getDocs();

                        if(!docs.isEmpty()){
                            updateRVAdapter(docs);
                        }

                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void updateRVAdapter(ArrayList<Doc> docs) {
        rvAdapter.getList().clear();
        rvAdapter.setList(docs);
        rvAdapter.notifyDataSetChanged();
        Toast.makeText(MainActivity.this, "Adapter Set", Toast.LENGTH_SHORT).show();
    }

    public void getData() {
        HttpService.getInstance().getHomePage1(AppConstants.ASTERISK, AppConstants.FL_LIST , AppConstants.ROWS_30, AppConstants.JSON ,new Callback<JsonResponse>() {
            @Override
            public void success(JsonResponse jsonResponse, Response response) {
                ResponseHeader responseHeader = jsonResponse.getResponseHeader();
                com.ramanprabhakar.myshop.Model.Response responseBody = jsonResponse.getResponse();
                docs = responseBody.getDocs();
                if(!docs.isEmpty()){
                    updateRVAdapter(docs);
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
