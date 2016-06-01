package com.yeti.testsocieteapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yeti.testsocieteapi.fragments.FragmentQuery;
import com.yeti.testsocieteapi.interfaces.SearchFragmentListener;
import com.yeti.testsocieteapi.tools.QueryTask;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity implements SearchFragmentListener {

    private static final String TAG = "yeti";
    private static final String URL = "https://societeinfo.com/app/rest/api/v1/querysearch/companies/json?";
    private static final String API_KEY = "gejnsjm5oo5uoo0s8ckdg3009qj08lroc4hqmfeq001rq1m53b0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new FragmentQuery();
        fm.beginTransaction().add(R.id.fragmentcontainer, fragment).commit();
    }

    @Override
    public void onSearchClicked(String queryTxt) {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new QueryTask().execute(buildUrl(queryTxt));
        } else {
            Toast.makeText(getApplicationContext(),"No network",Toast.LENGTH_SHORT);
        }
    }

    private String buildUrl(String queryTxt) {
        try {
            return URL+"key="+API_KEY+"&query="+ URLEncoder.encode(queryTxt, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
