package com.mypackage;


import java.util.Scanner;

public class Main {
    public Scanner sc= new Scanner(System.in);

    public void firstPage(Database database){
        System.out.println("Welcome to our college!");
        System.out.println("Please choose:");
        System.out.println("1.Login");
        System.out.println("0.Exit");
        int choose = sc.nextInt();
        if (choose == 1){
            System.out.println("Enter login:");
            String username = sc.next();
            System.out.println("Enter password:");
            String password = sc.next();
            User user = database.getUserByName(username);
            if (user.password.equals(password)){
                System.out.println("Logged in successfully!");
                if (user.credential.equals("admin")){
                    AdminControl adminControl = new AdminControl(database);
                    AdminMenu adminMenu = new AdminMenu(adminControl);
                    adminMenu.firstMenu();
                } else if (user.credential.equals("prof")){
                    ProfControl profControl = new ProfControl(database);
                    ProfMenu profMenu = new ProfMenu(profControl);
                    profMenu.firstMenu();

                } else {
                    StudentControl studentControl = new StudentControl(database,username);
                    StudentMenu studentMenu = new StudentMenu(studentControl);
                    studentMenu.firstMenu();
                }
            } else {
                System.out.println("Incorrect username or/and password. Try again.");
            }
        } else if (choose == 0){
            System.out.println("Thank you for visiting our website!");
            System.out.println("See you next time!");
            System.exit(0);
        } else {
            System.out.println("Incorrect choice. Try again.");

        }
    }


    public static void main(String[] args) {
        Main mainMenu = new Main();
        Database database = new Database();
        AdminControl admin1 = new AdminControl(database);

        admin1.newUser(AdminMenu.Credential.ADMIN,"admin","admin", "","","");
        admin1.newUser(AdminMenu.Credential.PROF,"prof","prof", "prof","prof","prof");
        admin1.newUser(AdminMenu.Credential.STUDENT,"student","student", "student","student","student");
        while(true) {
            mainMenu.firstPage(database);
        }
        /*for(int i = 0; i < 2; i++){
            AdminControl adminControl = new AdminControl(database);
            AdminMenu adminMenu = new AdminMenu(adminControl);
            adminMenu.newUser();
        }*/


    }
}
