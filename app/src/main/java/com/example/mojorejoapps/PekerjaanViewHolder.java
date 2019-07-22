package com.example.mojorejoapps;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PekerjaanViewHolder extends RecyclerView.ViewHolder {
    TextView namaPekerjaan;
    TextView cpPekerjaan;

    public PekerjaanViewHolder(@NonNull View itemView) {
        super(itemView);

        namaPekerjaan = itemView.findViewById(R.id.namaPekerjaan);
        cpPekerjaan = itemView.findViewById(R.id.cpPekerjaan);
    }
}
