package nl.hu.bep.setup.model;

import java.util.ArrayList;

public class LoginUsers {
    private static ArrayList<User> alleUsers=new ArrayList<>();
    private static User huidigeGebruiker;

    public boolean bestaat(User user) {
        boolean b = false;
        for(User u : alleUsers){
            if(u.equals(user)){
                b=true;
                break;
            }
        }
        return b;
    }

    public static ArrayList<User> getUsers(){
        return alleUsers;
    }
    public static void setAlleUsers(ArrayList<User> userLijst){
        alleUsers = userLijst;
    }

    public static User getHuidigeGebruiker() {
        return huidigeGebruiker;
    }

    public static void setHuidigeGebruiker(User huidigeGebruiker) {
        LoginUsers.huidigeGebruiker = huidigeGebruiker;
    }
}
