package com.mypackage;

public class StudentControl {
    private Database database;
    private int userId;
    public StudentControl(Database database, String username){
        this.database = database;
        this.userId = database.getUserId(username);
    }

    public void getSubjectList(){
        database.getSubjectList();
    }

    public void signUpSubject(int subId){
        StudentGrades grades = new StudentGrades(subId,userId);
        database.addGrades(grades);
        Subject subject = database.getSubjectById(subId);
        subject.students.add(userId);
    }
    public void checkGrades(int subId){
        StudentGrades grades = database.getStudentGrades(subId + "|" + userId);
        System.out.println(grades.grades);
    }

}
