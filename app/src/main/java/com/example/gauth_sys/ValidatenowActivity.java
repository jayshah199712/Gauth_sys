package com.example.gauth_sys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.model.value.NullValue;

public class ValidatenowActivity extends AppCompatActivity {

    EditText band_number;
    Button valid_btn;
    FirebaseFirestore db;
    Employee emp1 = new Employee();
    TextView textDisplay;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validatenow);
        db = FirebaseFirestore.getInstance();
        band_number = (EditText)findViewById(R.id.band_id_txt);
        valid_btn = (Button)findViewById(R.id.validate_btn);
        textDisplay = findViewById(R.id.data_view);




        }

    public void validateNow(View view) {
        String num_check = band_number.getText().toString();
        DocumentReference user = db.collection("employees").document(num_check);
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task< DocumentSnapshot > task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot doc = task.getResult();
                    StringBuilder fields = new StringBuilder("");
                    String temp = doc.get("emp_id").toString();
                    if(temp.equals("")){
                        AlertDialog alert = builder.create();
                        builder.setMessage("User is not Valid\n Entry Denied");
                        alert.setTitle("Validation Check alert");
                    }
                    fields.append("Employee ID: ").append(doc.get("emp_id"));
                    fields.append("\nEmployee Name: ").append(doc.get("emp_name"));
                    //fields.append("\nEntry Time: ").append(doc.get("entry_check"));
                    Timestamp entry_time = (Timestamp) doc.getTimestamp("entry_check");
                    fields.append(entry_time);
                    fields.append("\n:Validation").append("Valid Entry");
                    textDisplay.setText(fields.toString());
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });



    }

}



