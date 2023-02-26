package com.example.chuyenform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Message extends AppCompatActivity {

    TextView txtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        /*txtext.findViewById(R.id.txtext);*/
        txtext = (TextView) findViewById(R.id.txtext);

        Intent intent = getIntent();
        Bundle msg = intent.getExtras();
        User user = new User("000");
        if (msg != null) {
            user = (User) msg.getSerializable("user");
        }
        txtext.setText("\n"+user.toString());
    }
}