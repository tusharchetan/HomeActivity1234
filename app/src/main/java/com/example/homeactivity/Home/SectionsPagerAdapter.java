package com.example.homeactivity.Home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

import java.util.ArrayList;
import java.util.List;
/*Fragement for storingg fragements*/
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private static final String Tag ="SectionPagerAdapter";
    private final List<Fragment> mFragementList = new ArrayList<>();
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragementList.get(position);
    }

    @Override
    public int getCount() {
        return mFragementList.size();
    }
    public void addFragement(Fragment fragment)
    {
        mFragementList.add(fragment);
    }
}
