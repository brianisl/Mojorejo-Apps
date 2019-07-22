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

public class ViewPagerAdapterUmkm extends PagerAdapter {
    int[] imgUMKM;
    LayoutInflater inflaterUMKM;
    Context contextUMKM;

    public ViewPagerAdapterUmkm(UmkmActivity umkmActivity, int[] imgUMKM) {
        this.contextUMKM = umkmActivity;
        this.imgUMKM = imgUMKM;
    }

    @Override
    public int getCount() {
        return imgUMKM.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((RelativeLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView trailImgUMKM;
        inflaterUMKM = (LayoutInflater) contextUMKM.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemViewUMKM = inflaterUMKM.inflate(R.layout.item_umkm, container, false);
        trailImgUMKM = (ImageView) itemViewUMKM.findViewById(R.id.imgUMKM);
        trailImgUMKM.setImageResource(imgUMKM[position]);
        ((ViewPager) container).addView(itemViewUMKM);

        return itemViewUMKM;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((RelativeLayout)object);
    }
}
