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

public class KegiatanPengunjungActivity extends AppCompatActivity {
    Toolbar toolbarKgtPgn;
    //vars
    private ArrayList<GetKegiatan> arrayListKegiatanPgn;
    private KegiatanPengunjungAdapter recyclerAdapterKgtPgn;
    //DB
    private DatabaseReference mDatabaseKegiatanPgn;
    //Recycler
    private RecyclerView recyclerViewKgtPgn;
    private Context mContextBeritaPgn = KegiatanPengunjungActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kegiatan_pengunjung);
        toolbarKgtPgn = findViewById(R.id.toolbarKgtPgn);
        setSupportActionBar(toolbarKgtPgn);
        getSupportActionBar().setTitle("Kegiatan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewKgtPgn = findViewById(R.id.recyclerKgtPgn);
        LinearLayoutManager linearLayoutKgtPgn = new LinearLayoutManager(this);

        recyclerViewKgtPgn.setLayoutManager(linearLayoutKgtPgn);
        recyclerViewKgtPgn.setHasFixedSize(true);

        mDatabaseKegiatanPgn = FirebaseDatabase.getInstance().getReference();

        arrayListKegiatanPgn = new ArrayList<>();

        initKegiatanPgn();

    }
    private void initKegiatanPgn(){
        clearAll();
        Query queryKgtPgn = mDatabaseKegiatanPgn.child("Kegiatan");
        queryKgtPgn.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    GetKegiatan getKegiatanPgn = new GetKegiatan();
                    getKegiatanPgn.setJudulKegiatan(snapshot.child("judulKegiatan").getValue().toString());
                    getKegiatanPgn.setIsiKegiatan(snapshot.child("isiKegiatan").getValue().toString());
                    getKegiatanPgn.setTanggalKegiatan(snapshot.child("tanggalKegiatan").getValue().toString());
                    getKegiatanPgn.setLokasiKegiatan(snapshot.child("lokasiKegiatan").getValue().toString());
                    getKegiatanPgn.setLinkGambar(snapshot.child("linkGambar").getValue().toString());
                    arrayListKegiatanPgn.add(getKegiatanPgn);
                }
                recyclerAdapterKgtPgn = new KegiatanPengunjungAdapter(mContextBeritaPgn, arrayListKegiatanPgn);
                recyclerViewKgtPgn.setAdapter(recyclerAdapterKgtPgn);
                recyclerAdapterKgtPgn.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void clearAll(){
        if (arrayListKegiatanPgn!=null){
            arrayListKegiatanPgn.clear();
            if (recyclerAdapterKgtPgn!=null){
                recyclerAdapterKgtPgn.notifyDataSetChanged();
            }
        }
        arrayListKegiatanPgn = new ArrayList<>();
    }
}
