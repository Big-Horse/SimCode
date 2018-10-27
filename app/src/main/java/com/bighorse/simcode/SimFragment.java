package com.bighorse.simcode;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimFragment extends Fragment {
    public static final String TAG = "SimFragment";
    private Sim mSim;
    private TextView mPhoneNumberTextView;
    private TextView mOperatorTextView;
    private TextView mSimNumberOneTextView;
    private TextView mSimNumberTwoTextView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSim = (Sim) getArguments().getSerializable("sim");
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

        mPhoneNumberTextView.setText(mSim.phoneNumber);
        mOperatorTextView.setText(mSim.operatorName);
        mSimNumberOneTextView.setText(mSim.ICCID);
        mSimNumberTwoTextView.setText(mSim.IMSI);
        return rootView;
    }
}
