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

public class PariwisataActivity extends AppCompatActivity {
    Toolbar toolbarPariwisata;
    ViewPager viewPagerPariwisata;
    PagerAdapter pagerAdapterPariwisata;
    int[] imgPariwisata;
    private static int currentpagePariwisata = 0;
    private static int numpagesPariwisata = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pariwisata);
        toolbarPariwisata = (Toolbar) findViewById(R.id.toolbarPariwisata);
        setSupportActionBar(toolbarPariwisata);
        getSupportActionBar().setTitle("Pariwisata");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imgPariwisata = new int[]{
                R.drawable.aendgame, R.drawable.bendgame, R.drawable.cendgame, R.drawable.dendgame
        };
        viewPagerPariwisata = (ViewPager) findViewById(R.id.viewPagerPariwisata);
        pagerAdapterPariwisata = new ViewPagerAdapterPariwisata(PariwisataActivity.this, imgPariwisata);
        viewPagerPariwisata.setAdapter(pagerAdapterPariwisata);

        CircleIndicator indicatorPariwisata = (CircleIndicator) findViewById(R.id.circleIndicatorPariwisata);
        indicatorPariwisata.setViewPager(viewPagerPariwisata);
        viewPagerPariwisata.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentpagePariwisata = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE) {
                    int pagecount2 = imgPariwisata.length;
                    if (currentpagePariwisata == 0) {
                        viewPagerPariwisata.setCurrentItem(pagecount2 - 1, false);
                    } else if (currentpagePariwisata == pagecount2 - 1) {
                        viewPagerPariwisata.setCurrentItem(0, false);
                    }
                }
            }
        });
        final Handler handlerPariwisata = new Handler();
        final Runnable updatePariwisata = new Runnable() {
            @Override
            public void run() {
                if (currentpagePariwisata == numpagesPariwisata) {
                    currentpagePariwisata = 0;
                }
                viewPagerPariwisata.setCurrentItem(currentpagePariwisata++, true);
            }
        };
        Timer swipePariwisata = new Timer();
        swipePariwisata.schedule(new TimerTask() {
            @Override
            public void run() {
                handlerPariwisata.post(updatePariwisata);
            }
        }, 1000, 1000);
    }
}

