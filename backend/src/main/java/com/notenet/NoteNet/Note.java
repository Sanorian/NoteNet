package com.notenet.NoteNet;

public class Note {
    private String text, name;
    public Note(String text, String name){
        this.name = name;
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public String getName(){
        return this.name;
    }
}
