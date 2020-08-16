package com.harinijanani.familytree;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AddRelatives extends AppCompatActivity {

    TextView name;
    TextView gender;
    String personGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_relatives);


        name = findViewById(R.id.name);
        gender = findViewById(R.id.gender);

        name.setText("Name: " + AddPerson.firstName.getText().toString() + " " + AddPerson.lastName.getText().toString());
        gender.setText("Gender: "  + AddPerson.userGender);

    }
}
