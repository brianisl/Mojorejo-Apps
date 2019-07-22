package com.example.mojorejoapps;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.codesgood.views.JustifiedTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class InfoWargaActivity extends AppCompatActivity {
    Toolbar toolbarInfoWarga;
    ViewPager viewPagerWrg;
    PagerAdapter pagerAdapterWrg;
    int[] img;
    private static int currentpage = 0;
    private static int numpages = 0;
    FirebaseDatabase mDbInfoWrg;
    DatabaseReference mRefInfoWrg;
    JustifiedTextView profilWrg;
    JustifiedTextView visiWrg;
    JustifiedTextView misiWrg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_warga);
        toolbarInfoWarga = (Toolbar) findViewById(R.id.toolbarInfoWarga);
        setSupportActionBar(toolbarInfoWarga);
        getSupportActionBar().setTitle("Informasi Desa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDbInfoWrg = FirebaseDatabase.getInstance();
        mRefInfoWrg = mDbInfoWrg.getReference();

        profilWrg = findViewById(R.id.isiProfilDesaWrg);
        visiWrg = findViewById(R.id.isiVisiWrg);
        misiWrg = findViewById(R.id.isiMisiWrg1);

        initSlidingImgWrg();
        initInformasiWarga();
    }

    private void initInformasiWarga() {
        Query queryInfoWrg = mRefInfoWrg.child("InfoDesa");
        final GetInfo infoWarga = new GetInfo();
        queryInfoWrg.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                infoWarga.setProfil(dataSnapshot.child("profil").getValue().toString());
                infoWarga.setVisi(dataSnapshot.child("visi").getValue().toString());
                infoWarga.setMisi(dataSnapshot.child("misi").getValue().toString());

                profilWrg.setText(infoWarga.getProfil());
                misiWrg.setText(infoWarga.getMisi());
                visiWrg.setText(infoWarga.getVisi());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void initSlidingImgWrg() {
        img = new int[]{
                R.drawable.aendgame, R.drawable.bendgame, R.drawable.cendgame, R.drawable.dendgame
        };
        viewPagerWrg = (ViewPager) findViewById(R.id.viewPagerWrg);
        pagerAdapterWrg = new ViewPagerAdapterWrg(InfoWargaActivity.this, img);
        viewPagerWrg.setAdapter(pagerAdapterWrg);

        CircleIndicator indicatorWrg = (CircleIndicator) findViewById(R.id.circleIndicatorWrg);
        indicatorWrg.setViewPager(viewPagerWrg);

        viewPagerWrg.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentpage = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE) {
                    int pagecount = img.length;
                    if (currentpage == 0) {
                        viewPagerWrg.setCurrentItem(pagecount - 1, false);
                    } else if (currentpage == pagecount - 1) {
                        viewPagerWrg.setCurrentItem(0, false);
                    }
                }
            }
        });
        final Handler handlerWrg = new Handler();
        final Runnable updateWrg = new Runnable() {
            @Override
            public void run() {
                if (currentpage == numpages) {
                    currentpage = 0;
                }
                viewPagerWrg.setCurrentItem(currentpage++, true);
            }
        };
        Timer swipeWrg = new Timer();
        swipeWrg.schedule(new TimerTask() {
            @Override
            public void run() {
                handlerWrg.post(updateWrg);
            }
        }, 1000, 1000);
    }
}
