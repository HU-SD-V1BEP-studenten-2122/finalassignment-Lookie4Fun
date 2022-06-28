package nl.hu.bep.setup.model;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private boolean logedin;


    public User(String username, String password){
        this.username=username;
        this.password=password;
        this.logedin = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(Object obj){
        boolean b = false;
        if (obj instanceof User){
            User u = (User) obj;
            if(u.getUsername().equals(username) && u.getPassword().equals(password) && u.isLogedin()==logedin ){
                b = true;
            }
        }
        return b;
    }

    public boolean isLogedin() {
        return logedin;
    }

    public void setLogedin(boolean logedin) {
        this.logedin = logedin;

    }

}
