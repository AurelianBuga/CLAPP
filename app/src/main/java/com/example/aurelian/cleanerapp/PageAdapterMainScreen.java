package com.example.aurelian.cleanerapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aurelian on 3/15/2017.
 */

public class PageAdapterMainScreen extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public PageAdapterMainScreen(FragmentManager fm)
    {
        super(fm);
        fragments = new ArrayList<Fragment>();
        fragments.add(new Fragment1_HomeScreen());
        fragments.add(new Fragment2_AllToolsScreen());
        fragments.add(new Fragment3_SettingsScreen());
    }

    @Override
    public Fragment getItem(int arg0)
    {
        return this.fragments.get(arg0);
    }

    @Override
    public int getCount()
    {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int index)
    {
        switch (index){
            case 0:
                return "000000";
            case 1:
                return "111111";
            case 2:
                return "22222";
            default:
                return "default";
        }
    }
}
