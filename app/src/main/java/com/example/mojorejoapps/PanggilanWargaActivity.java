package com.example.mojorejoapps;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

public class PanggilanWargaActivity extends AppCompatActivity {
    Button btnPglWrgWA;
    Button btnPglWrgTlp;
    ImageView btnLaporan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panggilan_warga);
        Toolbar toolbarWrg = (Toolbar) findViewById(R.id.toolbarPanggilanWarga);

        setSupportActionBar(toolbarWrg);
        getSupportActionBar().setTitle("Kontak");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnPglWrgWA = findViewById(R.id.panggilWrgWA);
        btnPglWrgWA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPhoneNumberWrgWA();
            }
        });
        btnPglWrgTlp = findViewById(R.id.panggilWrgTelpon);
        btnPglWrgTlp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPhoneNumberWrgTlp();
            }
        });
        btnLaporan = findViewById(R.id.buatLaporan);
        btnLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent laporan = new Intent (PanggilanWargaActivity.this, LaporanActivity.class);
                startActivity(laporan);
            }
        });

    }

    public void callPhoneNumberWrgWA() {
        try {
            if (Build.VERSION.SDK_INT > 22) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PanggilanWargaActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
                    return;
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:082233812891"));
                startActivity(callIntent);

            } else {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:082233812891"));
                startActivity(callIntent);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void callPhoneNumberWrgTlp() {
        try {
            if (Build.VERSION.SDK_INT > 22) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(PanggilanWargaActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
                    return;
                }

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:02180871824"));
                startActivity(callIntent);

            } else {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:02180871824"));
                startActivity(callIntent);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

