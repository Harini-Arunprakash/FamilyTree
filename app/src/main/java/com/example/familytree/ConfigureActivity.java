package com.example.familytree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configure);

        nameCheckBox = findViewById(R.id.nameCheckBox);
        bioCheckBox = findViewById(R.id.bioCheckBox);
        picCheckBox = findViewById(R.id.picCheckBox);
        contactCheckBox = findViewById(R.id.contactCheckBox);
        birthdayCheckBox = findViewById(R.id.birthdayCheckBox);

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
}
