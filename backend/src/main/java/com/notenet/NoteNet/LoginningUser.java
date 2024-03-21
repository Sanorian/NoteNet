package com.notenet.NoteNet;

public class LoginningUser {
    private String email, password;
    public LoginningUser(String email, String password){
        this.email = email;
        this.password = password;
    }
    public String getPassword(){
        return this.email;
    }
    public String getEmail(){
        return this.password;
    }
}
