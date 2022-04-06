package com.mhammad.photoapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("?key=26189611-305d8ed20ad78b772e9585436")
    public Call<Response> getPosts();
}
