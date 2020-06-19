package com.example.familytree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton create_button;
    ImageButton update_button;
    ImageButton load_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create_button = (ImageButton) findViewById(R.id.create_button);
        update_button = (ImageButton) findViewById(R.id.update_button);
        load_button = (ImageButton) findViewById(R.id.load_button);

    }

    public void createButtonClicked(View v) {
        Intent createClicked = new Intent(MainActivity.this, CreateFamily.class);
        startActivity(createClicked);
    }

//    public void updateButtonClicked(View v) {
//
//    }
//
//    public void loadButtonClicked(View v) {
//
//    }
}
