package com.bighorse.simcode;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.TELEPHONY_SERVICE;
import static android.content.Context.TELEPHONY_SUBSCRIPTION_SERVICE;

class SimUtils {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
    static List<Sim> getSimsInfos(Context context) {

        List<Sim> simsList = new ArrayList<>();

        SubscriptionManager subManager = (SubscriptionManager) context.getSystemService(TELEPHONY_SUBSCRIPTION_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            List<SubscriptionInfo> subInfoList = subManager.getActiveSubscriptionInfoList();

            for(int i = 0; i < subInfoList.size(); i++ ) {
                SubscriptionInfo infoSim = subManager.getActiveSubscriptionInfoForSimSlotIndex(i);

                String ICCID = infoSim.getIccId();
                String phoneNumber = infoSim.getNumber();
                String operatorName = String.valueOf(infoSim.getCarrierName());

                Sim sim = new Sim();
                sim.ICCID = ICCID;
                sim.phoneNumber = phoneNumber;
                sim.operatorName = operatorName;

                TelephonyManager tm = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);

                Method getSubId = null;

                try {
                    getSubId = TelephonyManager.class.getMethod("getSubscriberId", int.class);
                    SubscriptionManager sm = (SubscriptionManager) context.getSystemService(TELEPHONY_SUBSCRIPTION_SERVICE);
                    sim.IMSI = (String) getSubId.invoke(tm, sm.getActiveSubscriptionInfoForSimSlotIndex(i).getSubscriptionId());
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }

                simsList.add(sim);
            }
        }


        return simsList;
    }
}
