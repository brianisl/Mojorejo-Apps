package com.example.mojorejoapps;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class ActivityBeritaWargaExtend extends AppCompatActivity {
    Toolbar toolbarBrtWrgExt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_warga_extend);
        toolbarBrtWrgExt = findViewById(R.id.toolbarBrtWrgExt);
        setSupportActionBar(toolbarBrtWrgExt);
        getSupportActionBar().setTitle("Berita");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getIncomingIntentWrg();
    }

    private void getIncomingIntentWrg() {
        if (getIntent().hasExtra("linkGambar") && getIntent().hasExtra("judulBerita") && getIntent().hasExtra("isiBerita")) {
            String imageUrlsWrg = getIntent().getStringExtra("linkGambar");
            String judulWrg = getIntent().getStringExtra("judulBerita");
            String isiBrtWrg = getIntent().getStringExtra("isiBerita");
            setImageWrg(imageUrlsWrg, judulWrg, isiBrtWrg);
        }

    }
    private void setImageWrg (String imageUrlsWrg, String judulWrg, String isiBrtWrg){
        TextView judulBrtWrgExt = findViewById(R.id.judulBrtWrgExt);
        judulBrtWrgExt.setText(judulWrg);

        TextView isiBrtWrgExt = findViewById(R.id.isiBrtWrgExt);
        isiBrtWrgExt.setText(isiBrtWrg);

        ImageView imgBrtWrgExt = findViewById(R.id.imgBrtWrgExt);
        Glide.with(this)
                .asBitmap()
                .load(imageUrlsWrg)
                .into(imgBrtWrgExt);
    }
}
