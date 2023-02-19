package com.example.pixabaydemo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface PostsDAO {

    @Insert
    Completable insertPost(PostModel post);

    @Query("SELECT * FROM posts_table")
    Single<List<PostModel> > getPosts();

}
