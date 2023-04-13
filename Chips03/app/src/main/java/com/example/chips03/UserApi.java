package com.example.chips03;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {
    @GET("/v1/39ea3ab5-fc4b-49cf-90ab-aab0a12ce8a4")
    Call<List<User>> getAllUsers();
}
