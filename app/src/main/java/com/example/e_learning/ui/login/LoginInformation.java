package com.example.e_learning.ui.login;

public class LoginInformation {

    private String email ;
    private String password ;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginInformation(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
