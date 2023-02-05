package com.example.to_doapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNoteActivity extends AppCompatActivity {
    EditText noteTitleEDT, noteDetailEDT;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        noteDetailEDT = findViewById(R.id.DetailEDT);
        noteTitleEDT = findViewById(R.id.noteTitleEDT);
        addBtn = findViewById(R.id.add_button);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoteModel newNote = new NoteModel(
                        noteTitleEDT.getText().toString(),
                        noteDetailEDT.getText().toString(),
                        0
                );
                MainActivity.helper.insertNote(newNote);
                startActivity(new Intent(AddNoteActivity.this, MainActivity.class));
            }
        });
    }
}