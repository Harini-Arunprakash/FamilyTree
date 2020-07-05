package com.harinijanani.familytree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.familytree.R;


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

    public void nextButtonClicked(View v) {
        Intent nextClicked = new Intent(CreateFamily.this, ConfigureActivity.class);
        startActivity(nextClicked);
    }
}
