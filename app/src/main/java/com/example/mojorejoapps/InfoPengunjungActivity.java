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


public class InfoPengunjungActivity extends AppCompatActivity {
    Toolbar toolbarInfoPengunjung;
    ViewPager viewPagerPgn;
    PagerAdapter pagerAdapterPgn;
    int[] img2;
    private static int currentpage2 = 0;
    private static int numpages2 = 0;
    FirebaseDatabase mDbInfoPgn;
    DatabaseReference mRefInfoPgn;
    JustifiedTextView profilPgn;
    JustifiedTextView visiPgn;
    JustifiedTextView misiPgn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pengunjung);
        toolbarInfoPengunjung = (Toolbar) findViewById(R.id.toolbarInfoPengunjung);
        setSupportActionBar(toolbarInfoPengunjung);
        getSupportActionBar().setTitle("Informasi Desa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDbInfoPgn = FirebaseDatabase.getInstance();
        mRefInfoPgn = mDbInfoPgn.getReference();

        profilPgn = findViewById(R.id.isiProfilDesaPgn);
        visiPgn = findViewById(R.id.isiVisiPgn);
        misiPgn = findViewById(R.id.isiMisiPgn1);

        initSlidingImgPgn();
        initInformasiPengunjung();

    }
    private void initInformasiPengunjung(){
        Query queryInfoPgn = mRefInfoPgn.child("InfoDesa");
        final GetInfo infoPgn = new GetInfo();
        queryInfoPgn.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                infoPgn.setProfil(dataSnapshot.child("profil").getValue().toString());
                infoPgn.setVisi(dataSnapshot.child("visi").getValue().toString());
                infoPgn.setMisi(dataSnapshot.child("misi").getValue().toString());

                profilPgn.setText(infoPgn.getProfil());
                visiPgn.setText(infoPgn.getVisi());
                misiPgn.setText(infoPgn.getMisi());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
    private void initSlidingImgPgn(){
        img2 = new int[]{
                R.drawable.aendgame, R.drawable.bendgame, R.drawable.cendgame, R.drawable.dendgame
        };
        viewPagerPgn = (ViewPager) findViewById(R.id.viewPagerPgn);
        pagerAdapterPgn = new ViewPagerAdapterPgn(InfoPengunjungActivity.this, img2);
        viewPagerPgn.setAdapter(pagerAdapterPgn);

        CircleIndicator indicatorPgn = (CircleIndicator) findViewById(R.id.circleIndicatorPgn);
        indicatorPgn.setViewPager(viewPagerPgn);
        viewPagerPgn.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentpage2 = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE) {
                    int pagecount2 = img2.length;
                    if (currentpage2 == 0) {
                        viewPagerPgn.setCurrentItem(pagecount2 - 1, false);
                    } else if (currentpage2 == pagecount2 - 1) {
                        viewPagerPgn.setCurrentItem(0, false);
                    }
                }
            }
        });
        final Handler handlerPgn = new Handler();
        final Runnable updatePgn = new Runnable() {
            @Override
            public void run() {
                if (currentpage2 == numpages2) {
                    currentpage2 = 0;
                }
                viewPagerPgn.setCurrentItem(currentpage2++, true);
            }
        };
        Timer swipePgn = new Timer();
        swipePgn.schedule(new TimerTask() {
            @Override
            public void run() {
                handlerPgn.post(updatePgn);
            }
        }, 1000, 1000);
    }
}
