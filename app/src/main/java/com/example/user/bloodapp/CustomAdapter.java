package com.example.user.bloodapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter implements Filterable {

    private Context context;
    ArrayList<SingleRowHospital> originalArray, tempArray;
    private LayoutInflater inflater;
    customFilter filter;

    public CustomAdapter(Context context, ArrayList<SingleRowHospital> originalArray) {
        this.context = context;
        this.originalArray = originalArray;
        this.tempArray = originalArray;
    }

    @Override
    public int getCount() {

        return originalArray.size();
    }

    @Override
    public Object getItem(int i) {
        return originalArray.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.singlehospitalrowlist, viewGroup,false);


        TextView hospital_name = view.findViewById(R.id.hospitalName);
        final TextView hospital_phone_numbers = view.findViewById(R.id.hospitalPhoneNumber);
        final ImageButton hospitalPhoneNumber = view.findViewById(R.id.phone_in_hospital);
        final SingleRowHospital hospital = originalArray.get(i);

        hospital_name.setText(originalArray.get(i).getName());
        hospital_phone_numbers.setText(originalArray.get(i).getPhoneNumber());
        hospitalPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_number = hospital.getPhoneNumber();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phone_number));
                context.startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public Filter getFilter() {
        if (filter==null){
            filter = new customFilter();
        }
        return filter;
    }

    class customFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            if (charSequence != null && charSequence.length() > 0) {
                charSequence = charSequence.toString().toUpperCase();

                ArrayList<SingleRowHospital> filters = new ArrayList<>();
                for (int i = 0; i < tempArray.size(); i++) {
                    if (tempArray.get(i).getName().toUpperCase().contains(charSequence)) {
                        SingleRowHospital hospital = new SingleRowHospital(tempArray.get(i).getName(),
                                tempArray.get(i).getPhoneNumber());
                        filters.add(hospital);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            }else {
                results.count = tempArray.size();
                results.values = tempArray;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            originalArray = (ArrayList<SingleRowHospital>) filterResults.values;
            notifyDataSetChanged();
        }
    }
}
