package com.example.workshop8;

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
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "http://localhost:8080/Index/";

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static void deleteItem(Object item, Callback<Void> callback) {
        // Create ApiService instance
        TravelExpertsApiService apiService = getClient().create(TravelExpertsApiService.class);

        // Determine the endpoint based on the type of the item
        Integer endpoint = null;
        if (item instanceof Agency) {
            endpoint = ((Agency) item).getAgencyId();
        } else if (item instanceof Booking) {
            endpoint = ((Booking) item).getBookingId();
        } else if (item instanceof BookingDetails) {
            endpoint = ((BookingDetails) item).getBookingDetailId();
        } else if (item instanceof Classes) {
            endpoint = Integer.valueOf(((Classes) item).getClassId());
        } else if (item instanceof Customer) {
            endpoint = ((Customer) item).getCustomerId();
        } else if (item instanceof Fee) {
            endpoint = Integer.valueOf(((Fee) item).getFeeId());
        } else if (item instanceof ProductsSupplier) {
            endpoint = ((ProductsSupplier) item).getProductSupplierId();
        } else if (item instanceof Region) {
            endpoint = Integer.valueOf(((Region) item).getRegionId());
        } else if (item instanceof TripType) {
            endpoint = Integer.valueOf(((TripType) item).getTripTypeId());
        }

        if (endpoint != null) {
            // Call the delete method for the determined endpoint
            Call<Void> call = apiService.deleteItem(endpoint);

            // Enqueue the delete request asynchronously
            call.enqueue(callback);
        } else {
            // Handle unsupported item type
        }
    }

    public static void addNewClass(Classes newClass, Callback<Classes> callback) {
        // Create ApiService instance
        TravelExpertsApiService apiService = getClient().create(TravelExpertsApiService.class);

        // Call the corresponding method in ApiService to add the new class
        Call<Classes> call = apiService.createClass(newClass);

        // Enqueue the request asynchronously
        call.enqueue(callback);
    }
    public static void addNewAgency(Agency newAgency, Callback<Agency> callback)
    {
        // Create ApiService instance
        TravelExpertsApiService apiService = getClient().create(TravelExpertsApiService.class);

        // Call the corresponding method in ApiService to add the new Agency
        Call<Agency> call = apiService.createAgency(newAgency);

        // Enqueue the request asynchronously
        call.enqueue(callback);
    }


}
