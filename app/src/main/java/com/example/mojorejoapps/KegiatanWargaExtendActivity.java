package com.example.mojorejoapps;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class KegiatanWargaExtendActivity extends AppCompatActivity {
    Toolbar toolbarKgtWrgExt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kegiatan_warga_extend);
        toolbarKgtWrgExt = findViewById(R.id.toolbarKgtWrgExt);
        setSupportActionBar(toolbarKgtWrgExt);
        getSupportActionBar().setTitle("Kegiatan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getIncomingIntentKgtWrg();
    }

    private void getIncomingIntentKgtWrg() {
        if (getIntent().hasExtra("judulKegiatan") && getIntent().hasExtra("isiKegiatan") &&
                getIntent().hasExtra("tanggalKegiatan") && getIntent().hasExtra("lokasiKegiatan") &&
                getIntent().hasExtra("gambarKegiatan")) {
            String judulKgtWrg = getIntent().getStringExtra("judulKegiatan");
            String isiKgtWrg = getIntent().getStringExtra("isiKegiatan");
            String tglKgtWrg = getIntent().getStringExtra("tanggalKegiatan");
            String lksKegiatan = getIntent().getStringExtra("lokasiKegiatan");
            String gbrKegiatan = getIntent().getStringExtra("gambarKegiatan");
            setContentKgtWrg(judulKgtWrg, isiKgtWrg, tglKgtWrg, lksKegiatan, gbrKegiatan);
        }
    }
    private void setContentKgtWrg(String judulKgtWrg, String isiKgtWrg, String tglKgtWrg, String lksKgtWrg, String gbrKgtWrg){
        TextView judulKgt = findViewById(R.id.judulKgtWrgExt);
        judulKgt.setText(judulKgtWrg);

        TextView isiKgt = findViewById(R.id.isiKgtWrgExt);
        isiKgt.setText(isiKgtWrg);

        TextView tglKgt = findViewById(R.id.tanggalPelaksanaanWrg);
        tglKgt.setText(tglKgtWrg);

        TextView lksKgt = findViewById(R.id.lokasiPelaksanaanWrg);
        lksKgt.setText(lksKgtWrg);

        ImageView gmbrKgt = findViewById(R.id.imgKgtWrgExt);
        Glide.with(this)
                .asBitmap()
                .load(gbrKgtWrg)
                .into(gmbrKgt);
    }
}

