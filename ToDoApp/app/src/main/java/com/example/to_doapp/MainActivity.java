package com.example.to_doapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NoteAdapter.OnNoteClickListener {

    private RecyclerView noteRC;
    private FloatingActionButton fab;
    public static NoteDatabaseHelper helper;
    private NoteAdapter adapter;
    private List<NoteModel> notesList;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.floatingActionButton);
        helper = new NoteDatabaseHelper(this);
        notesList = helper.getNotes();

        noteRC = findViewById(R.id.recyclerView);
        adapter = new NoteAdapter(this);
        
        adapter.setNotesList(notesList);
        noteRC.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
            }
        });
    }

    @Override
    public void onClick(int position) {
        if(notesList.get(position).getNoteState() == 0)
            notesList.get(position).setNoteState(1);
        else notesList.get(position).setNoteState(0);
        adapter.setNotesList(notesList);
        noteRC.setAdapter(adapter);
    }
}