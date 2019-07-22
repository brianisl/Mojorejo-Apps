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

public class ViewPagerAdapterWrg extends PagerAdapter {
    int imageWrg[];
    LayoutInflater inflaterWrg;
    Context contextWrg;

    public ViewPagerAdapterWrg(InfoWargaActivity InfoWargaActivity, int[] img) {
        this.contextWrg = InfoWargaActivity;
        this.imageWrg = img;
    }

    @Override
    public int getCount() {
        return imageWrg.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((RelativeLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView trailImg;
        inflaterWrg = (LayoutInflater) contextWrg.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewWrg = inflaterWrg.inflate(R.layout.item_warga, container, false);
        trailImg = (ImageView) viewWrg.findViewById(R.id.imgInfoWrg);
        trailImg.setImageResource(imageWrg[position]);

        ((ViewPager)container).addView(viewWrg);

        return viewWrg;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager)container).removeView((RelativeLayout)object);
    }
}
