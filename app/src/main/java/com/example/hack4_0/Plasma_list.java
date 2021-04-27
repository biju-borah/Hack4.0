package com.example.hack4_0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

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
    private Spinner spinner;
    ArrayAdapter<CharSequence> adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plasma_list);

        spinner = findViewById(R.id.spine);
        adapt = ArrayAdapter.createFromResource(this,R.array.blood_group, R.layout.support_simple_spinner_dropdown_item);
        adapt.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapt);

        recyclerView = findViewById(R.id.recycle_again);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        adapter = new MyAdapter3(this,list);

        recyclerView.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("Plasma");

        /*databaseReference.addValueEventListener(new ValueEventListener() {
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
        });*/

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                list.clear();
                System.out.println(parent.getItemAtPosition(position));
                if(parent.getItemAtPosition(position).toString().compareTo("A+ve") == 0){
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                                System.out.println("yo");

                                if(dataSnapshot.child("type").getValue().toString().compareTo("A+") == 0)
                                {
                                    Model_plasma model = new Model_plasma();
                                    model.setName(dataSnapshot.child("name").getValue().toString());
                                    model.setContact(dataSnapshot.child("contact").getValue().toString());
                                    model.setBlood(dataSnapshot.child("type").getValue().toString());
                                    model.setAddress(dataSnapshot.child("address").getValue().toString());
                                    list.add(model);
                                }

                            }
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else if (parent.getItemAtPosition(position).toString().compareTo("A-ve") == 0)
                {
                    list.clear();
                    databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                            if(dataSnapshot.child("type").getValue().toString().compareTo("A-") == 0)
                            {
                                Model_plasma model = new Model_plasma();
                                model.setName(dataSnapshot.child("name").getValue().toString());
                                model.setContact(dataSnapshot.child("contact").getValue().toString());
                                model.setBlood(dataSnapshot.child("type").getValue().toString());
                                model.setAddress(dataSnapshot.child("address").getValue().toString());
                                list.add(model);
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                }
                else if(parent.getItemAtPosition(position).toString().compareTo("O-ve") == 0)
                {
                    list.clear();
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                                if(dataSnapshot.child("type").getValue().toString().compareTo("O-") == 0)
                                {
                                    Model_plasma model = new Model_plasma();
                                    model.setName(dataSnapshot.child("name").getValue().toString());
                                    model.setContact(dataSnapshot.child("contact").getValue().toString());
                                    model.setBlood(dataSnapshot.child("type").getValue().toString());
                                    model.setAddress(dataSnapshot.child("address").getValue().toString());
                                    list.add(model);
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else if (parent.getItemAtPosition(position).toString().compareTo("O+ve") == 0)
                {
                    list.clear();
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                                if(dataSnapshot.child("type").getValue().toString().compareTo("O+") == 0)
                                {
                                    Model_plasma model = new Model_plasma();
                                    model.setName(dataSnapshot.child("name").getValue().toString());
                                    model.setContact(dataSnapshot.child("contact").getValue().toString());
                                    model.setBlood(dataSnapshot.child("type").getValue().toString());
                                    model.setAddress(dataSnapshot.child("address").getValue().toString());
                                    list.add(model);
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).toString().compareTo("B-ve") == 0)
                {
                    list.clear();
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                                if(dataSnapshot.child("type").getValue().toString().compareTo("B-") == 0)
                                {
                                    Model_plasma model = new Model_plasma();
                                    model.setName(dataSnapshot.child("name").getValue().toString());
                                    model.setContact(dataSnapshot.child("contact").getValue().toString());
                                    model.setBlood(dataSnapshot.child("type").getValue().toString());
                                    model.setAddress(dataSnapshot.child("address").getValue().toString());
                                    list.add(model);
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
                else if (parent.getItemAtPosition(position).toString().compareTo("B+ve") == 0)
                {
                    list.clear();
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for(DataSnapshot dataSnapshot: snapshot.getChildren()){

                                if(dataSnapshot.child("type").getValue().toString().compareTo("B+") == 0)
                                {
                                    Model_plasma model = new Model_plasma();
                                    model.setName(dataSnapshot.child("name").getValue().toString());
                                    model.setContact(dataSnapshot.child("contact").getValue().toString());
                                    model.setBlood(dataSnapshot.child("type").getValue().toString());
                                    model.setAddress(dataSnapshot.child("address").getValue().toString());
                                    list.add(model);
                                }
                            }
                            adapter.notifyDataSetChanged();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}