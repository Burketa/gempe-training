package com.example.netflix_clone.api;

import com.example.netflix_clone.model.CEP;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CEPService {

    @GET(".")
    Call<CEP> getCEP();
}
