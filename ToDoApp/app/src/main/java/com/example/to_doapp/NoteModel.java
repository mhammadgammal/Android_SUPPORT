package com.example.to_doapp;

public class NoteModel {
    public String noteTitle;
    private String noteDetail;
    private int noteState;

    public NoteModel(String noteTitle, String noteDetail, int noteState) {
        this.noteTitle = noteTitle;
        this.noteDetail = noteDetail;
        this.noteState = noteState;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDetail() {
        return noteDetail;
    }

    public void setNoteDetail(String noteDetail) {
        this.noteDetail = noteDetail;
    }

    public int getNoteState() {
        return noteState;
    }

    public void setNoteState(int noteState) {
        this.noteState = noteState;
    }
}
