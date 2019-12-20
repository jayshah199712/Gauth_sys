package com.example.gauth_sys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ValidatenowActivity extends AppCompatActivity {

    EditText band_number;
    Button valid_btn;
    DatabaseReference rootRef,demoRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validatenow);

        band_number = (EditText)findViewById(R.id.band_id_txt);
        valid_btn = (Button)findViewById(R.id.validate_btn);
//database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();

//database reference pointing to demo node
        demoRef = rootRef.child("Employees");

            }
        });
    }

    public void validateNow(View view) {
        demoRef.child("20001").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                demoValue.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }
}
