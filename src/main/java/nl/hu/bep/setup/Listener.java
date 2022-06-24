package nl.hu.bep.setup;

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
        System.out.println("CONTEXT INIT");
        try {
            PersistenceManager.loadWorldFromAzure();
        } catch (Exception e) {
            System.out.println("Error loading data..."+e);
            e.printStackTrace();
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        System.out.println("CONTEXT DEST");
        try {
            PersistenceManager.saveWorldToAzure();
        } catch (Exception e) {
            System.out.println("Error saving data..."+e);
            e.printStackTrace();
        }
        Schedulers.shutdownNow();
        HttpResources.disposeLoopsAndConnectionsLater(Duration.ZERO,Duration.ZERO).block();
    }
}
