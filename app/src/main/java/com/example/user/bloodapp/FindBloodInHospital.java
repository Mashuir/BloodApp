package com.example.user.bloodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class FindBloodInHospital extends AppCompatActivity implements TextWatcher {

    EditText search;
    private ListView listOfHospital;
    private String[] hospital_names;
    private String[] hospital_phone_numbers;
    ArrayList<SingleRowHospital> myList;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_blood_in_hospital);

        search = findViewById(R.id.searchEditText);
        listOfHospital = findViewById(R.id.list_of_hospital);
        SingleRowHospital hospital;
        search.addTextChangedListener(this);
        hospital_names = getResources().getStringArray(R.array.Hospital_Name);
        hospital_phone_numbers = getResources().getStringArray(R.array.hospital_phone_number);

        myList = new ArrayList<>();
        for (int i = 0; i < hospital_names.length; i++) {
            hospital = new SingleRowHospital(hospital_names[i], hospital_phone_numbers[i]);
            myList.add(hospital);
        }


        customAdapter = new CustomAdapter(this, myList);
        listOfHospital.setAdapter(customAdapter);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        this.customAdapter.getFilter().filter(charSequence);
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
