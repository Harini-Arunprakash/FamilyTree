package com.harinijanani.familytree;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedHashSet;


public class FamilyListView extends AppCompatActivity {

    TextView one;
    TextView two;
    TextView three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.family_listview);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nameOneClicked = new Intent(FamilyListView.this, AddRelatives.class);
                startActivity(nameOneClicked);
            }
        });

        one.setText(AddPerson.firstName.getText().toString() + " " + AddPerson.lastName.getText().toString());

    }
}
