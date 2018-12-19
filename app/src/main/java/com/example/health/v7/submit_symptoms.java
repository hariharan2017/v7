package com.example.health.v7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class submit_symptoms extends AppCompatActivity {

    Button button;
    CheckBox symptom1,symptom2,symptom3,symptom4,symptom5,symptom6,symptom7,symptom8;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_symptoms);

        mRef = FirebaseDatabase.getInstance().getReference("Patient");

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        symptom1 = findViewById(R.id.sym1);
        symptom2 = findViewById(R.id.sym2);
        symptom3 = findViewById(R.id.sym3);
        symptom4 = findViewById(R.id.sym4);
        symptom5 = findViewById(R.id.sym5);
        symptom6 = findViewById(R.id.sym6);
        symptom7 = findViewById(R.id.sym7);
        symptom8 = findViewById(R.id.sym8);

        Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer result = new StringBuffer();
                result.append("Weight Loss, ").append(symptom1.isChecked());
                result.append("\nLoss of Appetite: ").append(symptom2.isChecked());
                result.append("\nNight Sweat: ").append(symptom3.isChecked());
                result.append("\nFever: ").append(symptom4.isChecked());
                result.append("\nFatigue: ").append(symptom5.isChecked());
                result.append("\nCoughing: ").append(symptom6.isChecked());
                result.append("\nHemoptysis: ").append(symptom7.isChecked());
                result.append("\nChest Pain: ").append(symptom8.isChecked());

                Toast.makeText(submit_symptoms.this, result.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
