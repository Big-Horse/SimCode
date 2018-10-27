package com.bighorse.simcode;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback{

    private AdView mAdView;

    private ViewPager mViewPager;
    private MyPagerAdapter mMyPagerAdapter;
    private List<Sim> mSimList;


    public static final int REQUEST_READ_PHONE_STATE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mMyPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMyPagerAdapter);

        MobileAds.initialize(this, "ca-app-pub-5005687032079051~5324024505");

        mAdView = findViewById(R.id.adView_banner);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        checkPermissions();
    }

    public void checkPermissions(){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_STATE);
        }else{
            initPager();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_PHONE_STATE:
                if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    initPager();
                }
                else{
                    checkPermissions();
                }
                break;

            default:
                break;
        }
    }

    public void initPager(){
        mSimList = new ArrayList<>();
        mSimList = SimUtils.getSimsInfos(this);

        mSimList.add(new Sim());
        mMyPagerAdapter.addSimList(mSimList);
    }
}
