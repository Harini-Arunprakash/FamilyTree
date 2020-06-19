package com.example.familytree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import java.time.chrono.MinguoChronology;

public class CreateFamily extends AppCompatActivity {
    EditText familyName;
    Spinner cloudStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_screen);
        familyName = (EditText) findViewById(R.id.familyName);
        cloudStorage = (Spinner) findViewById(R.id.cloudStorage);

    }

    public void homeButtonClicked(View v) {
        Intent homeClicked = new Intent(CreateFamily.this, MainActivity.class);
        startActivity(homeClicked);
    }

    public void backButtonClicked(View v) {
        Intent backClicked = new Intent(CreateFamily.this, MainActivity.class);
        startActivity(backClicked);
    }
}
