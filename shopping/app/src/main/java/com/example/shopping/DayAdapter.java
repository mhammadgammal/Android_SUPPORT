package com.example.shopping;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.DayViewHolder> {
    List<String> weekList = new ArrayList<>();

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_item, parent, false);
        return new DayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, int position) {
        holder.dayTV.setText(weekList.get(position));
    }

    @Override
    public int getItemCount() {
        return weekList.size();
    }

    public void setWeekList(List<String> weekList) {
        this.weekList = weekList;
    }

    public class DayViewHolder extends RecyclerView.ViewHolder{
        TextView dayTV;
        public DayViewHolder(@NonNull View itemView) {
            super(itemView);
            dayTV = itemView.findViewById(R.id.dayTV);
        }
    }
}
