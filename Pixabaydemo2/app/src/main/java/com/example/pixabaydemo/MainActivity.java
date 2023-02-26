package com.example.pixabaydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;


import com.example.pixabaydemo.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements PhotoAdapter.OnPostClick {
    private static final String TAG = "MainActivity";
    private PhotoAdapter adapter;
    private PostsDB db;
    List<PostModel> postList = new ArrayList<>();
    private ActivityMainBinding binding;
    static int postPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = PostsDB.getINSTANCE(this);
        adapter = new PhotoAdapter(this, this);

        Single<Response> posts = PostsClient.getINSTANCE().postInterface.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        posts.subscribe(new SingleObserver<Response>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                binding.loadingBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onSuccess(@NonNull Response response) {
                postList = response.getHits();
                adapter.setPostsList(postList);
                binding.postsRV.setAdapter(adapter);
                binding.loadingBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
        binding.postsSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                getTagedPosts(newText);
                return false;
            }
        });
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, FavouritePostsActivity.class));
            }
        });

    }


    @Override
    public void onFavouriteClick(int position) {
        postPosition = position;
        Completable completable = db.postsDAO().insertPost(postList.get(position))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        completable.subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this, "post Added Successfully ", Toast.LENGTH_SHORT).show();
                if (postList.get(position).getFavState() == 0)
                    postList.get(position).favFlag = 1;
                else postList.get(position).favFlag = 0;


            }

            @Override
            public void onError(@NonNull Throwable e) {
                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });
        binding.postsRV.setAdapter(adapter);

    }

    private void getTagedPosts(String query){
        Observable<Response> tagedPosts = PostsClient.getINSTANCE().postInterface.getQueriedPosts(query)
                .subscribeOn(Schedulers.io())
                .debounce(3, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread());

        tagedPosts.subscribe(new Observer<Response>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Response response) {
                postList = response.getHits();
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        adapter.setPostsList(postList);
        binding.postsRV.setAdapter(adapter);
    }

}