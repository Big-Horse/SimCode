package com.bighorse.simcode;

import android.os.Parcelable;
import android.telephony.SubscriptionInfo;

import java.io.Serializable;


class Sim implements Serializable {

    private String ICCID;
    private String IMEI;
    private String operatorName;
    private String phoneNumber;

    public Sim(SubscriptionInfo infoSim) {
        ICCID = infoSim.getIccId();
        IMEI = String.valueOf(infoSim.getMnc());
        operatorName = String.valueOf(infoSim.getCarrierName());
        phoneNumber = infoSim.getNumber();
    }

    void Sim(String ICCID, String IMEI, String operatorName, String phoneNumber){
        this.ICCID = ICCID;
        this.IMEI = IMEI;
        this.operatorName = operatorName;
        this.phoneNumber = phoneNumber;
    }

    void Sim(SubscriptionInfo info){

    }

    public String getICCID() {
        return ICCID;
    }

    public String getIMEI() {
        return IMEI;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
