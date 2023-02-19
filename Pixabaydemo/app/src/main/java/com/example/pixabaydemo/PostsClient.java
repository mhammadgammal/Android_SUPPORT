package com.example.pixabaydemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static PostsClient INSTANCE;
    public PostInterface postInterface;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostsClient getINSTANCE(){
        if (INSTANCE == null)
            return INSTANCE = new PostsClient();

        return INSTANCE;
    }
}
