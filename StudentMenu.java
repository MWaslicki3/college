package com.mypackage;

import java.util.Scanner;

public class StudentMenu {
    public Scanner sc= new Scanner(System.in);
    private StudentControl studentControl;
    public StudentMenu(StudentControl studentControl){
        this.studentControl = studentControl;
    }
    public void firstMenu() {
        System.out.println("Hello student");
        System.out.println("Menu:");
        System.out.println("1. Check grades");
        System.out.println("2. Sign up for a subject");
        System.out.println("0. Logout");
        int menu = sc.nextInt();
        switch (menu) {
            case 1 -> checkGrades();
            case 2 -> signUpSubject();

        }
    }

    public void signUpSubject(){
        System.out.println("Which subject would you like to sign up to?");
        studentControl.getSubjectList();
        int subId = sc.nextInt();
        studentControl.signUpSubject(subId);
        firstMenu();
    }

    public void checkGrades(){
        System.out.println("Which subject?");
        studentControl.getSubjectList();
        int subId = sc.nextInt();
        studentControl.checkGrades(subId);
        firstMenu();
    }
}
