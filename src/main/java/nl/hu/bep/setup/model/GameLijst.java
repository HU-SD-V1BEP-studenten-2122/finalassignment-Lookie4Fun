package nl.hu.bep.setup.model;

import java.util.ArrayList;

public class GameLijst {
    public static ArrayList<Game> alleGames = new ArrayList<Game>();
    private final Game huidigeGame;


    public GameLijst(){
    }

    public ArrayList<Game> getAlleGames(){
        return alleGames;
    }

    public Game getHuidigeGame() {
        return huidigeGame;
    }

    public void setHuidigeGame(Game huidigeGame) {
        this.huidigeGame = huidigeGame;
    }

}
