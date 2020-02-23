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
        setContentView(R.layout.activity_users);
        btnpass = findViewById(R.id.btnpass);


        btnpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               String todoItem = etItem.getText().toString();
//               //Add item to the model
//                items.add (todoItem);
//                //Notify adapter that an item is inserted
//                itemsAdapter.notifyItemInserted(items.size()-1);
//                etItem.setText("");
//                Toast.makeText(getApplicationContext(),"Item was added", Toast.LENGTH_SHORT).show();
//                saveItems();
                setContentView(R.layout.activity_sample_login);


            }
        });

    }


    }


