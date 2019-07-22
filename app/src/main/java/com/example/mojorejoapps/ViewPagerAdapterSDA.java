package com.example.mojorejoapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerAdapterSDA extends PagerAdapter {
    int[] imgSDA;
    LayoutInflater inflaterSDA;
    Context contextSDA;

    public ViewPagerAdapterSDA(SumberDayaAlamActivity sumberDayaAlamActivity, int[] imgSDA) {
        this.contextSDA = sumberDayaAlamActivity;
        this.imgSDA = imgSDA;
    }

    @Override
    public int getCount() {
        return imgSDA.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((RelativeLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView trailImgSDA;
        inflaterSDA = (LayoutInflater) contextSDA.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemViewSDA = inflaterSDA.inflate(R.layout.item_sda, container, false);
        trailImgSDA = (ImageView) itemViewSDA.findViewById(R.id.imgSDA);
        trailImgSDA.setImageResource(imgSDA[position]);
        ((ViewPager) container).addView(itemViewSDA);

        return itemViewSDA;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
}
