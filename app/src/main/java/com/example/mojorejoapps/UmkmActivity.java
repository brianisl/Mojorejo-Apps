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

public class UmkmActivity extends AppCompatActivity {
    Toolbar toolbarUMKM;
    ViewPager viewPagerUMKM;
    PagerAdapter pagerAdapterUMKM;
    int[] imgUMKM;
    private static int currentpageUMKM = 0;
    private static int numpagesUMKM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umkm);
        toolbarUMKM = (Toolbar) findViewById(R.id.toolbarUMKM);
        setSupportActionBar(toolbarUMKM);
        getSupportActionBar().setTitle("UMKM");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imgUMKM = new int[]{
                R.drawable.aendgame, R.drawable.bendgame, R.drawable.cendgame, R.drawable.dendgame
        };
        viewPagerUMKM = (ViewPager) findViewById(R.id.viewPagerUMKM);
        pagerAdapterUMKM = new ViewPagerAdapterUmkm(UmkmActivity.this, imgUMKM);
        viewPagerUMKM.setAdapter(pagerAdapterUMKM);

        CircleIndicator indicatorUMKM = (CircleIndicator) findViewById(R.id.circleIndicatorUMKM);
        indicatorUMKM.setViewPager(viewPagerUMKM);
        viewPagerUMKM.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentpageUMKM = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE) {
                    int pagecount2 = imgUMKM.length;
                    if (currentpageUMKM == 0) {
                        viewPagerUMKM.setCurrentItem(pagecount2 - 1, false);
                    } else if (currentpageUMKM == pagecount2 - 1) {
                        viewPagerUMKM.setCurrentItem(0, false);
                    }
                }
            }
        });
        final Handler handlerUMKM = new Handler();
        final Runnable updateUMKM = new Runnable() {
            @Override
            public void run() {
                if (currentpageUMKM == numpagesUMKM) {
                    currentpageUMKM = 0;
                }
                viewPagerUMKM.setCurrentItem(currentpageUMKM++, true);
            }
        };
        Timer swipeUMKM = new Timer();
        swipeUMKM.schedule(new TimerTask() {
            @Override
            public void run() {
                handlerUMKM.post(updateUMKM);
            }
        }, 1000, 1000);
    }
}
