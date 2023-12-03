package com.education.api;

import com.education.model.ProductDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/photos")
    Call<List<ProductDetails>> getProducts();


}
