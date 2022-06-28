package nl.hu.bep.setup.model;

import java.io.Serializable;
import java.util.ArrayList;

public class GameLijst implements Serializable {
    public static ArrayList<Game> alleGames = new ArrayList<Game>();
    private Game huidigeGame = null;

    private static GameLijst mijnGameLijst = new GameLijst();
    public static GameLijst getGameLijst(){return mijnGameLijst;}

    public static void setGameLijst(GameLijst gameLijst){mijnGameLijst = gameLijst;}

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
    public Game getGameById(String id) {
        Game game = null;
        for(Game g : getAlleGames()){
            if(g.getId().equals(id)){
                game = g;
                break;
            }
        }
        return game;
    }

    public void addGame(Game game){
       alleGames.add(game);

    }
    public void removeGame(String gameid){
        for (Game g : getAlleGames()){
            if(g.getId().equals(gameid)){
                getAlleGames().remove(g);
                break;
            }

        }
    }
}
