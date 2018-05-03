package com.example.gerard.gaalive.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gerard on 30/01/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> lstFragment= new ArrayList();
    List<String> lstTitles= new ArrayList<>();

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstTitles.get(position);
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
    }

    @Override
    public int getCount() {
        return lstTitles.size();
    }

    public void AddFragment(Fragment fragment, String title){
        lstFragment.add(fragment);
        lstTitles.add(title);
    }
}
