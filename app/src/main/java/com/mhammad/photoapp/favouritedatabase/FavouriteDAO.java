package com.mhammad.photoapp.favouritedatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface FavouriteDAO {
    @Insert
    public void addPost(Favourite post);
    @Delete
    public void deletePost(Favourite post);
    @Query("select * from Favourite")
    public Favourite getAllPosts();
}
