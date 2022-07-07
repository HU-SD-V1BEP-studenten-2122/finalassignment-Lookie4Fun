package nl.hu.bep.setup.model;


import java.util.ArrayList;

public class User {
    private static String username;
    private static String password;
    private static String role;
    private static ArrayList<User> allUsers;

    public User(String username, String password, String role){
        this.username=username;
        this.password=password;
        this.role = role;
        allUsers.add(this);
    }

    public static String validateLogin(String name, String pass){
        if(name == username && pass == password) return role;
        else return null;

    }

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        User.role = role;
    }

    public static User getUserByName(String user){
        for (User u : allUsers){
            if(u.getUsername().equals(user)){
                return u;
            }
        }
        return null;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }
}
