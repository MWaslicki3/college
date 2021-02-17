package com.mypackage;

import java.util.Scanner;

public class ProfMenu {
    private ProfControl profControl;
    public Scanner sc= new Scanner(System.in);
    public Scanner sc1= new Scanner(System.in);

    public ProfMenu(ProfControl profControl){
        this.profControl = profControl;
    }
    public void firstMenu() {
        System.out.println("Hello prof");
        System.out.println("Menu:");
        System.out.println("1. List subjects");
        System.out.println("2. Add subject");
        System.out.println("3. Show students assigned to subject");
        System.out.println("4. Calculate average marks of students");
        System.out.println("5. Check students marks");
        System.out.println("6. Add grade to a student");
        System.out.println("0. Logout");
        int menu = sc.nextInt();
        switch (menu) {
            case 1 -> getSubjectList();
            case 2 -> addSubject();
            case 3 -> showSubjectStudents();
            case 4 -> calculateAverage();
            case 5 -> checkStudentsGrades();
            case 6 -> addGrade();
        }

    }

    public void getSubjectList(){
        profControl.getSubjectList();
        firstMenu();
    }

    public void addSubject(){
        System.out.println("What subject do you want to add?");
        String subject = sc1.nextLine();
        profControl.addSubject(subject);
        firstMenu();
    }

    public void showSubjectStudents(){
        System.out.println("Choose subject:");
        profControl.getSubjectList();
        int subId = sc.nextInt();
        profControl.showSubjectStudents(subId);
        firstMenu();
    }

    public void calculateAverage(){
        System.out.println("Choose subject:");
        profControl.getSubjectList();
        int subId = sc.nextInt();
        System.out.println("Choose student:");
        profControl.showSubjectStudents(subId);
        int studentId = sc.nextInt();
        double avg = profControl.calculateAverage(subId+"|"+studentId);
        System.out.println("Average = " + avg);
        firstMenu();
    }
    public void checkStudentsGrades(){
        System.out.println("Choose subject:");
        profControl.getSubjectList();
        int subId = sc.nextInt();
        System.out.println("Choose student:");
        profControl.showSubjectStudents(subId);
        int studentId = sc.nextInt();
        profControl.checkStudentGrades(subId+"|"+studentId);
        firstMenu();
    }

    public void addGrade(){
        System.out.println("Choose subject:");
        profControl.getSubjectList();
        int subId = sc.nextInt();
        System.out.println("Choose student:");
        profControl.showSubjectStudents(subId);
        int studentId = sc.nextInt();
        System.out.println("What grade?");
        int grade = sc.nextInt();
        profControl.addStudentGrade(subId+"|"+studentId,grade);
        firstMenu();
    }



}



