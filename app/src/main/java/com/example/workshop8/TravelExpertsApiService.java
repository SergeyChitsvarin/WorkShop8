package com.example.workshop8;

import android.graphics.ColorSpace;

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
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TravelExpertsApiService
{
    //GET methods for all of the tables
    @GET("http://localhost:8080/Index")
    Call<Agency> getAgencyData();
    @GET("/Bookings")
    Call<Booking> getBookingData();
    @GET("/BookingDetails")
    Call<BookingDetails> getBookingDetailsData();
    @GET("/Classes")
    Call<Classes> getClassesData();
    @GET("/Customers")
    Call<Customer> getCustomerData();
    @GET("/Fees")
    Call<Fee> getFeeData();
    @GET("/ProductsAndSuppliers")
    Call<ProductsSupplier> getProductsSupplierData();
    @GET("/Regions")
    Call<Region> getRegionData();
    @GET("/TripTypes")
    Call<TripType> getTripTypeData();

    //Delete Method
    @DELETE("http://localhost:8080/Index/{id}")
    Call<Void> deleteItem(@Path("id") int itemId);

    //POST Method
    @POST("/Agencies")
    Call<Agency> createAgency(@Body Agency agency);
    @POST("/Bookings")
    Call<Booking> createBooking(@Body Booking booking);
    @POST("/BookingDetails")
    Call<BookingDetails> createBookingDetails(@Body BookingDetails bookingDetails);

    @POST("/Classes")
    Call<Classes> createClass(@Body Classes classes);

    @POST("/Customers")
    Call<Customer> createCustomer(@Body Customer customer);

    @POST("/Fees")
    Call<Fee> createFee(@Body Fee fee);

    @POST("/ProductSuppliers")
    Call<ProductsSupplier> createProductSupplier(@Body ProductsSupplier productsSupplier);

    @POST("/Regions")
    Call<Region> createRegion(@Body Region region);

    @POST("/TripTypes")
    Call<TripType> createTripType(@Body TripType tripType);
}
