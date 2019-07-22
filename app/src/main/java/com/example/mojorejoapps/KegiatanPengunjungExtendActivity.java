package com.example.mojorejoapps;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class KegiatanPengunjungExtendActivity extends AppCompatActivity {
    Toolbar toolbarKgtPgnExt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kegiatan_pengunjung_extend);
        toolbarKgtPgnExt = findViewById(R.id.toolbarKgtPgnExt);
        setSupportActionBar(toolbarKgtPgnExt);
        getSupportActionBar().setTitle("Kegiatan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getIncomingIntentKgtPgn();
    }

    private void getIncomingIntentKgtPgn() {
        if (getIntent().hasExtra("judulKegiatan") && getIntent().hasExtra("isiKegiatan") &&
                getIntent().hasExtra("tanggalKegiatan") && getIntent().hasExtra("lokasiKegiatan") &&
                getIntent().hasExtra("gambarKegiatan")) {
            String judulKgtPgn = getIntent().getStringExtra("judulKegiatan");
            String isiKgtPgn = getIntent().getStringExtra("isiKegiatan");
            String tglKgtPgn = getIntent().getStringExtra("tanggalKegiatan");
            String lksKegiatan = getIntent().getStringExtra("lokasiKegiatan");
            String gbrKegiatan = getIntent().getStringExtra("gambarKegiatan");
            setContentKgtPgn(judulKgtPgn, isiKgtPgn, tglKgtPgn, lksKegiatan, gbrKegiatan);
        }
    }
    private void setContentKgtPgn(String judulKgtPgn, String isiKgtPgn, String tglKgtPgn, String lksKgtPgn, String gbrKgtPgn){
        TextView judulKgt = findViewById(R.id.judulKgtPgnExt);
        judulKgt.setText(judulKgtPgn);

        TextView isiKgt = findViewById(R.id.isiKgtPgnExt);
        isiKgt.setText(isiKgtPgn);

        TextView tglKgt = findViewById(R.id.tanggalPelaksanaanPgn);
        tglKgt.setText(tglKgtPgn);

        TextView lksKgt = findViewById(R.id.lokasiPelaksanaanPgn);
        lksKgt.setText(lksKgtPgn);

        ImageView gmbrKgt = findViewById(R.id.imgKgtPgnExt);
        Glide.with(this)
                .asBitmap()
                .load(gbrKgtPgn)
                .into(gmbrKgt);
    }
}
