package nl.hu.bep.setup;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Game> allGames = new ArrayList<Game>();

    private static Game snakeGame = new Game();
    public static Game getGame() {
        return snakeGame;
    }

    public static void setGame(Game game) {
        snakeGame = game;
    }

    private Game() {
        allGames.add(this);
    }
}
