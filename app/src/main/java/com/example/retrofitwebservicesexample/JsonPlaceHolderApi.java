package com.example.retrofitwebservicesexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("v1/us/daily.json")
    Call<List<Posts>> getPosts();
}
