package com.example.to_doapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NoteDatabaseHelper extends SQLiteOpenHelper {
    private final String TABLE_NAME = "NOTE_TABLE";
    private final String COLUMN_ID = "ID",
    COLUMN_TITLE = "TITLE",
    COLUMN_DETAIL = "DETAIL",
    COLUMN_STATE = "STATE";
    public NoteDatabaseHelper(@Nullable Context context) {
        super(context, "note.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creationQuery = "CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_TITLE + "TEXT NOT NULL, " + COLUMN_DETAIL + "TEXT NOT NULL, "+ COLUMN_STATE + "INTEGER NOT NULL )";
        db.execSQL(creationQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertNote(NoteModel note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_TITLE, note.getNoteTitle());
        cv.put(COLUMN_DETAIL, note.getNoteDetail());
        cv.put(COLUMN_STATE, note.getNoteState());
        db.insert(TABLE_NAME,null, cv);
    }

    public List<NoteModel> getNotes(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<NoteModel> notesList = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME, null);
        if (cursor.moveToFirst()){
            do {
                String noteTitle = cursor.getString(1);
                String noteDetail = cursor.getString(2);
                int noteState = cursor.getInt(3);
                NoteModel note = new NoteModel(noteTitle, noteDetail, noteState);
                notesList.add(note);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return notesList;
    }
}
