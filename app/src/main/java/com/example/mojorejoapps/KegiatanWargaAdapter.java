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

public class KegiatanWargaAdapter extends RecyclerView.Adapter<KegiatanWargaAdapter.KegiatanWargaViewHolder> {
    private Context mContextKegiatanWrg;
    private ArrayList<GetKegiatan> arrayListKegiatanWrg;

    public KegiatanWargaAdapter(Context mContextKegiatanWrg, ArrayList<GetKegiatan> arrayListKegiatanWrg) {
        this.mContextKegiatanWrg = mContextKegiatanWrg;
        this.arrayListKegiatanWrg = arrayListKegiatanWrg;
    }

    @NonNull
    @Override
    public KegiatanWargaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewKgtWrg = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kegiatan_warga, parent, false);
        return new KegiatanWargaViewHolder(viewKgtWrg);
    }

    @Override
    public void onBindViewHolder(@NonNull KegiatanWargaViewHolder holder, final int position) {
        holder.judulKgtWrg.setText(arrayListKegiatanWrg.get(position).getJudulKegiatan());
        Glide.with(mContextKegiatanWrg)
                .asBitmap()
                .load(arrayListKegiatanWrg.get(position).getLinkGambar())
                .into(holder.imgKgtWrg);
        holder.parentLayoutKgtWrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kgtWrgExt = new Intent(mContextKegiatanWrg, KegiatanWargaExtendActivity.class);
                kgtWrgExt.putExtra("judulKegiatan", arrayListKegiatanWrg.get(position).getJudulKegiatan());
                kgtWrgExt.putExtra("isiKegiatan", arrayListKegiatanWrg.get(position).getIsiKegiatan());
                kgtWrgExt.putExtra("tanggalKegiatan", arrayListKegiatanWrg.get(position).getTanggalKegiatan());
                kgtWrgExt.putExtra("lokasiKegiatan", arrayListKegiatanWrg.get(position).getLokasiKegiatan());
                kgtWrgExt.putExtra("gambarKegiatan", arrayListKegiatanWrg.get(position).getLinkGambar());
                mContextKegiatanWrg.startActivity(kgtWrgExt);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListKegiatanWrg.size();
    }

    public class KegiatanWargaViewHolder extends RecyclerView.ViewHolder {

        ImageView imgKgtWrg;
        TextView judulKgtWrg;
        RelativeLayout parentLayoutKgtWrg;

        public KegiatanWargaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgKgtWrg = itemView.findViewById(R.id.imgKgtWrg);
            judulKgtWrg = itemView.findViewById(R.id.judulKgtWrg);
            parentLayoutKgtWrg = itemView.findViewById(R.id.parent_layout_kgtwrg);
        }
    }
}

