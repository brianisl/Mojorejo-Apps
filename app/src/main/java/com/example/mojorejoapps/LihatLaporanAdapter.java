package com.example.mojorejoapps;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LihatLaporanAdapter extends RecyclerView.Adapter<LihatLaporanAdapter.ViewHolderLaporan> {
    private Context mContextLaporan;
    private ArrayList<GetLaporan> arrayListLaporan;

    public LihatLaporanAdapter(Context mContextLaporan, ArrayList<GetLaporan> arrayListLaporan) {
        this.mContextLaporan = mContextLaporan;
        this.arrayListLaporan = arrayListLaporan;
    }

    @NonNull
    @Override
    public ViewHolderLaporan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLaporan = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lihat_laporan, parent, false);

        return new ViewHolderLaporan(viewLaporan);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLaporan holder, final int position) {
        holder.judulLaporan.setText(arrayListLaporan.get(position).getJudulLaporan());
        holder.pengirimLaporan.setText(arrayListLaporan.get(position).getPengirimLaporan());
        holder.parentLayoutLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lihatLaporan = new Intent(mContextLaporan, LihatLaporanExtendActivity.class);
                lihatLaporan.putExtra("pengirimLaporan", arrayListLaporan.get(position).getPengirimLaporan());
                lihatLaporan.putExtra("judulLaporan", arrayListLaporan.get(position).getJudulLaporan());
                lihatLaporan.putExtra("isiLaporan", arrayListLaporan.get(position).getIsiLaporan());
                mContextLaporan.startActivity(lihatLaporan);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListLaporan.size();
    }

    public class ViewHolderLaporan extends RecyclerView.ViewHolder {
        TextView judulLaporan;
        TextView pengirimLaporan;
        RelativeLayout parentLayoutLaporan;

        public ViewHolderLaporan(@NonNull View itemView) {
            super(itemView);

            judulLaporan = itemView.findViewById(R.id.judulLaporan);
            pengirimLaporan = itemView.findViewById(R.id.namaPengirim);
            parentLayoutLaporan = itemView.findViewById(R.id.parent_layout_laporan);
        }
    }
}

