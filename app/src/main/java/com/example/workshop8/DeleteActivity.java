package com.example.workshop8;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import Adapter.AgencyAdapter;
import Adapter.BookingAdapter;
import Adapter.BookingDetailsAdapter;
import Adapter.ClassesAdapter;
import Adapter.CustomerAdapter;
import Adapter.FeeAdapter;
import Adapter.ProductSupplierAdapter;
import Adapter.RegionAdapter;
import Adapter.TripTypeAdapter;
import Model.Agency;
import Model.Booking;
import Model.BookingDetails;
import Model.Classes;
import Model.Customer;
import Model.Fee;
import Model.ProductsSupplier;
import Model.Region;
import Model.TripType;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DeleteActivity extends AppCompatActivity {

    private TravelExpertsApiService travelExpertsApiService;

    private TextView txtDeleteDesc;

    private TextView txtDeleteError;

    private ImageButton btnDeleteBack;
    private Button btnDeleteConfirm;

    private ListView lsvDeleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_delete);

        travelExpertsApiService = RetrofitClient.getClient().create(TravelExpertsApiService.class);

        String selectedItem = getIntent().getStringExtra("selectedItem");

        //Initialize components
        txtDeleteDesc = findViewById(R.id.txtDeleteDesc);
        btnDeleteBack = findViewById(R.id.btnDeleteBack);
        txtDeleteError = findViewById(R.id.txtDeleteError);
        lsvDeleteData = findViewById(R.id.lsvDeleteData);
        btnDeleteConfirm = findViewById(R.id.btnDeleteConfirm);
        //Set Text
        txtDeleteError.setText("");
        txtDeleteDesc.append(selectedItem);
        //Button Methods
        backButton();
        deleteButton();

        Call<?> call = getApiMethod(selectedItem);
        Call<Object> objectCall = (Call<Object>) call;

        objectCall.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                if (response.isSuccessful()) {
                    // Determine the type of data returned
                    Object responseData = response.body();
                    if (responseData instanceof List<?>) {
                        // Handle each type of response separately
                        List<?> data = (List<?>) responseData;
                        if (!data.isEmpty()) {
                            Object firstItem = data.get(0);
                            if (firstItem instanceof Agency) {
                                // Agency Data
                                AgencyAdapter adapter = new AgencyAdapter(DeleteActivity.this, (List<Agency>) data);
                                lsvDeleteData.setAdapter(adapter);
                            } else if (firstItem instanceof Booking) {
                                // Booking Data
                                BookingAdapter adapter = new BookingAdapter(DeleteActivity.this, (List<Booking>) data);
                                lsvDeleteData.setAdapter(adapter);
                            } else if (firstItem instanceof BookingDetails) {
                                // BookingDetails Data
                                BookingDetailsAdapter adapter = new BookingDetailsAdapter(DeleteActivity.this, (List<BookingDetails>) data);
                                lsvDeleteData.setAdapter(adapter);
                            } else if (firstItem instanceof Classes) {
                                // Classes Data
                                ClassesAdapter adapter = new ClassesAdapter(DeleteActivity.this, (List<Classes>) data);
                                lsvDeleteData.setAdapter(adapter);
                            } else if (firstItem instanceof Customer) {
                                // Customer Data
                                CustomerAdapter adapter = new CustomerAdapter(DeleteActivity.this, (List<Customer>) data);
                                lsvDeleteData.setAdapter(adapter);
                            } else if (firstItem instanceof Fee) {
                                // Fee Data
                                FeeAdapter adapter = new FeeAdapter(DeleteActivity.this, (List<Fee>) data);
                                lsvDeleteData.setAdapter(adapter);
                            } else if (firstItem instanceof ProductsSupplier) {
                                // Product Supplier Data
                                ProductSupplierAdapter adapter = new ProductSupplierAdapter(DeleteActivity.this, (List<ProductsSupplier>) data);
                                lsvDeleteData.setAdapter(adapter);
                            } else if (firstItem instanceof Region) {
                                // Booking Data
                                RegionAdapter adapter = new RegionAdapter(DeleteActivity.this, (List<Region>) data);
                                lsvDeleteData.setAdapter(adapter);
                            } else if (firstItem instanceof TripType) {
                                // Booking Data
                                TripTypeAdapter adapter = new TripTypeAdapter(DeleteActivity.this, (List<TripType>) data);
                                lsvDeleteData.setAdapter(adapter);
                            }

                        }
                    }
                } else {
                    txtDeleteError.setText("Failed to fetch data");
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                txtDeleteError.setText("Network Error");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //Method to handle the back button
    private void backButton() {
        btnDeleteBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to navigate back to the MainActivity
                Intent intent = new Intent(DeleteActivity.this, MainActivity.class);
                startActivity(intent);
                // Finish Update Activity
                finish();
            }
        });
    }

    //Method to handle the delete Button
    private void deleteButton() {
        btnDeleteConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedItemPosition = lsvDeleteData.getCheckedItemPosition();
                if (selectedItemPosition != ListView.INVALID_POSITION) {
                    Object selectedItem = lsvDeleteData.getItemAtPosition(selectedItemPosition);

                    // Call RetrofitClient to delete the item
                    RetrofitClient.deleteItem(selectedItem, new Callback<Void>() {
                        @Override
                        public void onResponse(Call<Void> call, Response<Void> response) {
                            txtDeleteError.setText("Success");
                        }

                        @Override
                        public void onFailure(Call<Void> call, Throwable t) {
                            txtDeleteError.setText("Failed To Delete Item, Please Try Again");
                        }
                    });
                } else {
                    txtDeleteError.setText("Please Select an Item");
                }
            }
        });
    }


    // Method to get the appropriate Retrofit API method based on the selected item
    private Call<?> getApiMethod(String selectedItem) {
        switch (selectedItem) {
            case "Agencies":
                return travelExpertsApiService.getAgencyData();
            case "Bookings":
                return travelExpertsApiService.getBookingData();
            case "Booking Details":
                return travelExpertsApiService.getBookingDetailsData();
            case "Classes":
                return travelExpertsApiService.getClassesData();
            case "customers":
                return travelExpertsApiService.getCustomerData();
            case "fees":
                return travelExpertsApiService.getFeeData();
            case "Products and Suppliers":
                return travelExpertsApiService.getProductsSupplierData();
            case "Regions":
                return travelExpertsApiService.getRegionData();
            case "Trip Types":
                return travelExpertsApiService.getTripTypeData();
            default:
                throw new IllegalArgumentException("Invalid selected item");
        }
    }
}