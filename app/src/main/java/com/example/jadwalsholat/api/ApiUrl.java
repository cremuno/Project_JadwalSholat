package com.example.jadwalsholat.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUrl {
    public static final String BASE_URL = "https://api.pray.zone/" ;
    private Retrofit retrofit;

    public ApiService getJadwal(){
        if (retrofit==null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiService.class);
    }
}
