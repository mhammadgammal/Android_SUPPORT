package com.example.mvvmappl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmappl.databinding.ProductItemBinding;
import com.example.mvvmappl.products.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> {
    private List<Products> productsList = new ArrayList<>();
    private final OnProductClickListener listener;
    private final Context context;

    public ProductsAdapter(OnProductClickListener listener, Context context) {
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemBinding binding = ProductItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductsViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        holder.binding.brandTV.setText(productsList.get(position).getBrand());
        holder.binding.categoryTV.setText(productsList.get(position).getCategory());
        holder.binding.priceTV.setText(String.valueOf(productsList.get(position).getPrice()));
        Glide.with(context).load(productsList.get(position).getThumbnail()).into(holder.binding.productImg);

    }

    @SuppressLint("NotifyDataSetChanged")
    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    protected static class ProductsViewHolder extends RecyclerView.ViewHolder {

        private final ProductItemBinding binding;

        public ProductsViewHolder(@NonNull ProductItemBinding binding, OnProductClickListener listener) {
            super(binding.getRoot());
            this.binding = binding;
            binding.productsCard.setOnClickListener(v -> listener.onProductClick(getAdapterPosition()));
        }
    }

    public interface OnProductClickListener {
        void onProductClick(int position);
    }
}
