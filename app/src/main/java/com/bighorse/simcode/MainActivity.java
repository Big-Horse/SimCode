package com.bighorse.simcode;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    private ViewPager mViewPager;
    private MyPagerAdapter mMyPagerAdapter;
    private List<Sim> mSimList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager)findViewById(R.id.pager);
        mMyPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMyPagerAdapter);
        mSimList = new ArrayList<>();
        mSimList.add(new Sim());
        mSimList.add(new Sim());
        mMyPagerAdapter.addSimList(mSimList);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);

        MobileAds.initialize(this, "ca-app-pub-5005687032079051~5324024505");

        mAdView = findViewById(R.id.adView_banner);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
