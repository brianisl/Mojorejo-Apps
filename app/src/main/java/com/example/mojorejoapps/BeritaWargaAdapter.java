package com.example.mojorejoapps;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

public class BeritaWargaAdapter extends RecyclerView.Adapter<BeritaWargaAdapter.ViewHolderWarga> {
    private static final String TAG = "BeritaWargaAdapter";

    private Context mContextBrtWrg;
    private ArrayList<GetBerita> arrayListBrtWrg;

    public BeritaWargaAdapter(Context context, ArrayList<GetBerita> arrayListBrtWrg) {
        this.mContextBrtWrg = context;
        this.arrayListBrtWrg = arrayListBrtWrg;
    }

    @NonNull
    @Override
    public ViewHolderWarga onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewBrtWrg = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_berita_warga, parent, false);

        return new ViewHolderWarga(viewBrtWrg);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderWarga holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.textViewWrg.setText(arrayListBrtWrg.get(position).getJudulBerita());

        Glide.with(mContextBrtWrg)
                .asBitmap()
                .load(arrayListBrtWrg.get(position).getLinkGambar())
                .into(holder.imgViewWrg);
        holder.parentLayoutWrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent brtWrgExt = new Intent (mContextBrtWrg, ActivityBeritaWargaExtend.class);
                brtWrgExt.putExtra("judulBerita",arrayListBrtWrg.get(position).getJudulBerita());
                brtWrgExt.putExtra("linkGambar", arrayListBrtWrg.get(position).getLinkGambar());
                brtWrgExt.putExtra("isiBerita", arrayListBrtWrg.get(position).getIsiBerita());
                mContextBrtWrg.startActivity(brtWrgExt);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayListBrtWrg.size();
    }


    public class ViewHolderWarga extends RecyclerView.ViewHolder {
        ImageView imgViewWrg;
        TextView textViewWrg;
        RelativeLayout parentLayoutWrg;

        public ViewHolderWarga(@NonNull View itemView) {
            super(itemView);
            imgViewWrg = itemView.findViewById(R.id.imgBrtWrg);
            textViewWrg = itemView.findViewById(R.id.judulBrtWrg);
            parentLayoutWrg = itemView.findViewById(R.id.parent_layout_warga);
        }
    }
}
