package com.ramanprabhakar.myshop;

import android.widget.ArrayAdapter;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Raman on 5/20/2016.
 */
public class AppConstants {

//    public static final String HomePage1 = "http://103.224.241.148:2000/solr/zupigo/select?q=%2A&fl=pid,large_image_url,title&rows=30&wt=json";
//    public static final String HomePage2 = "http://103.224.241.148:2000/solr/zupigo/select?q=%2A&rows=30&start=31&fl=pid,large_image_url,title&wt=json";
//    public static final String Filter1 = "http://103.224.241.148:2000/solr/zupigo/select?q=%2A&fq=manufacturer:DooDa&fl=pid,large_image_url,title&rows=30&wt=json";
//    public static final String Filter2 = "http://103.224.241.148:2000/solr/zupigo/select?q=%2A&fq=manufacturer:DooDa&fl=pid,large_image_url,title&rows=30&start=31&wt=json";
//    public static final String Detail = "http://103.224.241.148:2000/solr/zupigo/select?q=%2A&fq=pid:AZ1926800&fl=pid,large_image_url,title&rows=1&wt=json";

    public static final String HomePage1 = "select?q=%2A&fl=pid,large_image_url,title&rows=30&wt=json";
    public static final String HomePage2 = "select?q=%2A&rows=30&start=31&fl=pid,large_image_url,title&wt=json";
    public static final String Filter1 = "select?q=%2A&fq=manufacturer:DooDa&fl=pid,large_image_url,title&rows=30&wt=json";
    public static final String Filter2 = "select?q=%2A&fq=manufacturer:DooDa&fl=pid,large_image_url,title&rows=30&start=31&wt=json";
    public static final String Detail = "select?q=%2A&fq=pid:AZ1926800&fl=pid,large_image_url,title&rows=1&wt=json";

    public static final String JSON = "json";
    //    public static final String ManufacturerDooda = "manufacturer" + "%3A" + "DooDa";
    public static final String ManufacturerDooda = "manufacturer:DooDa";

    public static final String HOST = "http://103.224.241.148:2000/solr/zupigo";
//    public static final String ASTERISK = "%2A";

    public static final String ASTERISK = "*";

    public static final List<String> FL_LIST = Arrays.asList("pid", "large_image_url", "title");
    public static final String ROWS_30 = "30";
    public static final String ROWS_1 = "1";
    public static final String START_31 = "31";
    public static final String PID_COLON = "pid:";

    public static final String PID = "pid";
    public static final String SHARE_HEADER = "Hey, Checkout this cool new Item.\n\n";


//    http://103.224.241.148:2000/solr/zupigo/select?q=*&fq=pid:AZ1926800&fl=pid,large_image_url,title&rows=1&wt=json
//    http://103.224.241.148:2000/solr/zupigo/select?q=*&fq=manufacturer:DooDa&fl=pid,large_image_url,title&rows=30&start=31&wt=json
//    http://103.224.241.148:2000/solr/zupigo/select?q=*&fq=manufacturer:DooDa&fl=pid,large_image_url,title&rows=30&wt=json
//    http://103.224.241.148:2000/solr/zupigo/select?q=*&fl=pid,large_image_url,title&rows=30&wt=json
//    http://103.224.241.148:2000/solr/zupigo/select?q=*&rows=30&start=31&fl=pid,large_image_url,title&wt=json


}
