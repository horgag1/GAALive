package com.example.gerard.gaalive.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gerard.gaalive.R;
import com.example.gerard.gaalive.fragments.FirstFragment;
import com.example.gerard.gaalive.model.Match;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by gerard on 23/01/2018.
 */

public class MatchAdapter extends FirestoreAdapter<MatchAdapter.ViewHolder> {





    public interface OnMatchSelectedListener {

        void onMatchSelected(DocumentSnapshot match);

    }

    private OnMatchSelectedListener mListener;

    public MatchAdapter(Query query, OnMatchSelectedListener listener) {
        super(query);
        mListener=listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.match_item, parent, false));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getSnapshot(position), mListener);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView homeTeam;

        @BindView(R.id.imageView2)
        ImageView awayTeam;

        @BindView(R.id.textView)
        TextView score;

        @BindView(R.id.textView2)
        TextView competition;

        @BindView(R.id.textView3)
        TextView game;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        public void bind(final DocumentSnapshot snapshot,
                         final OnMatchSelectedListener listener) {

            Match match = snapshot.toObject(Match.class);
            Resources resources = itemView.getResources();

            Glide.with(homeTeam.getContext())
                    .load(match.getHomeTeam())
                    .into(homeTeam);
            Glide.with(awayTeam.getContext())
                    .load(match.getAwayTeam())
                    .into(awayTeam);


            score.setText(match.getScore());
            competition.setText(match.getCompetition());
            game.setText(match.getGame());

            



            // Click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onMatchSelected(snapshot);
                    }
                }
            });
        }


    }

}
