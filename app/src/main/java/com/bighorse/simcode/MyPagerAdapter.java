package com.bighorse.simcode;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MyPagerAdapter extends PagerAdapter {

    Context mContext;
    MyPagerAdapter(Context context){
        mContext = context;
    }
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o==view;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.pager_adapter_item, container, false);
        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((Button)object);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Sim" + String.valueOf(position + 1);
    }
}