package com.example.user.bloodapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class donorlist extends ArrayAdapter<DonorInformation> {

    private Activity context;
    private List<DonorInformation> donorInformationList;

    public donorlist( Activity context, List<DonorInformation> donorInformationList) {
        super(context, R.layout.single_list_of_find_blood,donorInformationList);
        this.context = context;
        this.donorInformationList = donorInformationList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.single_list_of_find_blood,null,true);
        TextView donorName = listViewItem.findViewById(R.id.findBloodDonorNmae);
        TextView donorPhoneNumber = listViewItem.findViewById(R.id.findBloodDonorPhoneNumber);
        TextView donorBloodGroup = listViewItem.findViewById(R.id.findBloodDonorBloodGroup);
        TextView donorLocation = listViewItem.findViewById(R.id.findBloodDonorLocation);
        ImageButton phoneCallBtn = listViewItem.findViewById(R.id.phoneCallBtn);

        final DonorInformation information = donorInformationList.get(position);
        donorName.setText(information.getDonorName());
        donorPhoneNumber.setText(information.getDonorPhoneNumber());
        donorBloodGroup.setText(information.getDonorBloodGroup());
        donorLocation.setText(information.getDonorLocation());
        phoneCallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_number =information.getDonorPhoneNumber();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phone_number));
                context.startActivity(intent);
            }
        });

        return listViewItem;
    }
}
