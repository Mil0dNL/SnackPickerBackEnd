package com.snackpicker.main.dto;

import javax.lang.model.element.Name;

public class LoginDto {

    public String Email;
    public String Password;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString()
    {
        return Email+Password;
    }

}
