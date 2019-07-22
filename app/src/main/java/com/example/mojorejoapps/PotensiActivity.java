package com.example.mojorejoapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class PotensiActivity extends AppCompatActivity {
    Toolbar toolbarPotensi;
    CardView SDA;
    CardView pariwisata;
    CardView Umkm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_potensi);
        toolbarPotensi = findViewById(R.id.toolbarPotensi);

        setSupportActionBar(toolbarPotensi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Potensi");
        //SDA
        SDA = findViewById(R.id.cardViewSDA);
        SDA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent potensiSDA = new Intent(PotensiActivity.this, SumberDayaAlamActivity.class);
                startActivity(potensiSDA);
            }
        });
        //Pariwisata
        pariwisata = findViewById(R.id.cardViewPariwisata);
        pariwisata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent potensiPariwisata = new Intent(PotensiActivity.this, PariwisataActivity.class);
                startActivity(potensiPariwisata);

            }
        });
        //UMKM
        Umkm = findViewById(R.id.cardViewUMKM);
        Umkm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent potensiUmkm = new Intent (PotensiActivity.this, UmkmActivity.class);
                startActivity(potensiUmkm);
            }
        });
    }
}

