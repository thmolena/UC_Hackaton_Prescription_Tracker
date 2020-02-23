package com.example.mytodolist;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

   public static BreakIterator medicine;
    List<String> items;



    ItemsAdapter itemsAdapter;

    SearchView SearchDrugs;
    ListView DrugList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// This is where I changed from activity main

        DrugList = findViewById(R.id.druglist);
        loadItems();

        final ItemsAdapter.OnLongClickListener onLongClickListener = new ItemsAdapter.OnLongClickListener() {
            @Override
            public void onItemLongClicked(int position) {
                //Delete the item from the model
//                items.remove(position);
//                //Notify the adapter
//                itemsAdapter.notifyItemRemoved(position);
//                Toast.makeText(getApplicationContext(), "Item was removed", Toast.LENGTH_SHORT).show();
//                saveItems();
                //setContentView(R.layout.activity_login);// This  worked to take users to the other screen.
            }
        };

        itemsAdapter  = new ItemsAdapter(items, onLongClickListener);














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
