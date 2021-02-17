package com.mypackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class Database {
    //private ArrayList<User> users = new ArrayList<>(1);
    //private Map<String, String> userPass = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Subject> subjects = new HashMap<>();
    private Map<String, StudentGrades> grades = new HashMap<>();
    //private Map<String, User> usersId = new HashMap<>();

    public void addGrades(StudentGrades studentGrades){
        this.grades.put(studentGrades.gradesId, studentGrades);
    }

    public StudentGrades getStudentGrades(String gradesId){
        return grades.get(gradesId);
    }

    public void addSubject(Subject subject){
        subjects.put(subject.subjectId, subject);
    }

    public void getSubjectList(){
        for (Map.Entry<Integer, Subject> entry : subjects.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public Subject getSubjectById(int subjectId){
        return subjects.get(subjectId);
    }

    public void addUser(User user){
        users.put(user.userID, user);
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
    public User getUserById(int userId){
        return users.get(userId);
    }
    public User getUserByName(String login){
        int userId = getUserId(login);
        return users.get(userId);
    }





}
