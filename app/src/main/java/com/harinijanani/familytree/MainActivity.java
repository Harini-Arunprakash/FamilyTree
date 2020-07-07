package com.harinijanani.familytree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.harinijanani.familytree.storage.FirebaseDB;


public class MainActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;

    ImageButton create_button;
    ImageButton update_button;
    ImageButton load_button;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        create_button = (ImageButton) findViewById(R.id.create_button);
        update_button = (ImageButton) findViewById(R.id.update_button);
        load_button = (ImageButton) findViewById(R.id.load_button);

        FirebaseDB db = new FirebaseDB();
        db.testSaveObj();
    }

    public void createButtonClicked(View v) {
        Intent createClicked = new Intent(MainActivity.this, CreateFamily.class);
        startActivity(createClicked);
    }

    public void updateButtonClicked(View v) {
        Intent updateClicked = new Intent(MainActivity.this, UpdateFamily.class);
        startActivity(updateClicked);
    }

    public void loadButtonClicked(View v) {
        Intent loadClicked = new Intent(MainActivity.this, LoadFamily.class);
        startActivity(loadClicked);
    }
}
