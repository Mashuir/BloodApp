package com.example.user.bloodapp;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FindBloodInApp extends AppCompatActivity {

    ListView listView;
    DatabaseReference reference;
    List<DonorInformation> donorInformations;
    ImageButton phoneCallBtn;
    String[] bloodGroupName;
    Button BloodFilter;
    String bloodSelectionBtn = "";
    String[] locationFilter;
    Button LocationFilter;
    String locationSelectionBtn="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_blood_in_app);

        listView = findViewById(R.id.findBloodListView);
        donorInformations = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("DonorInformation");
        bloodGroupName = getResources().getStringArray(R.array.bloodGroupName);
        BloodFilter = findViewById(R.id.BloodFilter);
        locationFilter = getResources().getStringArray(R.array.location_names);
        LocationFilter = findViewById(R.id.LocationFilter);



    }

    @Override
    protected void onStart() {
        super.onStart();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                donorInformations.clear();
                for (DataSnapshot donor:dataSnapshot.getChildren()){
                    DonorInformation information = donor.getValue(DonorInformation.class);
                    donorInformations.add(information);
                }
                donorlist adapter = new donorlist(FindBloodInApp.this,donorInformations);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void selectBloodGroup(View view) {
        AlertDialog.Builder builder =new AlertDialog.Builder(FindBloodInApp.this);
        builder.setTitle("Choose Blood Group");
        builder.setItems(bloodGroupName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                BloodFilter.setText(bloodGroupName[i]);
                bloodSelectionBtn = bloodGroupName[i];
            }
        });

        builder.setCancelable(false);
        builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void SelectLocationBtn(View view) {

        AlertDialog.Builder builder =new AlertDialog.Builder(FindBloodInApp.this);
        builder.setTitle("Choose Your Location");
        builder.setItems(locationFilter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                LocationFilter.setText(locationFilter[i]);
                locationSelectionBtn = locationFilter[i];
            }
        });

        builder.setCancelable(false);
        builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void filterBtn(View view) {
        Toast.makeText(this, "Filter Button clicked", Toast.LENGTH_SHORT).show();
    }
}
