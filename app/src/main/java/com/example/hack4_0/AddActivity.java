package com.example.hack4_0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class AddActivity extends AppCompatActivity {

    Button submit;
    EditText name,latitude,longitude,address,phone;

    DatabaseReference mDatabaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        submit = findViewById(R.id.submit);
        name = findViewById(R.id.name);
        latitude = findViewById(R.id.latitude);
        longitude = findViewById(R.id.longitude);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.Phone);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Hospitals");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddActivity.this, "Please wait...", Toast.LENGTH_SHORT).show();
                uploadfile();

            }
        });

    }
    private  void  uploadfile()
    {
        add upload = new add();
        upload.setAddress(address.getText().toString());
        upload.setLatitude(latitude.getText().toString());
        upload.setLongitude(longitude.getText().toString());
        upload.setName(name.getText().toString());
        upload.setPhone(phone.getText().toString());
        upload.setBeds("0");
        upload.setTest_kits("No");

        String id = latitude.getText().toString() + "-" + longitude.getText().toString();

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Toast.makeText(AddActivity.this, "Registered successful", Toast.LENGTH_SHORT).show();
                mDatabaseRef.child(id).setValue(upload);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(AddActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}