package com.example.mojorejoapps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LaporanActivity extends AppCompatActivity {
    Toolbar laporan;
    EditText tmbhPengirim;
    EditText tmbhLaporan;
    Button tambahLaporan;
    EditText tmbhJudul;
    FirebaseDatabase databaseLaporan;
    DatabaseReference myRefLaporan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);
        laporan = findViewById(R.id.buatLaporan);
        setSupportActionBar(laporan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ajang Wadul");

        tmbhPengirim = findViewById(R.id.tmbhPengirim);
        tmbhLaporan = findViewById(R.id.tmbhLaporan);
        tambahLaporan = findViewById(R.id.tambahLaporan);
        tmbhJudul = findViewById(R.id.tmbhJudulLaporan);

        databaseLaporan = FirebaseDatabase.getInstance();

        tambahLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(tmbhPengirim.getText())) {
                    tmbhPengirim.setError("Masukkan Nama Pengirim");
                    tmbhPengirim.requestFocus();
                } else if (TextUtils.isEmpty(tmbhJudul.getText())) {
                    tmbhJudul.setError("Masukkan Judul Laporan");
                    tmbhJudul.requestFocus();
                } else if (TextUtils.isEmpty(tmbhLaporan.getText())) {
                    tmbhLaporan.setError("Masukkan Laporan");
                    tmbhLaporan.requestFocus();
                } else {
                    String childLaporan = tmbhJudul.getText().toString();
                    myRefLaporan = databaseLaporan.getReference("Laporan").child(childLaporan);
                    myRefLaporan.child("pengirimLaporan").setValue(tmbhPengirim.getText().toString());
                    myRefLaporan.child("judulLaporan").setValue(tmbhJudul.getText().toString());
                    myRefLaporan.child("isiLaporan").setValue(tmbhLaporan.getText().toString());
                    Toast.makeText(LaporanActivity.this, "Laporan Berhasil", Toast.LENGTH_SHORT).show();
                    Intent laporanBerhasil = new Intent (LaporanActivity.this, PanggilanWargaActivity.class);
                    startActivity(laporanBerhasil);
                }
            }
        });

    }
}
