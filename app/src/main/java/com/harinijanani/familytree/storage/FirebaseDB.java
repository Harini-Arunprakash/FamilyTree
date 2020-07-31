package com.harinijanani.familytree.storage;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.common.images.WebImage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.harinijanani.familytree.domain.FamilyTree;
import com.harinijanani.familytree.domain.Human;

public class FirebaseDB {
    DatabaseReference rootRef;
    DatabaseReference demoRef;
    DatabaseReference otherRootRef;
    DatabaseReference otherDemoRef;

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

    public void testSaveHumanObj() {
        // Database reference pointing to root of database
        otherRootRef = FirebaseDatabase.getInstance().getReference();

        otherDemoRef = otherRootRef.child(otherRootRef.push().getKey());
        Human dad = new Human("Arunprakash", "Dhanabal", true);

        otherDemoRef.setValue(dad, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError firebaseError, DatabaseReference firebase) {
                Log.i("INFO", "SaveObject2");
            }
        });
    }

    public void testSaveHumanObjJson() {
        // Database reference pointing to root of database
        otherRootRef = FirebaseDatabase.getInstance().getReference();

        otherDemoRef = otherRootRef.child(otherRootRef.push().getKey());
        Human dad = new Human("Arunprakash", "Dhanabal", true);


        Gson gson = new Gson();
        String jsonDad = gson.toJson(dad);
        Log.i("INFO", jsonDad);

        otherDemoRef.setValue(jsonDad, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError firebaseError, DatabaseReference firebase) {
                Log.i("INFO", "SaveObject2");
            }
        });
    }

    public void testSaveHumanObjJsonComplex(String first, String last, boolean gender) {
        // Database reference pointing to root of database
        otherRootRef = FirebaseDatabase.getInstance().getReference();

        otherDemoRef = otherRootRef.child(otherRootRef.push().getKey());

        Human dad = new Human(first, last, gender);
//        Human mom = new Human("Kiruthika", "Arunprakash", false);
//        Human janani = new Human("Janani", "Arunprakash", false);
//        Human me = new Human("Harini", "Arunprakash", false);
//        Human father = new Human("Dhanabal", "Ayyemperumal", true);
//        Human mother = new Human("Meena", "Dhanabal", false);

//        dad.setMarriagePartner(mom);
//        dad.addChildren(me, janani);
//        dad.setFather(father);
//        dad.setMother(mother);

        Gson gson = new Gson();
        String jsonDad = gson.toJson(dad);

        otherDemoRef.setValue(jsonDad, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError firebaseError, DatabaseReference firebase) {
                Log.i("INFO", "SaveObject2");
            }
        });


    }
}
