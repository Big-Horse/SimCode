package com.bighorse.simcode;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SimFragment extends Fragment {
    public static final String TAG = "SimFragment";
    private static Sim mSim;

    public static Fragment newInstance(Sim sim) {
        mSim = sim;
        return new SimFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.pager_adapter_item, container, false);

        return rootView;
    }
}
