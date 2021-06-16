package com.example.jadwalsholat.api;

import com.example.jadwalsholat.model.Times;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("v2/times/today.json?city=bekasi")
    Call<Times> getJadwal();
}
