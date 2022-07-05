package nl.hu.bep.setup.persistence;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import nl.hu.bep.setup.model.SnakeInfo;

import java.io.*;

public class SnakeInfo_PersistenceManager {
    private final static String ENDPOINT = "https://battlesnakelookie4fun.blob.core.windows.net/";
    private final static String SASTOKEN = "?sv=2021-06-08&ss=bfqt&srt=sco&sp=rwdlacupitfx&se=2023-11-17T16:55:56Z&st=2022-07-05T07:55:56Z&spr=https&sig=jW6c9IVfPZz434rb%2BXCgK3rT6ZY9kVlvz2WU%2B1mLqQg%3D";
    private final static String CONTAINER = "snakeinfo";
    private static BlobContainerClient blobContainerClient = new BlobContainerClientBuilder()
            .endpoint(ENDPOINT)
            .sasToken(SASTOKEN)
            .containerName(CONTAINER)
            .buildClient();

    public static void loadSnake() throws IOException, ClassNotFoundException {
        if (blobContainerClient.exists()) {
            BlobClient blobClient = blobContainerClient.getBlobClient("snakeinfo_blob");

            if (blobClient.exists()) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                blobClient.download(baos);

                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);

                Object loadedObject = ois.readObject();
                if(loadedObject instanceof SnakeInfo){
                    SnakeInfo loadedSnakeInfo = (SnakeInfo) loadedObject;
                    SnakeInfo.setsnakeinfo(loadedSnakeInfo);
                }

                baos.close();
                ois.close();
            }
        }else throw new IllegalArgumentException("Container not found...");
    }


    public static void saveSnake() throws IOException {
        if (!blobContainerClient.exists()) {
            blobContainerClient.create();
        }
        BlobClient blobClient = blobContainerClient.getBlobClient("snakeinfo_blob");
        SnakeInfo snakeInfoToSave = SnakeInfo.getsnakeInfo();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(snakeInfoToSave);

        byte[] bytez = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytez);
        blobClient.upload(bais, bytez.length, true);

        oos.close();
        bais.close();

    }
}

