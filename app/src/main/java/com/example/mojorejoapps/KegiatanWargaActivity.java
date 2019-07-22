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

public class KegiatanWargaActivity extends AppCompatActivity {
    Toolbar toolbarKgtWrg;
    //vars
    private ArrayList<GetKegiatan> arrayListKegiatanWrg;
    private KegiatanWargaAdapter recyclerAdapterKgtWrg;
    //DB
    private DatabaseReference mDatabaseKegiatanWrg;
    //Recycler
    private RecyclerView recyclerViewKgtWrg;
    private Context mContextBeritaWrg = KegiatanWargaActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kegiatan_warga);
        toolbarKgtWrg = findViewById(R.id.toolbarKgtWrg);
        setSupportActionBar(toolbarKgtWrg);
        getSupportActionBar().setTitle("Kegiatan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewKgtWrg = findViewById(R.id.recyclerKgtWrg);
        LinearLayoutManager linearLayoutKgtWrg = new LinearLayoutManager(this);

        recyclerViewKgtWrg.setLayoutManager(linearLayoutKgtWrg);
        recyclerViewKgtWrg.setHasFixedSize(true);

        mDatabaseKegiatanWrg = FirebaseDatabase.getInstance().getReference();

        arrayListKegiatanWrg = new ArrayList<>();

        initKegiatanWrg();
    }
    private void initKegiatanWrg(){
        clearAll();
        Query queryKgtWrg = mDatabaseKegiatanWrg.child("Kegiatan");
        queryKgtWrg.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    GetKegiatan getKegiatanWrg = new GetKegiatan();
                    getKegiatanWrg.setJudulKegiatan(snapshot.child("judulKegiatan").getValue().toString());
                    getKegiatanWrg.setIsiKegiatan(snapshot.child("isiKegiatan").getValue().toString());
                    getKegiatanWrg.setTanggalKegiatan(snapshot.child("tanggalKegiatan").getValue().toString());
                    getKegiatanWrg.setLokasiKegiatan(snapshot.child("lokasiKegiatan").getValue().toString());
                    getKegiatanWrg.setLinkGambar(snapshot.child("linkGambar").getValue().toString());
                    arrayListKegiatanWrg.add(getKegiatanWrg);
                }
                recyclerAdapterKgtWrg = new KegiatanWargaAdapter(mContextBeritaWrg, arrayListKegiatanWrg);
                recyclerViewKgtWrg.setAdapter(recyclerAdapterKgtWrg);
                recyclerAdapterKgtWrg.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void clearAll(){
        if (arrayListKegiatanWrg!=null){
            arrayListKegiatanWrg.clear();
            if (recyclerAdapterKgtWrg!=null){
                recyclerAdapterKgtWrg.notifyDataSetChanged();
            }
        }
        arrayListKegiatanWrg = new ArrayList<>();
    }
}

