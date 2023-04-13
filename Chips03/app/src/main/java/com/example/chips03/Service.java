package com.example.chips03;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://mocki.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static UserApi getUserApi(){
        return retrofit.create(UserApi.class);
    }
}
