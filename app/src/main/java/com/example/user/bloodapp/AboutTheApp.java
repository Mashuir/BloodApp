package com.example.user.bloodapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class AboutTheApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_the_app);
    }

    public void AboutTheAppBtn(View view) {
        switch (view.getId()){
            case R.id.sendFeedback:
                Intent intent = new Intent(getApplicationContext(),SendFeedback.class);
                startActivity(intent);
                break;
            case R.id.shareTheApp:
                Intent shareintent= new Intent(Intent.ACTION_SEND);
                shareintent.setType("text/plain");
                String subject = "Learn Android App";
                String text = "This app is very beautiful";
                shareintent.putExtra(Intent.EXTRA_SUBJECT,subject);
                shareintent.putExtra(Intent.EXTRA_TEXT,text);
                startActivity(shareintent.createChooser(shareintent,"Share To"));
                break;
            case R.id.appDeveloper:
                AlertDialog.Builder builder = new AlertDialog.Builder(AboutTheApp.this);
                View view1 = LayoutInflater.from(AboutTheApp.this).inflate(R.layout.appdeveloper,null);
                builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                ImageButton facebook = view1.findViewById(R.id.facebook);
                facebook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(AboutTheApp.this, "facebook clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                ImageButton twitter = view1.findViewById(R.id.twitter);
                twitter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(AboutTheApp.this, "facebook clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                ImageButton gmail = view1.findViewById(R.id.gmail);
                gmail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                "mailto","rmashiur15@gmail.com", null));
                        emailIntent.putExtra(Intent.EXTRA_EMAIL, "rmashiur15@gmail.com");
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "About Blood App");
                        emailIntent.putExtra(Intent.EXTRA_TEXT, "");
                        startActivity(Intent.createChooser(emailIntent, "Send email..."));
                    }
                });
                builder.setView(view1);
                builder.show();

                break;
            default:
                Toast.makeText(this, "Thank You", Toast.LENGTH_SHORT).show();

        }
    }
}






