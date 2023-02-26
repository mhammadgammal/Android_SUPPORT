package com.example.pixabaydemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pixabaydemo.databinding.ActivityFavouritePostsBinding;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FavouritePostsActivity extends AppCompatActivity {

    private ActivityFavouritePostsBinding binding;
    private FavPostsAdapter adapter;

    private PostsDB db;
    private List<PostModel> favPostsList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavouritePostsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = PostsDB.getINSTANCE(this);
        adapter = new FavPostsAdapter(this);
        getPostsFromDb();
        adapter.setFavPostsModel(favPostsList);
        binding.favPostsRV.setAdapter(adapter);

    }

    private void getPostsFromDb()
    {
        Single<List<PostModel>> posts = db.postsDAO().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        posts.subscribe(new SingleObserver<List<PostModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull List<PostModel> postModels) {
                favPostsList = postModels;
                adapter.setFavPostsModel(favPostsList);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
        binding.favPostsRV.setAdapter(adapter);
    }
}