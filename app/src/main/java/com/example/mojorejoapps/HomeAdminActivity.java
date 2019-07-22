package com.example.mojorejoapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeAdminActivity extends AppCompatActivity {
    Toolbar toolbarHomeAdmin;
    Button tmbhBrt;
    Button tmbhKgt;
    Button tmbhPkrj;
    Button lihatLaporan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);
        toolbarHomeAdmin = findViewById(R.id.toolbarHomeAdm);
        setSupportActionBar(toolbarHomeAdmin);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_logout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Tambah Berita
        tmbhBrt = findViewById(R.id.tambahBeritaAdm);
        tmbhBrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tmbhBrt = new Intent(HomeAdminActivity.this, TambahBeritaAdminActivity.class);
                startActivity(tmbhBrt);
            }
        });

        //Tambah Kegiatan
        tmbhKgt = findViewById(R.id.tambahKegiatanAdm);
        tmbhKgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tmbhKgt = new Intent(HomeAdminActivity.this, TambahKegiatanAdminActivity.class);
                startActivity(tmbhKgt);
            }
        });

        //Tambah Lapangan Pekerjaan
        tmbhPkrj = findViewById(R.id.tambahLapanganPekerjaanAdm);
        tmbhPkrj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tmbhPkrj = new Intent(HomeAdminActivity.this, TambahPekerjaanAdminActivity.class);
                startActivity(tmbhPkrj);
            }
        });

        //Lihat Laporan
        lihatLaporan = findViewById(R.id.lihatLaporan);
        lihatLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lihatLaporan = new Intent(HomeAdminActivity.this, LihatLaporanActivity.class);
                startActivity(lihatLaporan);
            }
        });
    }
}

