package com.example.hack4_0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Flag_bed extends AppCompatActivity {
    EditText name,contact,time,date;
    DatabaseReference databaseReference;
    Button flag_bed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag_bed);

        name = findViewById(R.id.editTextTextPersonName);
        contact = findViewById(R.id.editTextTextPersonName2);
        time = findViewById(R.id.editTextTextPersonName3);
        date = findViewById(R.id.editTextTextPersonName4);

        flag_bed = findViewById(R.id.button8);

        databaseReference = FirebaseDatabase.getInstance().getReference("GMCH");

        flag_bed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Flag_bed.this, "Please wait...", Toast.LENGTH_SHORT).show();
                uploadfile();
            }
        });


    }
    private  void uploadfile()
    {
        flag upload = new flag();
        upload.setName(name.getText().toString());
        upload.setContact(contact.getText().toString());
        upload.setDate(date.getText().toString());
        upload.setTime(time.getText().toString());

        String id = contact.getText().toString();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Toast.makeText(Flag_bed.this, "Thank you very much", Toast.LENGTH_SHORT).show();
                databaseReference.child(id).setValue(upload);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}