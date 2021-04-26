package com.example.hack4_0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Plasma_list extends AppCompatActivity {

    private RecyclerView recyclerView;
    DatabaseReference databaseReference;
    private MyAdapter3 adapter;
    private ArrayList<Model_plasma> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plasma_list);

        recyclerView = findViewById(R.id.recycle_again);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        adapter = new MyAdapter3(this,list);

        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Plasma");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                    Model_plasma model = new Model_plasma();
                    model.setName(dataSnapshot.child("name").getValue().toString());
                    model.setContact(dataSnapshot.child("contact").getValue().toString());
                    model.setBlood(dataSnapshot.child("type").getValue().toString());
                    model.setAddress(dataSnapshot.child("address").getValue().toString());
                    list.add(model);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}