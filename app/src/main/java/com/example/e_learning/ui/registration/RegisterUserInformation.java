package com.example.e_learning.ui.registration;

import android.util.Patterns;

public class RegisterUserInformation {
    private String name;
    private String email;
    private String password;
    private String confirm_password;
    private String level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }

    public boolean isPasswordLengthGreaterThan8() {
        return getPassword().length() > 8;
    }


    RegisterUserInformation(String name, String email, String password, String confirm_password, String level) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirm_password = confirm_password;
        this.level = level;
    }
}
