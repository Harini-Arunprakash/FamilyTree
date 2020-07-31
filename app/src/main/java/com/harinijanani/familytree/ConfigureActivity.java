package com.harinijanani.familytree;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


public class ConfigureActivity extends AppCompatActivity {

    CheckBox nameCheckBox;
    CheckBox bioCheckBox;
    CheckBox picCheckBox;
    CheckBox contactCheckBox;
    CheckBox birthdayCheckBox;
    boolean name = false;
    boolean bio = false;
    boolean pic = false;
    boolean contact = false;
    boolean birthday = false;
    Button configureSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);

        nameCheckBox = findViewById(R.id.nameCheckBox);
        bioCheckBox = findViewById(R.id.bioCheckBox);
        picCheckBox = findViewById(R.id.picCheckBox);
        contactCheckBox = findViewById(R.id.contactCheckBox);
        birthdayCheckBox = findViewById(R.id.birthdayCheckBox);
        configureSave = (Button) findViewById(R.id.saveButton);

        if(nameCheckBox.isChecked()){
            name = true;
        }

        if(bioCheckBox.isChecked()){
            bio = true;
        }

        if(picCheckBox.isChecked()){
            pic = true;
        }

        if(contactCheckBox.isChecked()){
            contact = true;
        }

        if(birthdayCheckBox.isChecked()){
            birthday = true;
        }

    }

    public void configureSaveClicked(View v) {
        Intent configureSaveClicked = new Intent(ConfigureActivity.this, AddPerson.class);
        startActivity(configureSaveClicked);
    }
}
