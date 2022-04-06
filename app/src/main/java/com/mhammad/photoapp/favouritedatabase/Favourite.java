package com.mhammad.photoapp.favouritedatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Favourite {
   @PrimaryKey(autoGenerate = true)
   private int ID;
   private int postID;
   private int likes;
   private int comments;
   private int views;
   private String imageURL;
   private String userPhoto;
   private String userName;

   public Favourite(int postID, int likes, int comments, int views, String imageURL, String userPhoto, String userName) {
      this.postID = postID;
      this.likes = likes;
      this.comments = comments;
      this.views = views;
      this.imageURL = imageURL;
      this.userPhoto = userPhoto;
      this.userName = userName;
   }

   public int getID() {
      return ID;
   }

   public void setID(int ID) {
      this.ID = ID;
   }

   public int getPostID() {
      return postID;
   }

   public void setPostID(int postID) {
      this.postID = postID;
   }

   public int getLikes() {
      return likes;
   }

   public void setLikes(int likes) {
      this.likes = likes;
   }

   public int getComments() {
      return comments;
   }

   public void setComments(int comments) {
      this.comments = comments;
   }

   public int getViews() {
      return views;
   }

   public void setViews(int views) {
      this.views = views;
   }

   public String getImageURL() {
      return imageURL;
   }

   public void setImageURL(String imageURL) {
      this.imageURL = imageURL;
   }

   public String getUserPhoto() {
      return userPhoto;
   }

   public void setUserPhoto(String userPhoto) {
      this.userPhoto = userPhoto;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }
}
