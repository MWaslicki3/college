package com.mypackage;

public class Professor extends User{
    public Professor( String username, String password, String name, String surname, String pesel) {
        super("prof", username, password, name, surname, pesel);
    }
}
