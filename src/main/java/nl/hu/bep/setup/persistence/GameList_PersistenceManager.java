package nl.hu.bep.setup.persistence;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import nl.hu.bep.setup.model.GameLijst;


import java.io.*;

public class GameList_PersistenceManager {
    private final static String ENDPOINT = "https://battlesnakelookie4fun.blob.core.windows.net/";
    private final static String SASTOKEN = "?sv=2021-06-08&ss=bfqt&srt=sco&sp=rwdlacupitfx&se=2024-07-27T01:31:34Z&st=2022-06-24T17:31:34Z&spr=https&sig=c4PMWNX6nFUS9J3GH1KH%2FmJ7ZVvPbbG0wlxZeUAkbCo%3D";
    private final static String CONTAINER = "gameslijst";
    private static BlobContainerClient blobContainerClient = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT)
            .sasToken(SASTOKEN)
            .containerName(CONTAINER)
            .buildClient();

    public static void loadGamelijst() throws IOException, ClassNotFoundException {
        if (blobContainerClient.exists()) {
            BlobClient blobClient = blobContainerClient.getBlobClient("gameslist_blob");

            if (blobClient.exists()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blobClient.download(baos);

                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);

                Object loadedObject = ois.readObject();
                if(loadedObject instanceof GameLijst){
                    GameLijst loadedGamelijst = (GameLijst) loadedObject;
                    GameLijst.setMijnGameLijst(loadedGamelijst);
                }

                baos.close();
                ois.close();
            }
        }else throw new IllegalArgumentException("Container not found...");
    }


    public static void saveGamelijst() throws IOException {
        if (!blobContainerClient.exists()) {
            blobContainerClient.create();
        }
        BlobClient blobClient = blobContainerClient.getBlobClient("gameslist_blob");
        GameLijst gameLijstToSave = GameLijst.getMijnGameLijst();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(gameLijstToSave);

        byte[] bytez = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blobClient.upload(bais, bytez.length, true);

        oos.close();
        bais.close();

    }
}

