package com.mhammad.photoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.mhammad.photoapp.favouritedatabase.DataBase;
import com.mhammad.photoapp.favouritedatabase.Favourite;
import com.mhammad.photoapp.favouritedatabase.FavouriteDAO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{
    FavouriteDAO favouriteDAO;
    DataBase dp;
    private final static String url = "https://pixabay.com/api/";
    ArrayList<Hit> data;
    RecyclerView postRC;
    PostAdapter adapter;
    ImageView favourite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postRC = findViewById(R.id.postRC);
        favourite = findViewById(R.id.favourite_disabled);
        dp.getDatabase(this);
        data = new ArrayList<>();
        adapter = new PostAdapter(data, getApplicationContext(), new PostAdapter.OnFavouriteClickListener() {
            @Override
            public void onClick(View v, int position) {
                favouriteDAO.addPost(new Favourite(data.get(position).id,
                        data.get(position).likes,
                        data.get(position).comments,
                        data.get(position).views,
                        data.get(position).largeImageURL,
                        data.get(position).userImageURL,
                        data.get(position).user));
                Toast.makeText(MainActivity.this, "Added to favourites", Toast.LENGTH_SHORT).show();
            }
        });
        postRC.setAdapter(adapter);
        postRC.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIInterface apiInterface = retrofit.create(APIInterface.class);
        Call<Response> call = apiInterface.getPosts();
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, @NonNull retrofit2.Response<Response> response) {
                adapter.setData(response.body().hits);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();

            }
        });
    }
}