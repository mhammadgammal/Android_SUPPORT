package com.example.pixabaydemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pixabaydemo.databinding.PostItemBinding;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder> {
    private List<PostModel> postsList = new ArrayList<>();
    private Context context;
    private OnPostClick listener;



    public PhotoAdapter(Context context, OnPostClick listener) {
        this.context = context;
        this.listener = listener;

    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostItemBinding binding = PostItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PhotoViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Glide.with(context).load(postsList.get(position).getLargeImageURL()).into(holder.binding.postImg);
        Glide.with(context).load(postsList.get(position).getUserImageURL()).into(holder.binding.userImg);
        holder.binding.userNameTV.setText(postsList.get(position).getUser());
        holder.binding.likeTV.setText(String.valueOf(postsList.get(position).getLikes()));
        holder.binding.commentTV.setText(String.valueOf(postsList.get(position).getComments()));
        holder.binding.viewsTV.setText(String.valueOf(postsList.get(position).getViews()));
        if(postsList.get(position).getFavState() == 0)
            holder.binding.favouriteIC.setImageResource(R.drawable.ic_favourite_disabled);
        else holder.binding.favouriteIC.setImageResource(R.drawable.ic_favourite);

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setPostsList(List<PostModel> postsList) {
        this.postsList = postsList;
        notifyDataSetChanged();
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder {
        PostItemBinding binding;
        OnPostClick listener;
        public PhotoViewHolder(@NonNull PostItemBinding binding, OnPostClick click) {
            super(binding.getRoot());
            this.binding = binding;
            this.listener = click;
            binding.favouriteIC.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onFavouriteClick(getAdapterPosition());
                }
            });
        }
    }

    public interface OnPostClick{
        void onFavouriteClick(int position);
    }
}
