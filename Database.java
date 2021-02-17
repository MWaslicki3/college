package com.mypackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Database {
    //private ArrayList<User> users = new ArrayList<>(1);
    //private Map<String, String> userPass = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();
    //private Map<String, User> usersId = new HashMap<>();

    public void addUser(User user){
        //users.add(user);
        users.put(user.userID, user);

        //userPass.put(user.username, user.password);
    }
    public void getUserList(){
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
    public int getUserId(String username) {
        int userId = 0;
        for (Map.Entry<Integer, User> entry : users.entrySet()) {
            if(username.equals(entry.getValue().username))
             {
                userId = entry.getKey();
                break;
            }
        }
        return userId;
    }

    public boolean removeUserById(int userId){
        boolean isKeyPresent = false;
        if (users.containsKey(userId)){
            isKeyPresent = true;
        }
        users.remove(userId);
        return isKeyPresent;
    }

    public User getUserByName(String login){
        int userId = getUserId(login);
        return users.get(userId);
    }

    /*public boolean checkCredentials(String login, String credential){
        int userId = getUserId(login);
        return users.get(userId).credential.equals(credential);
    }*/



}
