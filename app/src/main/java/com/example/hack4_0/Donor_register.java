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

public class Donor_register extends AppCompatActivity {

    EditText name,type,contact,address;
    Button submit;
    DatabaseReference mDatabaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_register);

        name = findViewById(R.id.donor_name);
        type = findViewById(R.id.donor_type);
        contact = findViewById(R.id.donor_contact);
        address = findViewById(R.id.donor_address);
        submit = findViewById(R.id.donor_submit);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Plasma");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upload();
            }
        });

    }

    private void upload()
    {
        donor uploaddata = new donor();
        uploaddata.setAddress(address.getText().toString());
        uploaddata.setContact(contact.getText().toString());
        uploaddata.setName(name.getText().toString());
        uploaddata.setType(type.getText().toString());

        String id = contact.getText().toString();

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Toast.makeText(Donor_register.this, "Registered successful", Toast.LENGTH_LONG).show();
                mDatabaseRef.child(id).setValue(uploaddata);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Donor_register.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}