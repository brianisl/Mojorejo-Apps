package com.example.mojorejoapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LapanganPekerjaanAdapter extends RecyclerView.Adapter<LapanganPekerjaanAdapter.ViewHolderPekerjaan> {
    private ArrayList<String> mNamaPekerjaan = new ArrayList<>();
    private ArrayList<String> mCpPekerjaan = new ArrayList<>();
    private Context mContextPekerjaan;


    public LapanganPekerjaanAdapter(ArrayList<String> mNamaPekerjaan, ArrayList<String> mCpPekerjaan, Context mContextPekerjaan) {
        this.mNamaPekerjaan = mNamaPekerjaan;
        this.mCpPekerjaan = mCpPekerjaan;
        this.mContextPekerjaan = mContextPekerjaan;
    }

    @NonNull
    @Override
    public ViewHolderPekerjaan onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View viewPekerjaan = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pekerjaan, viewGroup, false);
        ViewHolderPekerjaan holderPekerjaan = new ViewHolderPekerjaan(viewPekerjaan);
        return holderPekerjaan;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPekerjaan viewHolderPekerjaan, int i) {
        viewHolderPekerjaan.namaPekerjaan.setText(mNamaPekerjaan.get(i));
        viewHolderPekerjaan.cpPekerjaan.setText(mCpPekerjaan.get(i));
    }

    @Override
    public int getItemCount() {
        return mCpPekerjaan.size();
    }

    public static class ViewHolderPekerjaan extends RecyclerView.ViewHolder {

        TextView namaPekerjaan;
        TextView cpPekerjaan;

        public ViewHolderPekerjaan(@NonNull View itemView) {
            super(itemView);
            namaPekerjaan = itemView.findViewById(R.id.namaPekerjaan);
            cpPekerjaan = itemView.findViewById(R.id.cpPekerjaan);
        }
    }


}

