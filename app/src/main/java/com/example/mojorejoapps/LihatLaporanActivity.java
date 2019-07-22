package com.example.mojorejoapps;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LihatLaporanActivity extends AppCompatActivity {
    Toolbar lihatLaporan;
    //vars
    private ArrayList<GetLaporan> arrayListLaporan;
    private LihatLaporanAdapter recyclerAdapterLaporan;
    //DB
    private DatabaseReference mDatabaseLihatLaporan;
    //Recycler
    private RecyclerView recyclerViewLihatLaporan;
    private Context mContextBeritaPgn = LihatLaporanActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_laporan);
        lihatLaporan = findViewById(R.id.toolbarLihatLaporan);
        setSupportActionBar(lihatLaporan);
        getSupportActionBar().setTitle("Lihat Laporan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewLihatLaporan = findViewById(R.id.recyclerLihatLaporan);
        LinearLayoutManager layoutManagerLaporan = new LinearLayoutManager(this);

        recyclerViewLihatLaporan.setLayoutManager(layoutManagerLaporan);
        recyclerViewLihatLaporan.setHasFixedSize(true);

        mDatabaseLihatLaporan = FirebaseDatabase.getInstance().getReference();

        arrayListLaporan = new ArrayList<>();

        initLaporan();
    }
    private void initLaporan(){
        clearAll();

        Query queryLaporan = mDatabaseLihatLaporan.child("Laporan");
        queryLaporan.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    GetLaporan laporan = new GetLaporan();
                    laporan.setPengirimLaporan(snapshot.child("pengirimLaporan").getValue().toString());
                    laporan.setJudulLaporan(snapshot.child("judulLaporan").getValue().toString());
                    laporan.setIsiLaporan(snapshot.child("isiLaporan").getValue().toString());
                    arrayListLaporan.add(laporan);
                }
                recyclerAdapterLaporan = new LihatLaporanAdapter(mContextBeritaPgn, arrayListLaporan);
                recyclerViewLihatLaporan.setAdapter(recyclerAdapterLaporan);
                recyclerAdapterLaporan.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void clearAll() {
        if (arrayListLaporan != null) {
            arrayListLaporan.clear();
            if (recyclerAdapterLaporan!=null){
                recyclerAdapterLaporan.notifyDataSetChanged();
            }
        }
        arrayListLaporan= new ArrayList<>();
    }
}
