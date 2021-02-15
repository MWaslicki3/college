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
            if (database.checkLogin(username, password)){
                System.out.println("Logged in successfully!");
                if (database.checkCredentials(username, "admin")){
                    AdminControl adminControl = new AdminControl(database);
                    AdminMenu adminMenu = new AdminMenu(adminControl);
                    adminMenu.firstMenu();
                } /*else if (userCred.get(username).equals("prof")){
                    Prof pf = new Prof();
                    try
                    {
                        Prof.firstMenu();
                    }
                    catch(InterruptedException e)
                    {
                        College.firstPage();
                    }

                } else {
                    Student st = new Student();
                    Student.firstMenu();
                }*/
            } else {
                System.out.println("Incorrect username or/and password. Try again.");
            }
        } else if (choose == 0){
            //database.getUserList();
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
