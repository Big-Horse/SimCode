package com.bighorse.simcode;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class MyPagerAdapter extends FragmentStatePagerAdapter {

    List<Sim> simList = new ArrayList();

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override    public Fragment getItem(int position) {
        switch (position){
            case 0: return SimFragment.newInstance(simList.get(0));
            case 1: return SimFragment.newInstance(simList.get(1));
        }
        return null;
    }

    @Override
    public int getCount() {
        return simList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Sim 1";
            case 1:
                return "Sim 2";
            default:
                return null;
        }
    }

    public void addSimList(List<Sim> sims) {
        simList.addAll(sims);
        notifyDataSetChanged();
    }
}