package com.example.workshop8;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

import Model.Agency;
import Model.Classes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UpdateActivity extends AppCompatActivity {

    private ImageButton btnBack;

    private TextView txtClassName;
    private TextView txtaddError;

    private TextView txtClassDesc;

    //Agency info
    private TextView txtAgencyAddress;
    private TextView txtAgencyCity;
    private TextView txtAgencyProv;
    private TextView txtAgencyPostal;
    private TextView txtAgencyCountry;
    private TextView txtAgencyPhone;
    private TextView txtAgencyFax;

    //Booking Info
    private View dteBookingDate;
    private View numBookingNum;
    private View numTravelerCount;
    private View numCustomerId;
    private View tripTypeId;
    private View packageId;

    private Button btnAdd;

    private TextView txtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update);


        String selectedItem = getIntent().getStringExtra("selectedItem");


        //Initialize Components
        btnBack = findViewById(R.id.btnBack);
        txtDesc = findViewById(R.id.txtAddError);
        btnAdd = findViewById(R.id.btnAdd);

        //Class Fields
        txtClassDesc = findViewById(R.id.txtClassDesc);
        txtClassName = findViewById(R.id.txtClassName);

        //Agency Fields
        txtAgencyAddress = findViewById(R.id.txtAgencyAddress);
        txtAgencyCity = findViewById(R.id.txtAgencyCity);
        txtAgencyProv = findViewById(R.id.txtAgencyProv);
        txtAgencyPostal = findViewById(R.id.txtAgencyPostal);
        txtAgencyCountry = findViewById(R.id.txtAgencyCountry);
        txtAgencyPhone = findViewById(R.id.txtAgencyPhone);
        txtAgencyFax = findViewById(R.id.txtAgencyFax);

        //Booking Fields
        dteBookingDate = findViewById(R.id.dteBooking);
        numBookingNum = findViewById(R.id.numBookingNo);
        numTravelerCount = findViewById(R.id.numTravelerCount);
        numCustomerId = findViewById(R.id.numCustomerId);
        tripTypeId = findViewById(R.id.numTripTypeId);
        packageId = findViewById(R.id.numPackageId);



        //Disable by default
        txtClassName.setEnabled(false);
        txtClassDesc.setEnabled(false);
        txtAgencyAddress.setEnabled(false);
        txtAgencyCity.setEnabled(false);
        txtAgencyProv.setEnabled(false);
        txtAgencyPostal.setEnabled(false);
        txtAgencyCountry.setEnabled(false);
        txtAgencyPhone.setEnabled(false);
        txtAgencyFax.setEnabled(false);

        txtDesc.append(selectedItem);

        //Button Methods
        backButton();

        //Table Methods
        whichToUse(selectedItem);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void backButton() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate back to the MainActivity
                Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(intent);
                // Finish Update Activity
                finish();
            }
        });
    }

    private void whichToUse(String selectedItem)
    {
        if (selectedItem == "Classes")
        {
            classesTable();
        } else if (selectedItem == "Agencies") {
            agencyTable();
        }
    }


    private void classesTable() {
        // Get the text from the input fields
        String className = txtClassName.getText().toString().trim();
        String classDesc = txtClassDesc.getText().toString().trim();

        // Check if input fields are not empty
        if (!className.isEmpty() && !classDesc.isEmpty()) {
            // Create a new instance of Classes with the input data
            Classes newClass = new Classes();
            newClass.setClassName(className);
            newClass.setClassDesc(classDesc);

            // Call the API to add the new class
            addClassToWebService(newClass);
        } else {
            txtaddError.setText("Failed Adding new class!");
        }
    }

    private void agencyTable() {
        // Get the text from the input fields
        String address = txtAgencyAddress.getText().toString().trim();
        String city = txtAgencyCity.getText().toString().trim();
        String province = txtAgencyProv.getText().toString().trim();
        String postal = txtAgencyPostal.getText().toString().trim();
        String country = txtAgencyProv.getText().toString().trim();
        String phone = txtAgencyProv.getText().toString().trim();
        String fax = txtAgencyProv.getText().toString().trim();


        // Check if input fields are not empty
        if (!address.isEmpty() && !city.isEmpty() && !province.isEmpty()
                && !postal.isEmpty() && !country.isEmpty() && !phone.isEmpty() && !fax.isEmpty()) {
            // Create a new instance of Agency with the input data
            Agency newAgency = new Agency();
            newAgency.setAgncyAddress(address);
            newAgency.setAgncyCity(city);
            newAgency.setAgncyCountry(country);
            newAgency.setAgncyPostal(postal);
            newAgency.setAgncyProv(province);
            newAgency.setAgncyPhone(phone);
            newAgency.setAgncyFax(fax);


            // Call the API to add the new class
            addAgencyToWebService(newAgency);
        } else {
            txtaddError.setText("Failed Adding new agency!");
        }
    }

    private void addClassToWebService(Classes newClass) {
        //enable the fields
        txtClassName.setEnabled(true);
        txtClassDesc.setEnabled(true);

        // Call the RetrofitClient to send the data to the web service
        RetrofitClient.addNewClass(newClass, new Callback<Classes>() {
            @Override
            public void onResponse(Call<Classes> call, Response<Classes> response) {
                if (!response.isSuccessful()) {
                    txtaddError.setText("Failed to add class");
                }
            }
            @Override
            public void onFailure(Call<Classes> call, Throwable t) {
                txtaddError.setText("Network error: " + t.getMessage());
            }
        });
    }

    private void addAgencyToWebService(Agency newAgency) {
        // Enable all input fields
        txtAgencyAddress.setEnabled(true);
        txtAgencyCity.setEnabled(true);
        txtAgencyProv.setEnabled(true);
        txtAgencyPostal.setEnabled(true);
        txtAgencyCountry.setEnabled(true);
        txtAgencyPhone.setEnabled(true);
        txtAgencyFax.setEnabled(true);

        // Call the RetrofitClient to send the data to the web service
        RetrofitClient.addNewAgency(newAgency, new Callback<Agency>() {
            @Override
            public void onResponse(Call<Agency> call, Response<Agency> response) {
                if (!response.isSuccessful()) {
                    txtaddError.setText("Failed to add agency");
                }
            }
            @Override
            public void onFailure(Call<Agency> call, Throwable t) {
                txtaddError.setText("Network error: " + t.getMessage());
            }
        });
    }

}

