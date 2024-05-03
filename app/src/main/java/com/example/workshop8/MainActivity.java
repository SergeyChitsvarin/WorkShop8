package com.example.workshop8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

/*
Author: Sergey Chitsvarin
Date: April 2024
This application will access the RESTful Web Service written in Workshop 7.
Send GET requests and give agents the ability to Update, Delete, View and insert into their data.
 */



public class MainActivity extends AppCompatActivity {

    private ImageButton btnEdit;
    private ImageButton btnDelete;
    private ImageButton btnUpdate;
    private TextView txtError;
    private ListView lsvTables;
    private ArrayAdapter<String> adapter;
    private int selectedItemPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize ImageButtons
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);

        txtError = findViewById(R.id.txtError);
        lsvTables = findViewById(R.id.lsvTables);

        // Set initial state of buttons
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);

        //set txtError to empty string my default
        txtError.setText("");

        // Call the button methods
        editButton();
        deleteButton();
        updateButton();

        //set up listview
        setupListView();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Method to handle click on edit button
    private void editButton() {
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedItemPosition != -1) {
                    txtError.setText("");
                    String selectedItem = adapter.getItem(selectedItemPosition);
                    Intent intent = new Intent(MainActivity.this, EditActivity.class);
                    intent.putExtra("selectedItem", selectedItem);
                    startActivity(intent);
                } else {
                    txtError.setEnabled(true);
                    txtError.setText("Please select a Table to Edit");
                }
            }
        });
    }

    // Method to handle click on delete button
    private void deleteButton() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedItemPosition != -1) {
                    txtError.setText("");
                    String selectedItem = adapter.getItem(selectedItemPosition);
                    Intent intent = new Intent(MainActivity.this, DeleteActivity.class);
                    intent.putExtra("selectedItem", selectedItem);
                    startActivity(intent);
                } else {
                    txtError.setEnabled(true);
                    txtError.setText("Please select a Table to Delete From");
                }
            }
        });
    }

    // Method to handle click on update button
    private void updateButton() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedItemPosition != -1) {
                    txtError.setText("");
                    String selectedItem = adapter.getItem(selectedItemPosition);
                    Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                    intent.putExtra("selectedItem", selectedItem);
                    startActivity(intent);
                } else {
                    txtError.setEnabled(true);
                    txtError.setText("Please select a Table to Update");
                }
            }
        });
    }

    // Method to Set up the listview to be called in the onCreate Method
    private void setupListView() {
        ArrayList<String> items = new ArrayList<>();
        items.add("agencies");
        items.add("bookings");
        items.add("booking details");
        items.add("classes");
        items.add("customers");
        items.add("fees");
        items.add("Products and Suppliers");
        items.add("Regions");
        items.add("Trip Types");

        // Initialize adapter
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        // Set adapter to ListView
        lsvTables.setAdapter(adapter);

        // Set choice mode to single
        lsvTables.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Set item click listener
        lsvTables.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Enable buttons when an item is selected
                btnEdit.setEnabled(true);
                btnDelete.setEnabled(true);
                btnUpdate.setEnabled(true);

                // Save selected item position
                selectedItemPosition = position;
            }
        });

        // Restore selected item state if previously selected
        if (selectedItemPosition != -1) {
            lsvTables.setItemChecked(selectedItemPosition, true);
        }
    }
}





    
