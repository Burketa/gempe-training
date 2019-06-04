package com.example.netflix_clone.api;

import com.example.netflix_clone.model.Currency;

import retrofit2.Call;

public interface CurrencyService {

    Call<Currency> getCurrency();
}
