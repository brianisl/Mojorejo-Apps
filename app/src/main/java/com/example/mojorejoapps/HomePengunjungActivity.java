package com.example.mojorejoapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomePengunjungActivity extends AppCompatActivity {
    Button panggilanPengunjung;
    Button infoMasy;
    Button brtPgn;
    Button potensi;
    Button kegiatanPgn;
    Toolbar homePgn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pengunjung);
        homePgn = findViewById(R.id.toolbarHomePgn);
        setSupportActionBar(homePgn);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Panggilan
        panggilanPengunjung = (Button) findViewById(R.id.panggilanPengunjung);
        panggilanPengunjung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(HomePengunjungActivity.this, PanggilanPengunjungActivity.class);
                startActivity(intent1);
            }
        });
        //Info Desa
        infoMasy = (Button) findViewById(R.id.infoDesaPengunjung);
        infoMasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info1 = new Intent(HomePengunjungActivity.this, InfoPengunjungActivity.class);
                startActivity(info1);
            }
        });
        //Berita
        brtPgn = (Button) findViewById(R.id.beritaPengunjung);
        brtPgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent berita1 = new Intent(HomePengunjungActivity.this, BeritaPengunjungActivity.class);
                startActivity(berita1);
            }
        });
        //Potensi
        potensi = findViewById(R.id.potensiPengunjung);
        potensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent potensi = new Intent(HomePengunjungActivity.this, PotensiActivity.class);
                startActivity(potensi);
            }
        });
        //Kegiatan
        kegiatanPgn = findViewById(R.id.kegiatanPengunjung);
        kegiatanPgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kegiatanPgn = new Intent(HomePengunjungActivity.this, KegiatanPengunjungActivity.class);
                startActivity(kegiatanPgn);
            }
        });
    }
}

