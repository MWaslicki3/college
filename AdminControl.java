package com.mypackage;


public class AdminControl {
    private Database database;
    //private AdminMenu adminMenu;

    public AdminControl(Database database){
        this.database = database;
        //this.adminMenu = adminMenu;
    }



    public void newUser(AdminMenu.Credential credential, String username, String password, String name, String surname, String pesel){
        if (AdminMenu.Credential.ADMIN.equals(credential)) {
            Admin user = new Admin(username, password, name, surname, pesel);
            database.addUser(user);
        } else if (AdminMenu.Credential.PROF.equals(credential)){
            Professor user = new Professor(username, password, name, surname, pesel);
            database.addUser(user);
        } else if (AdminMenu.Credential.STUDENT.equals(credential)){
            Student user = new Student(username, password, name, surname, pesel);
            database.addUser(user);
        }

        System.out.println("User " + username + " successfully added");
    }

    public void getUserList(){
        database.getUserList();
    }

    public void removeUser(int id){
        database.removeUserById(id);
    }
}
