package com.example.mojorejoapps;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class ActivityBeritaPengunjungExtend extends AppCompatActivity {
    Toolbar brtPgnExt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_pengunjung_extend);
        brtPgnExt = (Toolbar) findViewById(R.id.toolbarBrtPgnExt);
        setSupportActionBar(brtPgnExt);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Berita");
        getIncomingIntentPgn();
    }

    private void getIncomingIntentPgn() {
        if (getIntent().hasExtra("linkGambar") && getIntent().hasExtra("judulBerita") && getIntent().hasExtra("isiBerita")) {
            String imageUrlsPgn = getIntent().getStringExtra("linkGambar");
            String isiBrtPgn = getIntent().getStringExtra("isiBerita");
            String judulPgn = getIntent().getStringExtra("Judul");
            setImagePgn(imageUrlsPgn, judulPgn, isiBrtPgn);
        }
    }

    private void setImagePgn(String imageUrlsPgn, String judulPgn, String isiBrtPgn) {
        TextView judulBrtPgnExt = findViewById(R.id.judulBrtPgnExt);
        judulBrtPgnExt.setText(judulPgn);

        TextView isiBrtPgnExt = findViewById(R.id.isiBrtPgnExt);
        isiBrtPgnExt.setText(isiBrtPgn);

        ImageView imgBrtPgnExt = findViewById(R.id.imgBrtPgnExt);
        Glide.with(this)
                .asBitmap()
                .load(imageUrlsPgn)
                .into(imgBrtPgnExt);
    }
}

