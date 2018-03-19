package com.example.user.bloodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class FindBloodInHospital extends AppCompatActivity {

    private ListView listOfHospital;
    private String[] hospital_names;
    private String[] hospital_phone_numbers;
    private int[] phone_icon={R.drawable.phone,R.drawable.phone,R.drawable.phone,R.drawable.phone,
            R.drawable.phone,R.drawable.phone,R.drawable.phone,R.drawable.phone,R.drawable.phone,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_blood_in_hospital);

        listOfHospital = findViewById(R.id.list_of_hospital);

         hospital_names = getResources().getStringArray(R.array.Hospital_Name);
         hospital_phone_numbers = getResources().getStringArray(R.array.hospital_phone_number);

         CustomAdapter customAdapter = new CustomAdapter(this,hospital_names,hospital_phone_numbers,phone_icon);
         listOfHospital.setAdapter(customAdapter);
    }
}
