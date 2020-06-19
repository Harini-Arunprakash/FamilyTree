package com.example.familytree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;

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
}
