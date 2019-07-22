package com.example.mojorejoapps;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

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

public class BeritaWargaActivity extends AppCompatActivity {
    Toolbar toolbarBrtWrg;
    private static final String TAG = "BeritaWargaActivity";
    //vars
    private ArrayList<GetBerita> arrayListBeritaWrg;
    private BeritaWargaAdapter recyclerAdapterBrtWrg;
    //DB
    private DatabaseReference mDatabaseBeritaWrg;
    //Recycler
    private RecyclerView recyclerViewBrtWrg;
    private Context mContextBeritaWrg = BeritaWargaActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_warga);
        toolbarBrtWrg = (Toolbar) findViewById(R.id.toolbarBrtWrg);
        setSupportActionBar(toolbarBrtWrg);
        getSupportActionBar().setTitle("Berita");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Log.d(TAG, "onCreate: started");

        recyclerViewBrtWrg = findViewById(R.id.recyclerBrtWrg);
        LinearLayoutManager layoutManagerWrg = new LinearLayoutManager(this);

        recyclerViewBrtWrg.setLayoutManager(layoutManagerWrg);
        recyclerViewBrtWrg.setHasFixedSize(true);


        mDatabaseBeritaWrg = FirebaseDatabase.getInstance().getReference();

        arrayListBeritaWrg = new ArrayList<>();
        initBeritaWrg();
    }

    private void initBeritaWrg() {
        clearAll();

        Query queryBrtWrg = mDatabaseBeritaWrg.child("Berita");
        queryBrtWrg.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    GetBerita beritaWrg = new GetBerita();
                    beritaWrg.setLinkGambar(snapshot.child("linkGambar").getValue().toString());
                    beritaWrg.setJudulBerita(snapshot.child("judulBerita").getValue().toString());
                    beritaWrg.setIsiBerita(snapshot.child("isiBerita").getValue().toString());
                    arrayListBeritaWrg.add(beritaWrg);
                }
                recyclerAdapterBrtWrg = new BeritaWargaAdapter(mContextBeritaWrg, arrayListBeritaWrg);
                recyclerViewBrtWrg.setAdapter(recyclerAdapterBrtWrg);
                recyclerAdapterBrtWrg.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void clearAll() {
        if (arrayListBeritaWrg != null) {
            arrayListBeritaWrg.clear();
            if (recyclerAdapterBrtWrg!=null){
                recyclerAdapterBrtWrg.notifyDataSetChanged();
            }
        }
        arrayListBeritaWrg = new ArrayList<>();
    }

}