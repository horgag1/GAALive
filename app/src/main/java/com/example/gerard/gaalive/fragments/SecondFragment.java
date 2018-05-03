package com.example.gerard.gaalive.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gerard.gaalive.R;
import com.example.gerard.gaalive.adapter.MatchAdapter;
import com.example.gerard.gaalive.adapter.TableAdapter;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;


public class SecondFragment extends Fragment {


    private static final String TAG = "MainActivity";
    private static final int LIMIT = 50;
    RecyclerView mTableRecycler;
    Query mQuery;
    private FirebaseFirestore mFirestore;
    View v;
    TableAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initFirestore();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAdapter != null) {
            mAdapter.startListening();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_second, container, false);
        mTableRecycler= v.findViewById(R.id.table_recyclerview);
        initRecyclerView();
        return v;

    }

    private void initRecyclerView() {
        if (mQuery == null) {
            Log.w(TAG, "No query, not initializing RecyclerView");
        }

        mAdapter = new TableAdapter(mQuery) {


            @Override
            protected void onDataChanged() {
                // Show/hide content if the query returns empty.
                if (getItemCount() == 0) {
                    mTableRecycler.setVisibility(View.GONE);
                    //mEmptyView.setVisibility(View.VISIBLE);
                } else {
                    mTableRecycler.setVisibility(View.VISIBLE);
                    //mEmptyView.setVisibility(View.GONE);
                }
            }

            @Override
            protected void onError(FirebaseFirestoreException e) {
                // Show a snackbar on errors
                Snackbar.make(v.findViewById(android.R.id.content),
                        "Error: check logs for info.", Snackbar.LENGTH_LONG).show();
            }
        };

        mTableRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTableRecycler.setAdapter(mAdapter);



    }

    private void initFirestore() {
        mFirestore = FirebaseFirestore.getInstance();
        mQuery = mFirestore.collection("table")
                .limit(LIMIT);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }

    }
}
