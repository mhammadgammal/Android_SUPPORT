package com.example.mvvmappl.products;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductsInt {
    @GET("products")
    Single<ProductsResponse> getProducts();

    @GET("products/search")
    Single<ProductsResponse> getProductsByCategories(@Query("q") String category);
}
