package com.example.hack4_0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class hospitalsearch extends AppCompatActivity {

    private RecyclerView recyclerView;
    DatabaseReference databaseReference;
    private MyAdapter adapter;
    private ArrayList<Molel_hospital> list;

    //Button example;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitalsearch);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        adapter = new MyAdapter(this,list);

        recyclerView.setAdapter(adapter);

        //example = findViewById(R.id.example);
        databaseReference = FirebaseDatabase.getInstance().getReference("Hospitals");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String key = dataSnapshot.getKey();
                    String[] loc = key.split("-");
                    String lat = loc[0];
                    String lon = loc[1];

                    Molel_hospital molel_hospital = new Molel_hospital();
                    molel_hospital.setName(dataSnapshot.child("name").getValue().toString());
                    molel_hospital.setAddress(dataSnapshot.child("address").getValue().toString());
                    molel_hospital.setBed(dataSnapshot.child("beds").getValue().toString());
                    molel_hospital.setDistance("0");
                    list.add(molel_hospital);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /*example.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot child:snapshot.getChildren())
                        {
                            String key = child.getKey();
                            System.out.println(key);

                            String[] loc = key.split("-");
                            String lat = loc[0];
                            String lon = loc[1];

                            Location a = new Location("i don't know,duh!");
                            a.setLatitude(Double.parseDouble(lat));
                            a.setLongitude(Double.parseDouble(lon));
                            Location b = new Location("i don't know,duh!");
                            b.setLatitude(1643);
                            b.setLongitude(3567);

                            double result = a.distanceTo(b);
                            System.out.println(result);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });*/
    }
}