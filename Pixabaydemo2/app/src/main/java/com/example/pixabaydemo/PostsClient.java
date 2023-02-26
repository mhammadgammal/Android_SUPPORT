package com.example.pixabaydemo;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static PostsClient INSTANCE;
    public PostInterface postInterface;

    private PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostsClient getINSTANCE(){
        if (INSTANCE == null)
            return INSTANCE = new PostsClient();

        return INSTANCE;
    }
}
