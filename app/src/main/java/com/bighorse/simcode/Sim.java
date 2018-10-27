package com.bighorse.simcode;

import android.os.Parcelable;
import android.telephony.SubscriptionInfo;

import java.io.Serializable;


class Sim implements Serializable {

    public String ICCID;
    public String IMSI;
    public String operatorName;
    public String phoneNumber;

    public Sim(){
        ICCID = "";
        IMSI = "";
        operatorName = "";
        phoneNumber = "";
    }

}
