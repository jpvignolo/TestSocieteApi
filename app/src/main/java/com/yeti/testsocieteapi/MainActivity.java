package com.yeti.testsocieteapi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.yeti.testsocieteapi.fragments.FragmentQuery;
import com.yeti.testsocieteapi.interfaces.SearchFragmentListener;

public class MainActivity extends AppCompatActivity implements SearchFragmentListener {

    private static final String TAG = "yeti";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = new FragmentQuery();
        fm.beginTransaction().add(R.id.fragmentcontainer, fragment).commit();
    }

    @Override
    public void onSearchClicked() {
        Log.d(TAG,"Search Clicked");
    }
}
