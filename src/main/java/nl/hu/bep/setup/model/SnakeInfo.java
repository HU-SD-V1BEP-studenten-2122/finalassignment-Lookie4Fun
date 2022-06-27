package nl.hu.bep.setup.model;

import java.io.Serializable;

public class SnakeInfo implements Serializable {
    private String apiversion;
    private String author;
    private String color;
    private String head;
    private String tail;
    private String version;

    private static SnakeInfo snakeInfo = new SnakeInfo();

    private SnakeInfo(){
        this.apiversion = "1";
        this.author = "MyUsername";
        this.color = "#888888";
        this.head = "default";
        this.tail = "default";
        this.version = "0.0.1-beta";
    }

    public static SnakeInfo getsnakeInfo() {
        return snakeInfo;
    }

    public static void setsnakeinfo(SnakeInfo info){
        snakeInfo = info;
    }

    public String getApiversion() {
        return apiversion;
    }

    public void setApiversion(String apiversion) {
        this.apiversion = apiversion;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTail() {
        return tail;
    }

    public void setTail(String tail) {
        this.tail = tail;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
