package com.example.daysofweekaplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.DaysViewHolder> {

    List<String> days = Arrays.asList(
            "Saturday",
            "Sunday",
            "Monday",
            "tuesday",
            "Wednesday",
            "Thursday",
            "Friday"
    );
    List<Integer> photoOfDays = Arrays.asList(
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,
            R.drawable.seven
    );

    @NonNull
    @Override
    public DaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.day_item, parent, false);
        return new DaysViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaysViewHolder holder, int position) {
        holder.dayTV.setText(days.get(position));
        holder.dayIMG.setImageResource(photoOfDays.get(position));
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public static class DaysViewHolder extends RecyclerView.ViewHolder {
        ImageView dayIMG;
        TextView dayTV;

        public DaysViewHolder(@NonNull View itemView) {
            super(itemView);
            dayIMG = itemView.findViewById(R.id.dayIMG);
            dayTV = itemView.findViewById(R.id.dayTV);
        }
    }
}
