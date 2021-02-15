package com.mypackage;
import java.util.concurrent.atomic.AtomicInteger;
public class User {
    private static final AtomicInteger count = new AtomicInteger(0);
    protected final int userID;
    protected String credential;
    protected String username;
    protected String password;
    protected String name;
    protected String surname;
    protected String pesel;
    public User( String credential,String username, String password,String name,String surname, String pesel){
        this.userID = count.incrementAndGet();
        this.credential = credential;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }
    @Override
    public String toString(){
        return userID + " | " + credential + " | " + username + " | " + password + " | " + name + " | " + surname + " | " + pesel;
    }

}
