package com.bighorse.simcode;

import android.telephony.SubscriptionInfo;


class Sim {

    private String ICCID;
    private String IMEI;
    private String operatorName;
    private String phoneNumber;

    public Sim(SubscriptionInfo info) {
        ICCID = info.getIccId();
        IMEI = String.valueOf(info.getMnc());
        operatorName = String.valueOf(info.getCarrierName());
        phoneNumber = info.getNumber();
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
