package com.bighorse.simcode;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    private ViewPager mViewPager;
    private MyPagerAdapter mMyPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mMyPagerAdapter = new MyPagerAdapter(this);
        mViewPager.setAdapter(mMyPagerAdapter);

        MobileAds.initialize(this, "ca-app-pub-5005687032079051~5324024505");

        mAdView = findViewById(R.id.adView_banner);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
