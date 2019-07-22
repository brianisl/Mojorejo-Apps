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

public class BeritaPengunjungAdapter extends RecyclerView.Adapter<BeritaPengunjungAdapter.ViewHolderPengunjung> {
    private Context mContextBrtPgn;
    private ArrayList<GetBerita> arrayListBrtPgn;

    public BeritaPengunjungAdapter(Context context, ArrayList<GetBerita> arrayListBrtPgn) {
        this.mContextBrtPgn= context;
        this.arrayListBrtPgn = arrayListBrtPgn;
    }


    @NonNull
    @Override
    public ViewHolderPengunjung onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewPgn = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_berita_pengunjung, parent, false);
        ViewHolderPengunjung holderPengunjung = new ViewHolderPengunjung(viewPgn);
        return holderPengunjung;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPengunjung viewHolderPengunjung, final int position) {
        viewHolderPengunjung.textViewPgn.setText(arrayListBrtPgn.get(position).getJudulBerita());
        Glide.with(mContextBrtPgn)
                .asBitmap()
                .load(arrayListBrtPgn.get(position).getLinkGambar())
                .into(viewHolderPengunjung.imgViewPgn);
        viewHolderPengunjung.parentLayoutPgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent brtPgnExt = new Intent (mContextBrtPgn, ActivityBeritaWargaExtend.class);
                brtPgnExt.putExtra("judulBerita",arrayListBrtPgn.get(position).getJudulBerita());
                brtPgnExt.putExtra("linkGambar", arrayListBrtPgn.get(position).getLinkGambar());
                brtPgnExt.putExtra("isiBerita", arrayListBrtPgn.get(position).getIsiBerita());
                mContextBrtPgn.startActivity(brtPgnExt);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayListBrtPgn.size();
    }

    public class ViewHolderPengunjung extends RecyclerView.ViewHolder {

        ImageView imgViewPgn;
        TextView textViewPgn;
        RelativeLayout parentLayoutPgn;

        public ViewHolderPengunjung(@NonNull View itemView) {
            super(itemView);
            imgViewPgn = itemView.findViewById(R.id.imgBrtPgn);
            textViewPgn = itemView.findViewById(R.id.judulBrtPgn);
            parentLayoutPgn = itemView.findViewById(R.id.parent_layout_pengunjung);
        }
    }
}
