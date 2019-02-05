package com.example.homeactivity.utils;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SectionStatePagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mfragmentList = new ArrayList<>();
    private final HashMap<Fragment,Integer> mFragments = new HashMap<>();
    private final HashMap<String,Integer> mFragmentNumbers = new HashMap<>();
    private final HashMap<Integer,String> mFragmentNames = new HashMap<>();
    public SectionStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return mfragmentList.get(i);
    }

    @Override
    public int getCount() {
        return mfragmentList.size();
    }
    public void addFragment(Fragment fragment,String fragmentName)
    {
        mfragmentList.add(fragment);
        mFragments.put(fragment,mfragmentList.size()-1);
        mFragmentNumbers.put(fragmentName,mfragmentList.size()-1);
        mFragmentNames.put(mfragmentList.size()-1,fragmentName);
    }
    public Integer getFragmentNumber(String FragmentName)
    {
        if (mFragmentNumbers.containsKey(FragmentName))
        {
            return  mFragmentNumbers.get(FragmentName);
        }
        else {
            return null;
        }
    }
    public Integer getFragmentNumber(Fragment fragment)
    {
        if (mFragments.containsKey(fragment))
        {
            return  mFragments.get(fragment);
        }
        else {
            return null;
        }
    } public String getFragmentName(Integer fragment)
    {
        if (mFragmentNames.containsKey(fragment))
        {
            return  mFragmentNames.get(fragment);
        }
        else {
            return null;
        }
    }
}
