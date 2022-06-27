package nl.hu.bep.setup.model;

import java.util.ArrayList;

public class GameLijst {
    public static ArrayList<Game> alleGames = new ArrayList<Game>();
    private Game huidigeGame = null;

    private static GameLijst mijnGameLijst = new GameLijst();
    public static GameLijst getMijnGameLijst(){return mijnGameLijst;}

    public static void setMijnGameLijst(GameLijst gameLijst){mijnGameLijst = gameLijst;}

    private GameLijst(){
    }

    public ArrayList<Game> getAlleGames(){
        return alleGames;
    }

    public Game getHuidigeGame() {
        return huidigeGame;
    }

    public void setHuidigeGame(Game game){
        this.huidigeGame=game;
    }

}
