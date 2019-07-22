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

public class TambahBeritaAdminActivity extends AppCompatActivity {
    private Toolbar tmbhBrt;
    private EditText tmbhJudulBerita;
    private EditText tmbhIsiBerita;
    private EditText pathImgBerita;
    private Button tambahBerita;
    private DatabaseReference mDatabaseReferenceBerita;
    private FirebaseDatabase mDatabaseBerita;



    public TambahBeritaAdminActivity() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_berita_admin);
        tmbhBrt = findViewById(R.id.toolbarTmbhBrtAdm);
        setSupportActionBar(tmbhBrt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Tambah Berita");
        tmbhJudulBerita = findViewById(R.id.tmbhJudulBerita);
        tmbhIsiBerita = findViewById(R.id.tmbhIsiBerita);
        pathImgBerita = findViewById(R.id.pathImgBerita);
        tambahBerita = findViewById(R.id.tambahBerita);
        mDatabaseBerita = FirebaseDatabase.getInstance();

        tambahBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(tmbhJudulBerita.getText())) {
                    tmbhJudulBerita.setError("Masukkan Judul");
                    tmbhJudulBerita.requestFocus();
                } else if (TextUtils.isEmpty(tmbhIsiBerita.getText())) {
                    tmbhIsiBerita.setError("Masukkan Isi Berita");
                    tmbhIsiBerita.requestFocus();
                } else if (TextUtils.isEmpty(pathImgBerita.getText())) {
                    pathImgBerita.setError("Masukkan Link Gambar");
                    pathImgBerita.requestFocus();
                } else {
                    String childBerita = tmbhJudulBerita.getText().toString();
                    mDatabaseReferenceBerita = mDatabaseBerita.getReference("Berita").child(childBerita);
                    mDatabaseReferenceBerita.child("judulBerita").setValue(tmbhJudulBerita.getText().toString());
                    mDatabaseReferenceBerita.child("isiBerita").setValue(tmbhIsiBerita.getText().toString());
                    mDatabaseReferenceBerita.child("linkGambar").setValue(pathImgBerita.getText().toString());
                    Toast.makeText(TambahBeritaAdminActivity.this, "Upload Berita Berhasil", Toast.LENGTH_SHORT).show();
                    Intent tmbhBeritaBerhasil = new Intent(TambahBeritaAdminActivity.this, HomeAdminActivity.class);
                    startActivity(tmbhBeritaBerhasil);
                }


            }
        });


    }


}

