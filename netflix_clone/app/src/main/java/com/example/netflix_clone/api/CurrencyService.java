package com.example.netflix_clone.api;

import com.example.netflix_clone.model.Currency;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CurrencyService {

    @GET(".")
    Call<Currency> getCurrency();
}
