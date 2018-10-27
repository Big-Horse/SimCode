package com.bighorse.simcode;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimFragment extends Fragment {
    public static final String TAG = "SimFragment";
    private static Sim mSim;
    private TextView mPhoneNumberTextView;
    private TextView mOperatorTextView;
    private TextView mSimNumberOneTextView;
    private TextView mSimNumberTwoTextView;

    public SimFragment(Sim sim){
        mSim = sim;
    }

    public static Fragment newInstance(Sim sim) {

        SimFragment view = new SimFragment(sim);

        return view;
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.pager_adapter_item, container, false);

        mPhoneNumberTextView = (TextView) rootView.findViewById(R.id.phone_number_description_text_view);
        mOperatorTextView = (TextView) rootView.findViewById(R.id.operator_description_text_view);
        mSimNumberOneTextView = (TextView) rootView.findViewById(R.id.sim_number_description_text_view);
        mSimNumberTwoTextView = (TextView) rootView.findViewById(R.id.sim_number_description_two_text_view);

        mPhoneNumberTextView.setText(mSim.getPhoneNumber());
        mOperatorTextView.setText(mSim.getOperatorName());
        mSimNumberOneTextView.setText(mSim.getICCID());
        mSimNumberTwoTextView.setText(mSim.getIMEI());
        return rootView;
    }
}
