package com.harinijanani.familytree.storage;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.harinijanani.familytree.MainActivity;
import com.harinijanani.familytree.domain.FamilyTree;

import java.util.Random;

public class FirebaseDB {
    DatabaseReference rootRef;
    DatabaseReference demoRef;

    public void testSave() {
        // Database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();

        // Database reference pointing to demo node

        demoRef = rootRef.child("1234567");

        String value = "Hello!! :)";

        // Push creates a unique id in database
        demoRef.setValue(value, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError firebaseError, DatabaseReference firebase) {
                Log.i("INFO", "HI");
            }
        });

        demoRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.i("VALUE", value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.i("ERROR", "Error fetching data");
            }
        });
    }

    public void testSaveObj() {
        // Database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();

        FamilyTree fam = new FamilyTree("Harini", "Arunprakash", rootRef.push().getKey(), "blah@blah.com");
        // Database reference pointing to demo node

        demoRef = rootRef.child(fam.getId());

        String value = "HelloTestSaveObject";

        // Push creates a unique id in database
        demoRef.setValue(fam, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError firebaseError, DatabaseReference firebase) {
                Log.i("INFO", "SaveObject");
            }
        });
    }
}
