package com.mypackage;

public class ProfControl {
    private Database database;
    public ProfControl(Database database){
        this.database = database;
    }

    public void checkStudentGrades(String gradesId){
        StudentGrades grades = database.getStudentGrades(gradesId);
        System.out.println(grades.grades);
    }

    public void addStudentGrade(String gradesId, int grade){
        StudentGrades grades = database.getStudentGrades(gradesId);
        grades.grades.add(grade);
    }

    public double calculateAverage(String gradesId){
        StudentGrades grades = database.getStudentGrades(gradesId);
        int sum = 0;
        int count = grades.grades.size();
        for (int i = 0; i < count;i++){
            sum += grades.grades.get(i);
        }
        return sum/count;
    }

    public void getSubjectList(){
        database.getSubjectList();
    }

    public void addSubject(String subjectName){
        Subject subject = new Subject(subjectName);
        database.addSubject(subject);
    }

    public void showSubjectStudents(int subjectId){
        Subject subject = database.getSubjectById(subjectId);
        for (int i = 0; i < subject.students.size();i++){
            User user = database.getUserById(subject.students.get(i));
            System.out.println(user.userID + "|" + user.name + " " + user.surname);
        }
    }

}
