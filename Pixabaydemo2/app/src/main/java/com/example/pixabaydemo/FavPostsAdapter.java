package com.example.pixabaydemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pixabaydemo.databinding.FavPostItemBinding;

import java.util.ArrayList;
import java.util.List;

public class FavPostsAdapter extends RecyclerView.Adapter<FavPostsAdapter.FavPostsViewHolder> {
    private List<PostModel> favPostsList = new ArrayList<>();
    private final Context context;

    public FavPostsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public FavPostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FavPostItemBinding binding = FavPostItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FavPostsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavPostsViewHolder holder, int position) {
        Glide.with(context).load(favPostsList.get(position).getLargeImageURL()).into(holder.binding.postImg);
        Glide.with(context).load(favPostsList.get(position).getUserImageURL()).into(holder.binding.userImg);
        holder.binding.userNameTV.setText(favPostsList.get(position).getUser());
        holder.binding.likeTV.setText(String.valueOf(favPostsList.get(position).getLikes()));
        holder.binding.commentTV.setText(String.valueOf(favPostsList.get(position).getComments()));
        holder.binding.viewsTV.setText(String.valueOf(favPostsList.get(position).getViews()));
        if (favPostsList.get(position).getFavState() == 0)
            holder.binding.favouriteDisabled.setImageResource(R.drawable.ic_favourite_disabled);
        else holder.binding.favouriteDisabled.setImageResource(R.drawable.ic_favourite);
    }

    @Override
    public int getItemCount() {
        return favPostsList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setFavPostsModel(List<PostModel> favPostsModel) {
        favPostsList = favPostsModel;
        notifyDataSetChanged();
    }

    public static class FavPostsViewHolder extends RecyclerView.ViewHolder {
        FavPostItemBinding binding;

        public FavPostsViewHolder(@NonNull FavPostItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
