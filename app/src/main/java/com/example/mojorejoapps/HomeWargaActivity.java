package com.example.mojorejoapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeWargaActivity extends AppCompatActivity {
    Button panggil;
    Button infoWrg;
    Button brtWrg;
    Button pekerjaan;
    Button kegiatanWrg;
    Toolbar homeWrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_warga);
        homeWrg = findViewById(R.id.toolbarHomeWrg);
        setSupportActionBar(homeWrg);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //panggilan warga
        panggil = (Button) findViewById(R.id.panggilanWarga);
        panggil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent panggilanWrg = new Intent(HomeWargaActivity.this, PanggilanWargaActivity.class);
                startActivity(panggilanWrg);
            }
        });
        //Info Desa
        infoWrg = (Button) findViewById(R.id.infoDesaWarga);
        infoWrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info2 = new Intent(HomeWargaActivity.this, InfoWargaActivity.class);
                startActivity(info2);
            }
        });
        //Berita
        brtWrg = (Button) findViewById(R.id.beritaWarga);
        brtWrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent brt2 = new Intent(HomeWargaActivity.this, BeritaWargaActivity.class);
                startActivity(brt2);
            }
        });
        //Lapangan Pekerjaan
        pekerjaan = (Button) findViewById(R.id.pekerjaanWarga);
        pekerjaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pekerjaanWrg = new Intent(HomeWargaActivity.this, LapanganPekerjaanActivity.class);
                startActivity(pekerjaanWrg);
            }
        });
        //Kegiatan
        kegiatanWrg = findViewById(R.id.kegiatanWarga);
        kegiatanWrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kegiatanWrg = new Intent(HomeWargaActivity.this, KegiatanWargaActivity.class);
                startActivity(kegiatanWrg);
            }
        });
    }
}

