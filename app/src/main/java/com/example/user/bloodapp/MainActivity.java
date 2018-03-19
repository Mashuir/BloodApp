package com.example.user.bloodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CardView findBlood,findInHospital,benefitForDonor,beAdonor,sendSms,sendFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findBlood = findViewById(R.id.findBlood);
        findInHospital = findViewById(R.id.findBloodInHospital);
        benefitForDonor = findViewById(R.id.benefitDonor);
        beAdonor = findViewById(R.id.beAdonor);
        sendSms = findViewById(R.id.sendSms);
        sendFeedback = findViewById(R.id.sendFeedback);

        findBlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FindBloodInApp.class);
                startActivity(intent);
            }
        });
        findInHospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FindBloodInHospital.class);
                startActivity(intent);
            }
        });
        benefitForDonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BenefitForAdonor.class);
                startActivity(intent);
            }
        });
        beAdonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BeAdonor.class);
                startActivity(intent);
            }
        });
        sendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SendSms.class);
                startActivity(intent);
            }
        });
        sendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SendFeedback.class);
                startActivity(intent);
            }
        });
    }
}
