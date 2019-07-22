package com.example.mojorejoapps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class LapanganPekerjaanActivity extends AppCompatActivity {
    private ArrayList<GetPekerjaan> arrayListPekerjaan;
    Toolbar toolbarPekerjaan;
    private DatabaseReference mDatabasePekerjaan;
    private FirebaseRecyclerOptions<GetPekerjaan> optionsPekerjaan;
    private FirebaseRecyclerAdapter<GetPekerjaan, PekerjaanViewHolder> fbAdapterPekerjaan;
    private RecyclerView recyclerViewPkrj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lapangan_pekerjaan);
        toolbarPekerjaan = findViewById(R.id.toolbarPekerjaan);
        setSupportActionBar(toolbarPekerjaan);
        getSupportActionBar().setTitle("Lowongan Pekerjaan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewPkrj = findViewById(R.id.recyclerPekerjaan);
        recyclerViewPkrj.setHasFixedSize(true);
        recyclerViewPkrj.setLayoutManager(new LinearLayoutManager(this));
        arrayListPekerjaan = new ArrayList<GetPekerjaan>();
        mDatabasePekerjaan = FirebaseDatabase.getInstance().getReference().child("Pekerjaan");
        mDatabasePekerjaan.keepSynced(true);
        optionsPekerjaan = new FirebaseRecyclerOptions.Builder<GetPekerjaan>().setQuery(mDatabasePekerjaan, GetPekerjaan.class).build();
        fbAdapterPekerjaan = new FirebaseRecyclerAdapter<GetPekerjaan, PekerjaanViewHolder>(optionsPekerjaan) {

            @NonNull
            @Override
            public PekerjaanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new PekerjaanViewHolder(LayoutInflater.from(LapanganPekerjaanActivity.this).inflate(R.layout.item_pekerjaan, parent, false));
            }

            @Override
            protected void onBindViewHolder(@NonNull PekerjaanViewHolder pekerjaanViewHolder, int i, @NonNull GetPekerjaan getPekerjaan) {
                pekerjaanViewHolder.cpPekerjaan.setText(getPekerjaan.getCpPekerjaan());
                pekerjaanViewHolder.namaPekerjaan.setText(getPekerjaan.getJudulPekerjaan());
            }
        };

        recyclerViewPkrj.setAdapter(fbAdapterPekerjaan);

    }

    public void onStart() {
        super.onStart();
        fbAdapterPekerjaan.startListening();
    }

    public void onStop() {
        super.onStop();
        fbAdapterPekerjaan.stopListening();
    }


}

