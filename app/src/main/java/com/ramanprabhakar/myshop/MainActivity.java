package com.ramanprabhakar.myshop;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
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
import com.ramanprabhakar.myshop.Services.HttpService;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tvNext;
    RecyclerView rvHome;
    RVAdapter rvAdapter;
    LinearLayoutManager llm;
    ArrayList<Doc> docs = new ArrayList<Doc>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvHome = (RecyclerView) findViewById(R.id.rv_home);
        llm = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        rvHome.setLayoutManager(llm);
        rvAdapter = new RVAdapter(MainActivity.this);
        rvHome.setAdapter(rvAdapter);
        tvNext = (TextView) findViewById(R.id.tv_next_page);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getHomePage1();
    }

    private void updateRVAdapter(ArrayList<Doc> docs) {
        rvAdapter.getList().clear();
        rvAdapter.getList().addAll(docs);
        rvAdapter.notifyDataSetChanged();
        llm.scrollToPositionWithOffset(0, 0);

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

        if (id == R.id.home) {
            getHomePage1();
            // Handle the camera action
        } else if (id == R.id.filter) {
            getFilter1();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void getHomePage1() {
        tvNext.setText("Next");
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHomePage2();
            }
        });
        HttpService.getInstance().getHomePage1(AppConstants.ASTERISK, AppConstants.FL_LIST, AppConstants.ROWS_30, AppConstants.JSON, new Callback<JsonResponse>() {
            @Override
            public void success(JsonResponse jsonResponse, Response response) {
                ResponseHeader responseHeader = jsonResponse.getResponseHeader();
                com.ramanprabhakar.myshop.Model.Response responseBody = jsonResponse.getResponse();
                docs = responseBody.getDocs();
                if (!docs.isEmpty()) {
                    updateRVAdapter(docs);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                handleRetrofitError(error);
//                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void getHomePage2() {
        tvNext.setText("Previous");
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHomePage1();
            }
        });

        HttpService.getInstance().getHomePage2(AppConstants.ASTERISK, AppConstants.FL_LIST, AppConstants.ROWS_30, AppConstants.START_31, AppConstants.JSON, new Callback<JsonResponse>() {
            @Override
            public void success(JsonResponse jsonResponse, Response response) {
                com.ramanprabhakar.myshop.Model.Response responseBody = jsonResponse.getResponse();
                docs = responseBody.getDocs();
                if (!docs.isEmpty()) {
                    updateRVAdapter(docs);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                handleRetrofitError(error);
//                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getFilter1() {
        tvNext.setText("Next");
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFilter2();
            }
        });
        HttpService.getInstance().getFilter1(AppConstants.ASTERISK, AppConstants.ManufacturerDooda, AppConstants.FL_LIST, AppConstants.ROWS_30, AppConstants.JSON, new Callback<JsonResponse>() {
            @Override
            public void success(JsonResponse jsonResponse, Response response) {
                ResponseHeader responseHeader = jsonResponse.getResponseHeader();
                com.ramanprabhakar.myshop.Model.Response responseBody = jsonResponse.getResponse();
                docs = responseBody.getDocs();
                if (!docs.isEmpty()) {
                    updateRVAdapter(docs);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                handleRetrofitError(error);
//                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getFilter2() {
        tvNext.setText("Previous");
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFilter1();
            }
        });
        HttpService.getInstance().getFilter2(AppConstants.ASTERISK, AppConstants.ManufacturerDooda, AppConstants.FL_LIST, AppConstants.ROWS_30, AppConstants.START_31, AppConstants.JSON, new Callback<JsonResponse>() {
            @Override
            public void success(JsonResponse jsonResponse, Response response) {
                ResponseHeader responseHeader = jsonResponse.getResponseHeader();
                com.ramanprabhakar.myshop.Model.Response responseBody = jsonResponse.getResponse();
                docs = responseBody.getDocs();
                if (!docs.isEmpty()) {
                    updateRVAdapter(docs);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                handleRetrofitError(error);
//                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
