package com.mypackage;

import java.util.Scanner;

public class AdminMenu {
    private int cred;
    private Credential credential;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String pesel;
    private AdminControl adminControl;
    public Scanner sc= new Scanner(System.in);
    public Scanner sc1= new Scanner(System.in);

    public AdminMenu(AdminControl adminControl){
        this.adminControl = adminControl;
    }

    enum Credential{
        ADMIN,
        PROF,
        STUDENT
    }


    public void newUser(){
        System.out.println("Credentials:");
        System.out.println("0. Admin");
        System.out.println("1. Professor");
        System.out.println("2. Student");
        this.cred = sc1.nextInt();
        switch (cred) {
            case 0 -> credential = Credential.ADMIN;
            case 1 -> credential = Credential.PROF;
            case 2 -> credential = Credential.STUDENT;
        }
        System.out.println("Username:");
        this.username = sc.nextLine();
        System.out.println("Password:");
        this.password = sc.nextLine();
        System.out.println("Name:");
        this.name = sc.nextLine();
        System.out.println("Surname:");
        this.surname = sc.nextLine();
        System.out.println("Pesel:");
        this.pesel = sc.nextLine();
        adminControl.newUser(credential,username, password, name, surname, pesel);
        System.out.println("User " + username + " successfully added");
        System.out.println("Add another user?");
        System.out.println("Enter Y/N");
        String yesNo = sc.nextLine();
        if (yesNo.equalsIgnoreCase("Y")){
            newUser();
        } else {
            firstMenu();
        }
    }

    public void removeUser(){
        String yesNo;

        adminControl.getUserList();
        do {
            System.out.println("Which user to be removed?");
            System.out.println("Type \"-1\" for none");
            int remove = sc1.nextInt();
            if (remove == -1){
                System.out.println("None user was removed");
                break;
            } else if (remove != 1) {
                boolean checkRemoved = adminControl.removeUser(remove);
                if (checkRemoved){
                    System.out.println("User removed successfully");
                } else {
                    System.out.println("Wrong id. Try again.");
                }
            } else {
                    System.out.println("Cannot remove admin");
            }
            System.out.println("Remove another user?");
            System.out.println("Enter Y/N");
            yesNo = sc.nextLine();
        } while (yesNo.equalsIgnoreCase("Y"));
        firstMenu();

    }


    public void firstMenu() {
        System.out.println("Hello Admin!");
        System.out.println("Menu:");
        System.out.println("1. Add a user");
        System.out.println("2. Remove a user");
        System.out.println("0. Logout");
        int nextMenu = sc1.nextInt();
        if (nextMenu == 1){
            newUser();
        } else if (nextMenu == 2){
            removeUser();
        }

    }
}
