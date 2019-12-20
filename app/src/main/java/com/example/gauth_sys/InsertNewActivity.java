package com.example.gauth_sys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Switch;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InsertNewActivity extends AppCompatActivity {

    EditText band_id;
    Switch isEmployee;
    EditText employee_name;
    EditText employee_id;
    EditText employee_contact;
    EditText guest_amount;
    DatabaseReference dbReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_new);

        dbReference = FirebaseDatabase.getInstance().getReference();


    }
}
