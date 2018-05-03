package com.example.gerard.gaalive.adapter;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gerard.gaalive.R;
import com.example.gerard.gaalive.model.Table;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gerard on 06/02/2018.
 */

public class TableAdapter extends FirestoreAdapter<TableAdapter.ViewHolder> {

    public TableAdapter(Query query) {
        super(query);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_table, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getSnapshot(position));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.division)
        TextView division;
        @BindView(R.id.tvTeam)
        TextView team;
        @BindView(R.id.tvP)
        TextView played;
        @BindView(R.id.tvW)
        TextView won;
        @BindView(R.id.tvD)
        TextView drew;
        @BindView(R.id.tvL)
        TextView lost;
        @BindView(R.id.tvDiff)
        TextView diff;
        @BindView(R.id.tvPts)
        TextView  points;


        @BindView(R.id.tv1T)
        TextView firstT;
        @BindView(R.id.tv1P)
        TextView firstP;
        @BindView(R.id.tv1W)
        TextView firstW;
        @BindView(R.id.tv1L)
        TextView firstL;
        @BindView(R.id.tv1D)
        TextView firstD;
        @BindView(R.id.tv1Diff)
        TextView firstDiff;
        @BindView(R.id.tv1Pts)
        TextView firstPts;

        @BindView(R.id.tv2T)
        TextView secondT;
        @BindView(R.id.tv2P)
        TextView secondP;
        @BindView(R.id.tv2W)
        TextView secondW;
        @BindView(R.id.tv2L)
        TextView secondL;
        @BindView(R.id.tv2D)
        TextView secondD;
        @BindView(R.id.tv2Diff)
        TextView secondDiff;
        @BindView(R.id.tv2Pts)
        TextView secondPts;

        @BindView(R.id.tv3T)
        TextView thirdT;
        @BindView(R.id.tv3P)
        TextView thirdP;
        @BindView(R.id.tv3W)
        TextView thirdW;
        @BindView(R.id.tv3L)
        TextView thirdL;
        @BindView(R.id.tv3D)
        TextView thirdD;
        @BindView(R.id.tv3Diff)
        TextView thirdDiff;
        @BindView(R.id.tv3Pts)
        TextView thirdPts;

        @BindView(R.id.tv4T)
        TextView fourthT;
        @BindView(R.id.tv4P)
        TextView fourthP;
        @BindView(R.id.tv4W)
        TextView fourthW;
        @BindView(R.id.tv4L)
        TextView fourthL;
        @BindView(R.id.tv4D)
        TextView fourthD;
        @BindView(R.id.tv4Diff)
        TextView fourthDiff;
        @BindView(R.id.tv4Pts)
        TextView fourthPts;

        @BindView(R.id.tv5T)
        TextView fifthT;
        @BindView(R.id.tv5P)
        TextView fifthP;
        @BindView(R.id.tv5W)
        TextView fifthW;
        @BindView(R.id.tv5L)
        TextView fifthL;
        @BindView(R.id.tv5D)
        TextView fifthD;
        @BindView(R.id.tv5Diff)
        TextView fifthDiff;
        @BindView(R.id.tv5Pts)
        TextView fifthPts;

        @BindView(R.id.tv6T)
        TextView sixthT;
        @BindView(R.id.tv6P)
        TextView sixthP;
        @BindView(R.id.tv6W)
        TextView sixthW;
        @BindView(R.id.tv6L)
        TextView sixthL;
        @BindView(R.id.tv6D)
        TextView sixthD;
        @BindView(R.id.tv6Diff)
        TextView sixthDiff;
        @BindView(R.id.tv6Pts)
        TextView sixthPts;


        @BindView(R.id.tv7T)
        TextView seventhT;
        @BindView(R.id.tv7P)
        TextView seventhP;
        @BindView(R.id.tv7W)
        TextView seventhW;
        @BindView(R.id.tv7L)
        TextView seventhL;
        @BindView(R.id.tv7D)
        TextView seventhD;
        @BindView(R.id.tv7Diff)
        TextView seventhDiff;
        @BindView(R.id.tv7Pts)
        TextView seventhPts;

        @BindView(R.id.tv8T)
        TextView eighthT;
        @BindView(R.id.tv8P)
        TextView eighthP;
        @BindView(R.id.tv8W)
        TextView eighthW;
        @BindView(R.id.tv8L)
        TextView eighthL;
        @BindView(R.id.tv8D)
        TextView eighthD;
        @BindView(R.id.tv8Diff)
        TextView eighthDiff;
        @BindView(R.id.tv8Pts)
        TextView eighthPts;




        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        public void bind(final DocumentSnapshot snapshot) {

            Table table = snapshot.toObject(Table.class);
            Resources resources = itemView.getResources();



            team.setText(table.getTeam());
            division.setText(table.getDivision());
            won.setText(table.getWon());
            lost.setText(table.getLost());
            drew.setText(table.getDrew());
            points.setText(table.getPoints());
            played.setText(table.getPlayed());
            diff.setText(table.getDiff());

            firstT.setText(table.getFirstT());
            firstP.setText(table.getFirstP());
            firstW.setText(table.getFirstW());
            firstD.setText(table.getFirstD());
            firstL.setText(table.getFirstL());
            firstDiff.setText(table.getFirstDiff());
            firstPts.setText(table.getFirstPts());

            secondT.setText(table.getSecondT());
            secondP.setText(table.getSecondP());
            secondW.setText(table.getSecondW());
            secondD.setText(table.getSecondD());
            secondL.setText(table.getSecondL());
            secondDiff.setText(table.getSecondDiff());
            secondPts.setText(table.getSecondPts());

            thirdT.setText(table.getThirdT());
            thirdP.setText(table.getThirdP());
            thirdW.setText(table.getThirdW());
            thirdD.setText(table.getThirdD());
            thirdL.setText(table.getThirdL());
            thirdDiff.setText(table.getThirdDiff());
            thirdPts.setText(table.getThirdPts());

            fourthT.setText(table.getFourthT());
            fourthP.setText(table.getFourthP());
            fourthW.setText(table.getFourthW());
            fourthD.setText(table.getFourthD());
            fourthL.setText(table.getFourthL());
            fourthDiff.setText(table.getFourthDiff());
            fourthPts.setText(table.getFourthPts());

            fifthT.setText(table.getFifthT());
            fifthP.setText(table.getFifthP());
            fifthW.setText(table.getFifthW());
            fifthD.setText(table.getFifthD());
            fifthL.setText(table.getFifthL());
            fifthDiff.setText(table.getFifthDiff());
            fifthPts.setText(table.getFifthPts());

            sixthT.setText(table.getSixthT());
            sixthP.setText(table.getSixthP());
            sixthW.setText(table.getSixthW());
            sixthD.setText(table.getSixthD());
            sixthL.setText(table.getSixthL());
            sixthDiff.setText(table.getSixthDiff());
            sixthPts.setText(table.getSixthPts());

            seventhT.setText(table.getSeventhT());
            seventhP.setText(table.getSeventhP());
            seventhW.setText(table.getSeventhW());
            seventhD.setText(table.getSeventhD());
            seventhL.setText(table.getSeventhL());
            seventhDiff.setText(table.getSeventhDiff());
            seventhPts.setText(table.getSeventhPts());

            eighthT.setText(table.getEighthT());
            eighthP.setText(table.getEighthP());
            eighthW.setText(table.getEighthW());
            eighthD.setText(table.getEighthD());
            eighthL.setText(table.getEighthL());
            eighthDiff.setText(table.getEighthDiff());
            eighthPts.setText(table.getEighthPts());



        }


    }

}
