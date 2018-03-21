package com.example.user.bloodapp;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeAdonor extends AppCompatActivity {

    String[] location_names;
    Button locationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_adonor);

        location_names = getResources().getStringArray(R.array.location_names);
        locationBtn = findViewById(R.id.locationSelectBtn);
    }

    public void LocationBtn(View view) {

        AlertDialog.Builder builder =new AlertDialog.Builder(BeAdonor.this);
        builder.setTitle("Choose Your Location");
        builder.setItems(location_names, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                locationBtn.setText(location_names[i]);
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
}
