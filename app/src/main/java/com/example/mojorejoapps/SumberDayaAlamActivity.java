package com.example.mojorejoapps;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class SumberDayaAlamActivity extends AppCompatActivity {
    Toolbar toolbarSDA;
    ViewPager viewPagerSDA;
    PagerAdapter pagerAdapterSDA;
    int[] imgSDA;
    private static int currentpageSDA = 0;
    private static int numpagesSDA = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumber_daya_alam);
        toolbarSDA = findViewById(R.id.toolbarSDA);
        setSupportActionBar(toolbarSDA);
        getSupportActionBar().setTitle("Sumber Daya Alam");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgSDA = new int[]{
                R.drawable.sd_alam_1, R.drawable.sd_alam_2
        };
        viewPagerSDA = (ViewPager) findViewById(R.id.viewPagerSDA);
        pagerAdapterSDA = new ViewPagerAdapterSDA(SumberDayaAlamActivity.this, imgSDA);
        viewPagerSDA.setAdapter(pagerAdapterSDA);

        CircleIndicator indicatorSDA = (CircleIndicator) findViewById(R.id.circleIndicatorSDA);
        indicatorSDA.setViewPager(viewPagerSDA);
        viewPagerSDA.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentpageSDA = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE) {
                    int pagecount2 = imgSDA.length;
                    if (currentpageSDA == 0) {
                        viewPagerSDA.setCurrentItem(pagecount2 - 1, false);
                    } else if (currentpageSDA == pagecount2 - 1) {
                        viewPagerSDA.setCurrentItem(0, false);
                    }
                }
            }
        });
        final Handler handlerSDA = new Handler();
        final Runnable updateSDA = new Runnable() {
            @Override
            public void run() {
                if (currentpageSDA == numpagesSDA) {
                    currentpageSDA = 0;
                }
                viewPagerSDA.setCurrentItem(currentpageSDA++, true);
            }
        };
        Timer swipeSDA = new Timer();
        swipeSDA.schedule(new TimerTask() {
            @Override
            public void run() {
                handlerSDA.post(updateSDA);
            }
        }, 1000, 1000);
    }
}
