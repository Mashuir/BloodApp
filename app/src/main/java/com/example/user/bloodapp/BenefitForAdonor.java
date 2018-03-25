package com.example.user.bloodapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class BenefitForAdonor extends AppCompatActivity {

    ImageButton pathao;
    String appName = "Pathao";
    String appPackageName = "com.pathao.user";
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benefit_for_adonor);

        pathao = findViewById(R.id.pathaoBtn);
        pathao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLunchAnotherApp();
            }
        });

    }
    public void onLunchAnotherApp() {

      //  final String appPackageName = getApplicationContext().getPackageName();

        Intent intent = getPackageManager().getLaunchIntentForPackage(appPackageName);
        if (intent != null) {

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);

        } else {

            onGoToAnotherInAppStore(intent, appPackageName);

        }

    }

    public void onGoToAnotherInAppStore(Intent intent, String appPackageName) {

        try {

            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("market://details?id=" + appPackageName));
            startActivity(intent);

        } catch (android.content.ActivityNotFoundException anfe) {

            intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName));
            startActivity(intent);

        }

    }

}
