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

public class ViewPagerAdapterPgn extends PagerAdapter {
    int[] imgPgn;
    LayoutInflater inflaterPgn;
    Context contextPgn;

    public ViewPagerAdapterPgn(InfoPengunjungActivity infoPengunjungActivity, int[] imgPgn) {
        this.contextPgn = infoPengunjungActivity;
        this.imgPgn = imgPgn;
    }

    @Override
    public int getCount() {
        return imgPgn.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((RelativeLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView trailImgPgn;
        inflaterPgn = (LayoutInflater) contextPgn.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemViewPgn = inflaterPgn.inflate(R.layout.item_pengunjung, container, false);
        trailImgPgn = (ImageView) itemViewPgn.findViewById(R.id.imgInfoPgn);
        trailImgPgn.setImageResource(imgPgn[position]);
        ((ViewPager) container).addView(itemViewPgn);

        return itemViewPgn;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((RelativeLayout)object);
    }
}
