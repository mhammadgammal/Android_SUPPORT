package com.example.mvvmappl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvvmappl.databinding.ActivityMainBinding;
import com.example.mvvmappl.products.Products;
import com.example.mvvmappl.products.ProductsClient;
import com.example.mvvmappl.products.ProductsResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.operators.single.SingleToObservable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements ProductsAdapter.OnProductClickListener{
    private static final String TAG = "MainActivity";
    private List<Products> productsList;
    private ProductsAdapter adapter;
    private com.example.mvvmappl.databinding.ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        productsList = new ArrayList<>();
        adapter = new ProductsAdapter(this, this);
        getProducts();
    }

    private void getProducts(){
        Single<ProductsResponse> single = ProductsClient.getINSTANCE().productsInt.getProducts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        single.subscribe(new SingleObserver<ProductsResponse>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull ProductsResponse productsResponse) {
                productsList = productsResponse.getProducts();
                adapter.setProductsList(productsList);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
        binding.productsRV.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onProductClick(int position) {
        Intent intent = new Intent(MainActivity.this, ProductDetails.class);
        startActivity(intent);
    }
}