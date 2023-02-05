package com.example.to_doapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{
    private List<NoteModel> notesList = new ArrayList<>();
    private OnNoteClickListener listener;

    public NoteAdapter(OnNoteClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.titleTV.setText(notesList.get(position).noteTitle);
        holder.detailTV.setText(notesList.get(position).getNoteDetail());
        if (notesList.get(position).getNoteState() == 0){
            holder.starImg.setImageResource(R.drawable.ic_baseline_star_border_24);
        }else holder.starImg.setImageResource(R.drawable.ic_baseline_star_24);
    }

    public void setNotesList(List<NoteModel> notesList) {
        this.notesList = notesList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, detailTV;
        ImageView starImg;
        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            detailTV = itemView.findViewById(R.id.DetailTV);
            starImg = itemView.findViewById(R.id.imageView2);
            starImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getAdapterPosition());
                }
            });
        }
    }

    public interface OnNoteClickListener{
        void onClick(int position);
    }
}
