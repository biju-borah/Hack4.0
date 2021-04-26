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

import java.util.HashMap;
import java.util.Map;

public class EditActivity extends AppCompatActivity {
    Button update;
    EditText doctor,bed,id;
    DatabaseReference nDatabaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        doctor = findViewById(R.id.doctor);
        bed = findViewById(R.id.bed);
        update = findViewById(R.id.update);
        id = findViewById(R.id.id);
        nDatabaseRef = FirebaseDatabase.getInstance().getReference("Hospitals");

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              updatedata();
            }
        });
    }

    private void updatedata()
    {
        Map<String,Object> updateValues = new HashMap<>();
        updateValues.put("/" + id.getText().toString() + "/" + "doctors",doctor.getText().toString());
        updateValues.put("/" + id.getText().toString() + "/" + "beds",bed.getText().toString());

        nDatabaseRef.updateChildren(updateValues);

        Toast.makeText(EditActivity.this,"Updated successfully",Toast.LENGTH_SHORT).show();
    }
}