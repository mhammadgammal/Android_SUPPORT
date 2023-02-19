package com.example.pixabaydemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = PostModel.class, version = 1, exportSchema = false)
public abstract class PostsDB extends RoomDatabase {
    private static PostsDB INSTANCE;
    public abstract PostsDAO postsDAO();


    public static PostsDB getINSTANCE(Context context) {
        if (INSTANCE == null)
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    PostsDB.class, "posts.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        return INSTANCE;
    }
}
