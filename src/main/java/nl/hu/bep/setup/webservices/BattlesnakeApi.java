package nl.hu.bep.setup.webservices;

import nl.hu.bep.setup.model.*;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;


@Path("/bepslang")
public class BattlesnakeApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBattlesnake(){
        SnakeInfo info = SnakeInfo.getsnakeInfo();

        return Response.ok(info).build();
    }

    @POST
    @Path("/start")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Start(){
        Game newGame = new Game("Game"+GameLijst.getGameLijst().getAlleGames().size()+1,0);
        GameLijst.getGameLijst().addGame(newGame);
        GameLijst.getGameLijst().setHuidigeGame(newGame);
        return Response.ok().build();
    }

    @POST
    @Path("/move")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response move(BattlesnakeRequest request){
        Object locatie = request.you.get("head");

        int x = Integer. parseInt(locatie.toString().split(",")[0].replace("{","").replace("=","").replace("x","").trim());
        int Y = Integer. parseInt(locatie.toString().split(",")[1].replace("}","").replace("=","").replace("y","").trim());
        MoveResponse move =new MoveResponse("up","Going Up!");
        if(x>10){
            move.setMove("down");
        }
        if(x<2){
            move.setMove("down");
        }
        if(Y<2){
            move.setMove("up");
        }
        if(Y>10){
            move.setMove("down");
        }


        return Response.ok(move).build();
    }

    @POST
    @Path("/end")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response End(BattlesnakeRequest request){

        return Response.ok().build();
    }

    @PATCH
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateSnake(String updatedSnake) throws IOException {
        String een = updatedSnake.replace("{","");
        String twee = een.replace("}","");
        String[] delen = twee.split(",");
        String color = delen[0].split(":")[1].replace('"',' ').trim();
        String head = delen[1].split(":")[1].replace('"',' ').trim();
        String tail = delen[2].split(":")[1].replace('"',' ').trim();
        SnakeInfo.getsnakeInfo().setColor(color);
        SnakeInfo.getsnakeInfo().setHead(head);
        SnakeInfo.getsnakeInfo().setTail(tail);
        return Response.ok().build();
    }

    @GET
    @Path("/allegames")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGames(){
        ArrayList<String> lijst = new ArrayList<>();
        for(Game g : GameLijst.getGameLijst().getAlleGames()){
            lijst.add(g.getId());
        }
        return Response.ok(lijst).build();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGameReplay(@PathParam("id") String id){
        Game game = GameLijst.getGameLijst().getGameById(id);

        JsonArrayBuilder jab = Json.createArrayBuilder();
        JsonObjectBuilder job = Json.createObjectBuilder();

        job.add("id: ",game.getId());
        job.add("aantalBeurten: ",game.getAantalBeurten());
        jab.add(job);

        return Response.ok(jab.build().toString()).build();
    }
    @GET
    @Path("/{gameid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeGameReplay(@PathParam("gameid") String gameid){
        for(Game g : GameLijst.getGameLijst().getAlleGames()){
            if(g.getId().equals(gameid)){
                GameLijst.getGameLijst().getAlleGames().remove(g);
                break;
            }
        }
        return Response.ok().build();
    }
}
