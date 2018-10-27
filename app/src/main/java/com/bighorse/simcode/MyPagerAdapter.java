package com.bighorse.simcode;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;


public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private List<Sim> simList = new ArrayList();

    MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override    public Fragment getItem(int position) {
        switch (position){
            case 0: {
                Bundle bundle = new Bundle();
                bundle.putSerializable("sim", simList.get(position));
                SimFragment fragobj = new SimFragment();
                fragobj.setArguments(bundle);
                return fragobj;
            }
            case 1: {
                Bundle bundle = new Bundle();
                bundle.putSerializable("sim", simList.get(position));
                SimFragment fragobj = new SimFragment();
                fragobj.setArguments(bundle);
                return fragobj;
            }
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
                if(simList.size() == 1){
                    return "SIM";
                } else {
                    return "SIM 1";
                }
            case 1:
                return "SIM 2";
            default:
                return null;
        }
    }

    public void addSimList(List<Sim> sims) {
        simList.addAll(sims);
        notifyDataSetChanged();
    }
}