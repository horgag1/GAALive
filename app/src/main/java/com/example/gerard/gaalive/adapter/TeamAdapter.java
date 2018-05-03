package com.example.gerard.gaalive.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.Query;

/**
 * Created by gerard on 15/02/2018.
 */

public class TeamAdapter extends FirestoreAdapter<TeamAdapter.ViewHolder> {




    public TeamAdapter(Query query) {
        super(query);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater= LayoutInflater.from(parent.getContext());


        return null;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    static class ViewHolder extends RecyclerView.ViewHolder{


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
