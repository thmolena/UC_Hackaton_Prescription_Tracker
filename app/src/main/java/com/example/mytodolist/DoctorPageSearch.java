package com.example.mytodolist;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DoctorPageSearch extends AppCompatActivity {

    Button signout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorpagesearch);

        //Find our button. It's just a regular button center in the screen.
        signout = findViewById(R.id.signout);
        //Set an onClickListener to detect clicks.

        signout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Get the intent from the previous page.
                Intent receiveIntent = getIntent();
                //Get a Bundle of data from the previous page rather than receive each string individually.
                Bundle bundle = receiveIntent.getExtras();
                //Create a new intent to the next page.
                Intent toPage3 = new Intent(DoctorPageSearch.this, MainActivity.class);
                //Put the bundle from the previous page and info from this page in the intent.
                toPage3.putExtra("Page 1 Info", bundle);
                toPage3.putExtra("Page 2 Info", "Page 2");
                //Start the activity to the next page.
                startActivity(toPage3);
            }
        });

        Button btnsend;
            //Find our button. It's just a regular button center in the screen.
            btnsend = findViewById(R.id.btnsend);

            //Set an onClickListener to detect clicks.
            btnsend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Get the intent from the previous page.
                    Intent receiveIntent = getIntent();
                    //Get a Bundle of data from the previous page rather than receive each string individually.
                    Bundle bundle = receiveIntent.getExtras();
                    //Create a new intent to the next page.
                    Intent toPage3 = new Intent(DoctorPageSearch.this, Confirm.class);
                    //Put the bundle from the previous page and info from this page in the intent.
                    toPage3.putExtra("Page 1 Info", bundle);
                    toPage3.putExtra("Page 2 Info", "Page 2");
                    //Start the activity to the next page.
                    startActivity(toPage3);
                }
            });

        }
    }



