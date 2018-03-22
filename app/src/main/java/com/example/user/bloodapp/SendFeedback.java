package com.example.user.bloodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SendFeedback extends AppCompatActivity {
    DatabaseReference myRef;
    EditText feedbackET;
    Button feedBackBtn;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_feedback);

        reference = FirebaseDatabase.getInstance().getReference("FeedBack");

        feedbackET = findViewById(R.id.sendFeedbackET);
        feedBackBtn = findViewById(R.id.feedBack_btn);

        feedBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedBack();
            }
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("feedback");
    }

    private void feedBack(){
        String feedBackmsg = feedbackET.getText().toString().trim();

        if (!TextUtils.isEmpty(feedBackmsg)){

            String id = reference.push().getKey();
            FeedBackModelClass feedBack1 = new FeedBackModelClass(feedBackmsg,id);
            reference.child(id).setValue(feedBack1);
            feedBackBtn.setText("");
            Toast.makeText(this, "Thank You Sir/Madam", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "Write Something Sir/Madam", Toast.LENGTH_SHORT).show();
        }
    }


}










