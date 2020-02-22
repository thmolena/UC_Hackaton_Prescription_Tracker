package com.example.mytodolist;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    List<String> items;


    TextView doctorList;
    Button btnadd;
    Button btnadd1;
    Button btnadd2;
    Button btnadd3;
    Button btnadd4;

/*    EditText etItem;
    RecyclerView rvItems;*/
    ItemsAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doctorList = findViewById(R.id.doctorList);
        btnadd = findViewById (R.id.btnadd);
        btnadd1 = findViewById(R.id.btnadd1);
        btnadd2 = findViewById(R.id.btnadd2);
        btnadd3 = findViewById(R.id.btnadd3);
        btnadd4 = findViewById(R.id.btnadd4);



/*        etItem = findViewById(R.id.etItem);
        rvItems = findViewById(R.id.rvItems);*/

        loadItems();

        final ItemsAdapter.OnLongClickListener onLongClickListener = new ItemsAdapter.OnLongClickListener() {
            @Override
            public void onItemLongClicked(int position) {
                //Delete the item from the model
                items.remove(position);
                //Notify the adapter
                itemsAdapter.notifyItemRemoved(position);
                Toast.makeText(getApplicationContext(), "Item was removed", Toast.LENGTH_SHORT).show();
                saveItems();
            }
        };

        itemsAdapter  = new ItemsAdapter(items, onLongClickListener);
/*        rvItems.setAdapter(itemsAdapter);
        rvItems.setLayoutManager(new LinearLayoutManager(this));*/

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*               String todoItem = etItem.getText().toString();*/
               //Add item to the model
//                items.add (todoItem);
//                //Notify adapter that an item is inserted
//                itemsAdapter.notifyItemInserted(items.size()-1);
/*                etItem.setText("");
                Toast.makeText(getApplicationContext(),"Item was added", Toast.LENGTH_SHORT).show();
                saveItems();*/



            }
        });

    }

    private File getDataFile (){
            return new File(getFilesDir(), "data.txt");
    }
    // This function will load items by reading every line of the data file
    private void loadItems(){
        try {
            items = new ArrayList<>(FileUtils.readLines(getDataFile(),Charset.defaultCharset()));
        } catch (IOException e) {
            Log.e("MainActivity","Error reading items", e);
            items = new ArrayList<>();
        }
    }
    // This function saves items by writing them into the data file

    private void  saveItems() {
            try {
                FileUtils.writeLines(getDataFile(), items);
                // This function saves items by writing them into the data file
            } catch (IOException e) {
                Log.e("MainActivity","Error writing items", e);
            }

        }
}
