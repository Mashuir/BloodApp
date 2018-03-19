package com.example.user.bloodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 3/20/2018.
 */

public class CustomAdapter extends BaseAdapter {

   private Context context;
   private String[] hospital_names;
   private String[] hospital_phone_number;
   private int[] phone_icon;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, String[] hospital_names, String[] hospital_phone_number, int[] phone_icon) {
        this.context = context;
        this.hospital_names = hospital_names;
        this.hospital_phone_number = hospital_phone_number;
        this.phone_icon = phone_icon;
    }

    @Override
    public int getCount() {
        return hospital_names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
           inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           view= inflater.inflate(R.layout.design_for_hospital_blood_bank,viewGroup,false);

        }
        TextView hospital_name = view.findViewById(R.id.hospital_name);
        TextView hospital_phone_numbers = view.findViewById(R.id.hospital_phone_number);
        ImageView imageView = view.findViewById(R.id.phone_in_hospital);

        imageView.setImageResource(phone_icon[i]);
        hospital_name.setText(hospital_names[i]);
        hospital_phone_numbers.setText(hospital_phone_number[i]);
        return view;
    }
}
