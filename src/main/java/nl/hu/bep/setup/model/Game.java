package nl.hu.bep.setup.model;

import java.util.ArrayList;

public class Game {
    private static String id;
    private int aantalBeurten;
    private String redenEind;
    private int aantalBochtjesLinksaf;

    public Game() {
        this.id= "Game "+(GameLijst.alleGames.size()+1);
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

    public String getRedenEind() {
        return redenEind;
    }

    public void setRedenEind(String redenEind) {
        this.redenEind = redenEind;
    }

    public int getAantalBochtjesLinksaf() {
        return aantalBochtjesLinksaf;
    }

    public void setAantalBochtjesLinksaf(int aantalBochtjesLinksaf) {
        this.aantalBochtjesLinksaf = aantalBochtjesLinksaf;
    }
}
