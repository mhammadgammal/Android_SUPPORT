package com.mhammad.photoapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private ArrayList<Hit> data;
    private Context context;
    public OnFavouriteClickListener listener;
    public PostAdapter(ArrayList<Hit> data, Context context, OnFavouriteClickListener listener) {
        this.data = data;
        this.context = context;
        this.listener =  listener;
    }

    public void setData(ArrayList<Hit> data) {this.data = data;notifyDataSetChanged();}
    public void setOnClickListener(OnFavouriteClickListener listener) { this.listener = listener; }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post, parent, false);
        PostViewHolder viewHolder = new PostViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view, viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Glide.with(context).load(data.get(position).userImageURL).into(holder.userImg);
        Glide.with(context).load(data.get(position).largeImageURL).into(holder.postImg);
        holder.userName.setText(data.get(position).user);
        holder.like.setText(data.get(position).likes + "");
        holder.comment.setText(data.get(position).comments + "");
        holder.views.setText(data.get(position).views + "");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView userImg, postImg, favourite;
        TextView views, comment, like, userName;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            userImg = itemView.findViewById(R.id.userImg);
            postImg = itemView.findViewById(R.id.postImg);
            views = itemView.findViewById(R.id.viewsTV);
            comment = itemView.findViewById(R.id.commentTV);
            like = itemView.findViewById(R.id.likeTV);
            userName = itemView.findViewById(R.id.userNameTV);
            favourite =  itemView.findViewById(R.id.favourite_disabled);

        }
    }
    public interface OnFavouriteClickListener{
        public void onClick(View v, int position);
    }
}
