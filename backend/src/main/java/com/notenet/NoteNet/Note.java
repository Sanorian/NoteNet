package com.notenet.NoteNet;

public class Note {
    private String text, name, email, password;
    public Note(String text, String name, String email, String password){
        this.name = name;
        this.text = text;
        this.email = email;
        this.password = password;
    }

    public String getText(){
        return this.text;
    }

    public String getName(){
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}