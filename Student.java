package com.mypackage;

public class Student extends User{
    public Student(String username, String password, String name, String surname, String pesel) {
        super("student", username, password, name, surname, pesel);
    }
}
