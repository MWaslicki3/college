package com.mypackage;

public class Admin extends User{
    public Admin(String username, String password, String name, String surname, String pesel) {
        super("admin", username, password, name, surname, pesel);
    }
}
