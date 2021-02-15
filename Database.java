package com.mypackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Database {
    private ArrayList<User> users = new ArrayList<>(1);
    private Map<String, String> userPass = new HashMap<>();
    private Map<String, String> userCred = new HashMap<>();

    public void addUser(User user){
        users.add(user);
        userCred.put(user.username, user.credential);
        userPass.put(user.username, user.password);
    }
    public void getUserList(){
        for (User userRow : users) {
            System.out.println(userRow);
        }
    }
    public boolean removeUserById(int id){
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).userID == id){
                userCred.remove(users.get(i).username);
                userPass.remove(users.get(i).username);
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean checkLogin(String login, String password){
        return userPass.get(login).equals(password);
    }

    public boolean checkCredentials(String login, String credential){
        return userCred.get(login).equals(credential);
    }



}
