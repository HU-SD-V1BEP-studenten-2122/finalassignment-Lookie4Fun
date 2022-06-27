package nl.hu.bep.setup.Listeners;

import nl.hu.bep.setup.model.Game;
import nl.hu.bep.setup.model.GameLijst;
import nl.hu.bep.setup.persistence.GameList_PersistenceManager;
import nl.hu.bep.setup.persistence.SnakeInfo_PersistenceManager;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.HttpResources;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.Duration;

@WebListener
public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce){
        GameLijst.getGameLijst().addGame(new Game("ding"+(GameLijst.getGameLijst().getAlleGames().size()+1),15325));
        GameLijst.getGameLijst().addGame(new Game("ding"+(GameLijst.getGameLijst().getAlleGames().size()+1),1132));

        try {
            SnakeInfo_PersistenceManager.loadSnake();
            GameList_PersistenceManager.loadGamelijst();

        } catch (Exception e) {
            System.out.println("Error loading data..."+e);
            e.printStackTrace();
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        try {
            SnakeInfo_PersistenceManager.saveSnake();
            GameList_PersistenceManager.saveGamelijst();
        } catch (Exception e) {
            System.out.println("Error saving data..."+e.toString());
            e.printStackTrace();
        }
        Schedulers.shutdownNow();
        HttpResources.disposeLoopsAndConnectionsLater(Duration.ZERO,Duration.ZERO).block();
    }
}
