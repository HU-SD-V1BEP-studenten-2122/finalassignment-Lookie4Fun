package nl.hu.bep.setup.model;

import java.io.Serializable;

public class Game implements Serializable {
    private String id;
    private int aantalBeurten;


    public Game(String id, int aantalBeurten) {
        this.id = id;
        this.aantalBeurten=aantalBeurten;

    }

    public String getId(){
        return id;
    }

    public int getAantalBeurten() {
        return aantalBeurten;
    }

    public void setAantalBeurten(int aantalBeurten) {
        this.aantalBeurten = aantalBeurten;
    }

}
