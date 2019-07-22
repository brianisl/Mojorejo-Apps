package com.example.mojorejoapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button masukWarga;
    Button masukPengunjung;
    Button masukAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        masukWarga = (Button) findViewById(R.id.buttonWarga);
        masukPengunjung = (Button) findViewById(R.id.buttonPengunjung);
        masukAdmin = (Button) findViewById(R.id.buttonAdmin);

        masukWarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mskWrg = new Intent(LoginActivity.this, HomeWargaActivity.class);
                startActivity(mskWrg);
            }
        });

        masukPengunjung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mskPgn = new Intent (LoginActivity.this, HomePengunjungActivity.class);
                startActivity(mskPgn);
            }
        });

        masukAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mskAdm = new Intent (LoginActivity.this, LoginAdminActivity.class);
                startActivity(mskAdm);
            }
        });

    }
}
