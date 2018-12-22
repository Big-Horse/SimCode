package com.bighorse.simcode;

import android.support.design.widget.TabLayout;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback{

    private static int videoAttempts = 0;
    private AdView mAdView;

    private ViewPager mViewPager;
    private MyPagerAdapter mMyPagerAdapter;
    private List<Sim> mSimList;


    public static final int REQUEST_READ_PHONE_STATE = 0;
    private static InterstitialAd mInterstitialMainAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mMyPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMyPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                addVideoAttempt();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);

        MobileAds.initialize(this, getResources().getString(R.string.admob_APP_Key));

        mInterstitialMainAd = new InterstitialAd(this);
        mInterstitialMainAd.setAdUnitId("ca-app-pub-5005687032079051/2395023464");
        mInterstitialMainAd.loadAd(new AdRequest.Builder().build());

        mInterstitialMainAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mInterstitialMainAd.show();
            }

            @Override
            public void onAdClosed() {
                mInterstitialMainAd.loadAd(new AdRequest.Builder().build());
            }
        });


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
    public static void addVideoAttempt() {
        videoAttempts++;

        if ((videoAttempts !=0) && (videoAttempts %2 == 0)) {
            mInterstitialMainAd.show();
        }else{
            mInterstitialMainAd.loadAd(new AdRequest.Builder().build());
        }
    }

    public void initPager(){
        mSimList = new ArrayList<>();
        mSimList = SimUtils.getSimsInfos(this);
        mMyPagerAdapter.addSimList(mSimList);
    }
}
