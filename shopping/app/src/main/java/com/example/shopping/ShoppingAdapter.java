package com.example.shopping;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.ViewHolder> {
    private static final String TAG = "ShoppingAdapter";
    Context context;
    List<ShoppingModelImpl>shoppingList=new ArrayList<>();
    OnProductClickListener listener;

    public ShoppingAdapter(Context context, OnProductClickListener listener) {
        this.context = context;
        this.listener = listener;
    }

    public void setData(List<ShoppingModelImpl> shoppingList){
        this.shoppingList=shoppingList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ViewCreated");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: View Binded");
        holder.nameTV.setText(shoppingList.get(position).getName());
        holder.priceTV.setText(String.valueOf(shoppingList.get(position).getPrice()));
        holder.img.setImageResource(shoppingList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return shoppingList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameTV,priceTV;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV=itemView.findViewById(R.id.nameTV);
            priceTV=itemView.findViewById(R.id.priceTV);
            img=itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onProductClickListener(getAdapterPosition());
                }
            });

        }
    }

    public interface OnProductClickListener{
        void onProductClickListener(int position);
    }
}
