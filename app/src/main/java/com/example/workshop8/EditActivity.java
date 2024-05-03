package com.example.workshop8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {

    private ImageButton btnEditBack;

    private TextView txtEditDesc;

    private ListView lsvEditData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit);

        // Get Selected Item
        String selectedItem = getIntent().getStringExtra("selectedItem");

        //Initialize Components
        btnEditBack = findViewById(R.id.btnEditBack);
        txtEditDesc = findViewById(R.id.txtEditDesc);
        lsvEditData = findViewById(R.id.lsvEditData);

        //Set Text
        txtEditDesc.append(selectedItem);

        // Button Methods
        backButton();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void backButton()
    {
        btnEditBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate back to the MainActivity
                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);
                // Finish Update Activity
                finish();
            }
        });
    }
}