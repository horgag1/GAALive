package com.example.gerard.gaalive;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gerard.gaalive.adapter.ViewPagerAdapter;
import com.example.gerard.gaalive.fragments.FirstFragment;
import com.example.gerard.gaalive.fragments.FourthFragment;
import com.example.gerard.gaalive.fragments.SecondFragment;
import com.example.gerard.gaalive.fragments.ThirdFragment;

public class Main2Activity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tabLayout= findViewById(R.id.tablayout_id);
        viewPager= findViewById(R.id.viewpager_id);
        adapter= new ViewPagerAdapter(getSupportFragmentManager());

        // Add fragment here.

        adapter.AddFragment(new FirstFragment(), "Live");
        adapter.AddFragment(new ThirdFragment(),"Teams");
        adapter.AddFragment(new FourthFragment(),"Fix/res");
        adapter.AddFragment(new SecondFragment(), "Tables");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        ActionBar actionBar= getSupportActionBar();
        actionBar.setElevation(0);
    }
}
