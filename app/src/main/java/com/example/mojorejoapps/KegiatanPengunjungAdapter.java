package com.example.mojorejoapps;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class KegiatanPengunjungAdapter extends RecyclerView.Adapter<KegiatanPengunjungAdapter.KegiatanPengunjungViewHolder> {
    private ArrayList<GetKegiatan> arrayListKegiatanPgn;
    private Context mContextKegiatanPgn;

    public KegiatanPengunjungAdapter(Context mContextKegiatanPgn, ArrayList<GetKegiatan> arrayListKegiatanPgn) {
        this.mContextKegiatanPgn = mContextKegiatanPgn;
        this.arrayListKegiatanPgn = arrayListKegiatanPgn;
    }


    @NonNull
    @Override
    public KegiatanPengunjungViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewKgtPgn = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kegiatan_pengunjung, parent, false);

        return new KegiatanPengunjungViewHolder(viewKgtPgn);
    }

    @Override
    public void onBindViewHolder(@NonNull final KegiatanPengunjungViewHolder holder, final int position) {
        holder.judulKgtPgn.setText(arrayListKegiatanPgn.get(position).getJudulKegiatan());
        Glide.with(mContextKegiatanPgn)
                .asBitmap()
                .load(arrayListKegiatanPgn.get(position).getLinkGambar())
                .into(holder.imgKgtPgn);
        holder.parentLayoutKgtPgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kgtPgnExt = new Intent(mContextKegiatanPgn, KegiatanPengunjungExtendActivity.class);
                kgtPgnExt.putExtra("judulKegiatan", arrayListKegiatanPgn.get(position).getJudulKegiatan());
                kgtPgnExt.putExtra("isiKegiatan", arrayListKegiatanPgn.get(position).getIsiKegiatan());
                kgtPgnExt.putExtra("tanggalKegiatan", arrayListKegiatanPgn.get(position).getTanggalKegiatan());
                kgtPgnExt.putExtra("lokasiKegiatan", arrayListKegiatanPgn.get(position).getLokasiKegiatan());
                kgtPgnExt.putExtra("gambarKegiatan", arrayListKegiatanPgn.get(position).getLinkGambar());
                mContextKegiatanPgn.startActivity(kgtPgnExt);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListKegiatanPgn.size();
    }

    public class KegiatanPengunjungViewHolder extends RecyclerView.ViewHolder {

        ImageView imgKgtPgn;
        TextView judulKgtPgn;
        RelativeLayout parentLayoutKgtPgn;

        public KegiatanPengunjungViewHolder(@NonNull View itemView) {
            super(itemView);
            imgKgtPgn = itemView.findViewById(R.id.imgKgtPgn);
            judulKgtPgn = itemView.findViewById(R.id.judulKgtPgn);
            parentLayoutKgtPgn = itemView.findViewById(R.id.parent_layout_kgtpgn);
        }
    }
}

