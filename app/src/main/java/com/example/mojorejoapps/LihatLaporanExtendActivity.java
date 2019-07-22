package com.example.mojorejoapps;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class LihatLaporanExtendActivity extends AppCompatActivity {
    Toolbar toolbarLaporanExt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_laporan_extend);
        toolbarLaporanExt = findViewById(R.id.toolbarLaporanExt);
        setSupportActionBar(toolbarLaporanExt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Laporan");
        getIncomingIntentLaporan();
    }

    private void getIncomingIntentLaporan() {
        if (getIntent().hasExtra("pengirimLaporan") && getIntent().hasExtra("judulLaporan") && getIntent().hasExtra("isiLaporan")) {
            String pengirim = getIntent().getStringExtra("pengirimLaporan");
            String judulLaporan = getIntent().getStringExtra("judulLaporan");
            String isiLaporan = getIntent().getStringExtra("isiLaporan");
            setContentLaporan(pengirim, judulLaporan, isiLaporan);
        }
    }

    private void setContentLaporan(String pgrm, String jdl, String isi) {
        TextView pengirimLaporan = findViewById(R.id.namaPengirimExt);
        pengirimLaporan.setText(pgrm);

        TextView judulLaporan = findViewById(R.id.judulLaporanExt);
        judulLaporan.setText(jdl);

        TextView isiLaporan = findViewById(R.id.isiLaporanExt);
        isiLaporan.setText(isi);
    }
}

