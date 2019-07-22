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

public class ViewPagerAdapterPariwisata extends PagerAdapter {
    int[] imgPariwisata;
    LayoutInflater inflaterPariwisata;
    Context contextPariwisata;

    public ViewPagerAdapterPariwisata(PariwisataActivity pariwisataActivity, int[] imgPariwisata) {
        this.contextPariwisata = pariwisataActivity;
        this.imgPariwisata = imgPariwisata;
    }

    @Override
    public int getCount() {
        return imgPariwisata.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((RelativeLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView trailImgPariwisata;
        inflaterPariwisata = (LayoutInflater) contextPariwisata.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemViewPariwisata = inflaterPariwisata.inflate(R.layout.item_pariwisata, container, false);
        trailImgPariwisata = (ImageView) itemViewPariwisata.findViewById(R.id.imgPariwisata);
        trailImgPariwisata.setImageResource(imgPariwisata[position]);
        ((ViewPager) container).addView(itemViewPariwisata);

        return itemViewPariwisata;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((RelativeLayout)object);
    }
}
