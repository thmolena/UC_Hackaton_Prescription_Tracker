package com.example.mytodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class sample_login extends AppCompatActivity {
    Button btnpass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnpass = (Button) findViewById(R.id.btnpass);
        btnpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Users.class);
                startActivity(intent);


            }



        });
    }

    public void activity3(View view) {
        setContentView(R.layout.activity_users);
    }
}


