package com.yeti.testsocieteapi.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.yeti.testsocieteapi.R;
import com.yeti.testsocieteapi.interfaces.SearchFragmentListener;

/**
 * Created by Jean-Philippe on 01/06/2016.
 */
public class FragmentQuery extends Fragment {
    SearchFragmentListener mCallback;
    private TextView queryTxt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_query, container, false);
        Button search = (Button)v.findViewById(R.id.search);
        queryTxt.findViewById(R.id.input_name);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallback.onSearchClicked(queryTxt.getText().toString());
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context ctx) {
        super.onAttach(ctx);
        try {
            mCallback = (SearchFragmentListener) ctx;
        } catch (ClassCastException e) {
            throw new ClassCastException(ctx.toString()
                    + " must implement SearchFragmentListener");
        }
    }
}
