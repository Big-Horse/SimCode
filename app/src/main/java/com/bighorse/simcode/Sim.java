package com.bighorse.simcode;

class Sim {

    private String ICCID;
    private String IMEI;
    private String operatorName;

    void sim(String ICCID, String IMEI, String operatorName){
        this.ICCID = ICCID;
        this.IMEI = IMEI;
        this.operatorName = operatorName;
    }

}
