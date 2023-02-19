package com.example.pixabaydemo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("?key=26189611-305d8ed20ad78b772e9585436")
    Call<Response> getPosts();
}
