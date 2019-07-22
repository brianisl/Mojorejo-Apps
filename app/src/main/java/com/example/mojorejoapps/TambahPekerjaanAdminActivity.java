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

public class TambahPekerjaanAdminActivity extends AppCompatActivity {
    Toolbar tmbhPkrj;
    EditText tmbhJudulPekerjaan;
    EditText tmbhCpPekerjaan;
    Button tmbhPekerjaan;
    FirebaseDatabase databasePekerjaan;
    DatabaseReference myRefPekerjaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pekerjaan_admin);
        tmbhPkrj = findViewById(R.id.toolbarTmbhPkrjAdm);
        setSupportActionBar(tmbhPkrj);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pekerjaan");
        databasePekerjaan = FirebaseDatabase.getInstance();


        tmbhJudulPekerjaan = (EditText) findViewById(R.id.tmbhJudulPekerjaan);
        tmbhCpPekerjaan = (EditText) findViewById(R.id.tmbhCpPekerjaan);
        tmbhPekerjaan = (Button) findViewById(R.id.tambahPekerjaan);
        tmbhPekerjaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(tmbhJudulPekerjaan.getText())) {
                    tmbhJudulPekerjaan.setError("Masukkan Judul");
                    tmbhJudulPekerjaan.requestFocus();
                } else if (TextUtils.isEmpty(tmbhCpPekerjaan.getText())) {
                    tmbhCpPekerjaan.setError("Masukkan CP");
                    tmbhCpPekerjaan.requestFocus();
                } else {
                    String childPekerjaan = tmbhJudulPekerjaan.getText().toString();
                    myRefPekerjaan = databasePekerjaan.getReference("Pekerjaan").child(childPekerjaan);
                    myRefPekerjaan.child("judulPekerjaan").setValue(tmbhJudulPekerjaan.getText().toString());
                    myRefPekerjaan.child("cpPekerjaan").setValue(tmbhCpPekerjaan.getText().toString());
                    Toast.makeText(TambahPekerjaanAdminActivity.this, "Pekerjaan Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                    Intent backHomeAdmPkrj = new Intent(TambahPekerjaanAdminActivity.this, HomeAdminActivity.class);
                    startActivity(backHomeAdmPkrj);
                }

            }
        });


    }
}
