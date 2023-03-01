package com.example.mvvmappl.products;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductsClient {
    public ProductsInt productsInt;
    private static ProductsClient INSTANCE;

    public ProductsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        productsInt = retrofit.create(ProductsInt.class);
    }

    public static ProductsClient getINSTANCE() {
        if (INSTANCE == null)
            return INSTANCE = new ProductsClient();
        return INSTANCE;
    }
}
