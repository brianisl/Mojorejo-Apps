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

public class TambahKegiatanAdminActivity extends AppCompatActivity {
    Toolbar tmbhKgt;
    EditText tmbhJudulKgt;
    EditText tmbhIsiKgt;
    EditText tmbhTglKgt;
    EditText tmbhLokasiKgt;
    EditText linkGambar;
    Button tambahKegiatan;
    DatabaseReference mDatabaseReferenceKegiatan;
    FirebaseDatabase mDatabaseKegiatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_kegiatan_admin);
        tmbhKgt = findViewById(R.id.toolbarTmbhKgtAdm);
        setSupportActionBar(tmbhKgt);
        getSupportActionBar().setTitle("Tambah Kegiatan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tmbhJudulKgt = findViewById(R.id.tmbhJudulKegiatan);
        tmbhIsiKgt = findViewById(R.id.tmbhIsiKegiatan);
        tmbhTglKgt = findViewById(R.id.tmbhTanggalKegiatan);
        tmbhLokasiKgt = findViewById(R.id.tmbhLokasiKegiatan);
        tambahKegiatan = findViewById(R.id.tambahKegiatan);
        linkGambar = findViewById(R.id.tmbhGambarWarga);
        mDatabaseKegiatan = FirebaseDatabase.getInstance();

        tambahKegiatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(tmbhJudulKgt.getText())) {
                    tmbhJudulKgt.setError("Masukkan Judul");
                    tmbhJudulKgt.requestFocus();
                } else if (TextUtils.isEmpty(tmbhIsiKgt.getText())) {
                    tmbhIsiKgt.setError("Masukkan Deskripsi Kegiatan");
                    tmbhIsiKgt.requestFocus();
                } else if (TextUtils.isEmpty(tmbhTglKgt.getText())) {
                    tmbhTglKgt.setError("Masukkan Tanggal Pelaksanaan");
                    tmbhTglKgt.requestFocus();

                } else if (TextUtils.isEmpty(tmbhLokasiKgt.getText())) {
                    tmbhLokasiKgt.setError("Masukkan Lokasi Kegiatan");
                    tmbhLokasiKgt.requestFocus();
                } else if (TextUtils.isEmpty(linkGambar.getText())) {
                    linkGambar.setError("Masukkan Link Gambar");
                    linkGambar.requestFocus();
                } else {
                    String childKegiatan = tmbhJudulKgt.getText().toString();
                    mDatabaseReferenceKegiatan = mDatabaseKegiatan.getReference("Kegiatan").child(childKegiatan);
                    mDatabaseReferenceKegiatan.child("judulKegiatan").setValue(tmbhJudulKgt.getText().toString());
                    mDatabaseReferenceKegiatan.child("isiKegiatan").setValue(tmbhIsiKgt.getText().toString());
                    mDatabaseReferenceKegiatan.child("tanggalKegiatan").setValue(tmbhTglKgt.getText().toString());
                    mDatabaseReferenceKegiatan.child("lokasiKegiatan").setValue(tmbhLokasiKgt.getText().toString());
                    mDatabaseReferenceKegiatan.child("linkGambar").setValue(linkGambar.getText().toString());
                    Toast.makeText(TambahKegiatanAdminActivity.this, "Tambah Kegiatan Berhasil", Toast.LENGTH_LONG).show();
                    Intent tmbhKegiatanBerhasil = new Intent(TambahKegiatanAdminActivity.this, HomeAdminActivity.class);
                    startActivity(tmbhKegiatanBerhasil);
                }

            }
        });
    }
}
