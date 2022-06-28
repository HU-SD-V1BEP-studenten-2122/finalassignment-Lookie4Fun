package nl.hu.bep.setup.model;

import java.io.Serializable;

public class Game implements Serializable {
    private String id;
    private int aantalBeurten;
    private int aantalKeerNaarRechts;
    private int aantalKeerNaarLinks;
    private int aantalKeerNaarBoven;
    private int aantalKeerNaarBeneden;


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

    public int getAantalKeerNaarRechts() {
        return aantalKeerNaarRechts;
    }

    public void setAantalKeerNaarRechts(int aantalKeerNaarRechts) {
        this.aantalKeerNaarRechts = aantalKeerNaarRechts;
    }

    public int getAantalKeerNaarLinks() {
        return aantalKeerNaarLinks;
    }

    public void setAantalKeerNaarLinks(int aantalKeerNaarLinks) {
        this.aantalKeerNaarLinks = aantalKeerNaarLinks;
    }

    public int getAantalKeerNaarBoven() {
        return aantalKeerNaarBoven;
    }

    public void setAantalKeerNaarBoven(int aantalKeerNaarBoven) {
        this.aantalKeerNaarBoven = aantalKeerNaarBoven;
    }

    public int getAantalKeerNaarBeneden() {
        return aantalKeerNaarBeneden;
    }

    public void setAantalKeerNaarBeneden(int aantalKeerNaarBeneden) {
        this.aantalKeerNaarBeneden = aantalKeerNaarBeneden;
    }
}
