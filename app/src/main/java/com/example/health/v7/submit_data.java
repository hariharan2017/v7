package com.example.health.v7;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

public class submit_data extends AppCompatActivity {

    EditText firstname,lastname,addr,cont,des;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_data);

        mRef = FirebaseDatabase.getInstance().getReference("Patient");

        Button button = findViewById(R.id.button);

        firstname = findViewById(R.id.first_name);
        lastname = findViewById(R.id.last_name);
        addr = findViewById(R.id.address);
        cont = findViewById(R.id.contact);
        des = findViewById(R.id.desc);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if(bundle.getString("some") != null){
                Toast.makeText(getApplicationContext(),"data:"+bundle.getString("some"),Toast.LENGTH_SHORT).show();
            }
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        getValues();
                        Toast.makeText(submit_data.this, "Patient Details Entered Successfully", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(submit_data.this, "Error", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }

    public void getValues() {

        String patientID = mRef.push().getKey();
        String first_name = firstname.getText().toString();
        String last_name = lastname.getText().toString();
        String address = addr.getText().toString();
        String contact = cont.getText().toString();
        String desc = des.getText().toString();

        Patient patient = new Patient(first_name,last_name,address,desc,contact);
        mRef.child(contact).setValue(patient);
    }
}
