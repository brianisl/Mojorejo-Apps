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

public class BeritaPengunjungActivity extends AppCompatActivity {
    Toolbar toolbarBrtPgn;
    //vars
    private ArrayList<GetBerita> arrayListBeritaPgn;
    private BeritaPengunjungAdapter recyclerAdapterBrtPgn;
    //DB
    private DatabaseReference mDatabaseBeritaPgn;
    //Recycler
    private RecyclerView recyclerViewBrtPgn;
    private Context mContextBeritaPgn = BeritaPengunjungActivity.this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita_pengunjung);

        toolbarBrtPgn = (Toolbar) findViewById(R.id.toolbarBrtPgn);
        setSupportActionBar(toolbarBrtPgn);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Berita");

        recyclerViewBrtPgn = findViewById(R.id.recyclerBrtPgn);
        LinearLayoutManager layoutManagerPgn = new LinearLayoutManager(this);

        recyclerViewBrtPgn.setLayoutManager(layoutManagerPgn);
        recyclerViewBrtPgn.setHasFixedSize(true);

        mDatabaseBeritaPgn = FirebaseDatabase.getInstance().getReference();

        arrayListBeritaPgn = new ArrayList<>();

        initBeritaPgn();
    }
    private void initBeritaPgn() {
        clearAll();

        Query queryBrtPgn = mDatabaseBeritaPgn.child("Berita");
        queryBrtPgn.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    GetBerita beritaPgn = new GetBerita();
                    beritaPgn.setLinkGambar(snapshot.child("linkGambar").getValue().toString());
                    beritaPgn.setJudulBerita(snapshot.child("judulBerita").getValue().toString());
                    beritaPgn.setIsiBerita(snapshot.child("isiBerita").getValue().toString());
                    arrayListBeritaPgn.add(beritaPgn);
                }
                recyclerAdapterBrtPgn = new BeritaPengunjungAdapter(mContextBeritaPgn, arrayListBeritaPgn);
                recyclerViewBrtPgn.setAdapter(recyclerAdapterBrtPgn);
                recyclerAdapterBrtPgn.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void clearAll() {
        if (arrayListBeritaPgn != null) {
            arrayListBeritaPgn.clear();
            if (recyclerAdapterBrtPgn!=null){
                recyclerAdapterBrtPgn.notifyDataSetChanged();
            }
        }
        arrayListBeritaPgn = new ArrayList<>();
    }

}
