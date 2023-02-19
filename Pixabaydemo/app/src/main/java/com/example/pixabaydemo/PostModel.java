package com.example.pixabaydemo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "posts_table")
public class PostModel {
    @PrimaryKey()
    public int id;
    public String pageURL;
    public String type;
    public String tags;
    public String previewURL;
    public int previewWidth;
    public int previewHeight;
    public String webformatURL;
    public int webformatWidth;
    public int webformatHeight;
    public String largeImageURL;
    public String fullHDURL;
    public String imageURL;
    public int imageWidth;
    public int imageHeight;
    public int imageSize;
    public int views;
    public int downloads;
    public int likes;
    public int comments;
    public int user_id;
    public String user;
    public String userImageURL;

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getViews() {
        return views;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

    public String getUser() {
        return user;
    }

    public String getUserImageURL() {
        return userImageURL;
    }
}
