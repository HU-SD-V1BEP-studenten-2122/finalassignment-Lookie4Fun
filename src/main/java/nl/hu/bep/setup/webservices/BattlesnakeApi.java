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
import java.util.HashMap;
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
        Game newGame = new Game("Game"+GameLijst.getGameLijst().getAlleGames().size(),0);
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
        GameLijst.getGameLijst().getHuidigeGame().setAantalBeurten(GameLijst.getGameLijst().getHuidigeGame().getAantalBeurten()+1);
        int x = Integer. parseInt(locatie.toString().split(",")[0].replace("{","").replace("=","").replace("x","").trim());
        int y = Integer. parseInt(locatie.toString().split(",")[1].replace("}","").replace("=","").replace("y","").trim());
        MoveResponse move =new MoveResponse();

        if(x == 0){
            move.setMove("down");
            move.setShout("Going down!");
            GameLijst.getGameLijst().getHuidigeGame().setAantalKeerNaarBoven(GameLijst.getGameLijst().getHuidigeGame().getAantalKeerNaarBoven()+1);
        }
        if(y==0){
            move.setMove("right");
            move.setShout("Going right!");
            GameLijst.getGameLijst().getHuidigeGame().setAantalKeerNaarBoven(GameLijst.getGameLijst().getHuidigeGame().getAantalKeerNaarBoven()+1);
        }
        if(x == 10){
            move.setMove("up");
            move.setShout("Going up!");
            GameLijst.getGameLijst().getHuidigeGame().setAantalKeerNaarBoven(GameLijst.getGameLijst().getHuidigeGame().getAantalKeerNaarBoven()+1);
        }
        if(x == 10 && y==10){
            move.setMove("down");
            move.setShout("Going down!");
            GameLijst.getGameLijst().getHuidigeGame().setAantalKeerNaarBoven(GameLijst.getGameLijst().getHuidigeGame().getAantalKeerNaarBoven()+1);
        }
        if(y == 10){
            move.setMove("left");
            move.setShout("Going left!");
            GameLijst.getGameLijst().getHuidigeGame().setAantalKeerNaarBoven(GameLijst.getGameLijst().getHuidigeGame().getAantalKeerNaarBoven()+1);
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
//        if(LoginUsers.getHuidigeGebruiker()!=null){
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
//        }else{
//            Map<String, String> logginMessage = new HashMap<>();
//            logginMessage.put("ERROR", "u bent niet ingelogd");
//            return Response.ok().build();
//        }

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
        job.add("aantal beurten: ",game.getAantalBeurten());
        job.add("aantal keer naar rechts",game.getAantalKeerNaarRechts());
        job.add("aantal keer naar links",game.getAantalKeerNaarLinks());
        job.add("aantal keer naar beneden",game.getAantalKeerNaarBeneden());
        job.add("aantal keer naar boven",game.getAantalKeerNaarBoven());
        jab.add(job);

        return Response.ok(jab.build().toString()).build();
    }
    @DELETE
    @Path("/delete/{gameid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeGameReplay(@PathParam("gameid") String gameid){
//        if(LoginUsers.getHuidigeGebruiker()!=null){
            GameLijst.getGameLijst().removeGame(gameid);
            return Response.ok().build();
//        }else{
//            Map<String, String> logginMessage = new HashMap<>();
//            logginMessage.put("ERROR", "u bent niet ingelogd");
//            return Response.ok().build();
//        }
    }

    @GET
    @Path("/login/isloggedin")
    @Produces(MediaType.APPLICATION_JSON)
    public Response isloggedin(){
        Map<String, String> loggedInMessage = new HashMap<>();
        loggedInMessage.put("SUCCESS", "u bent ingelogd");
        return Response.ok(loggedInMessage).build();
    }


    @POST
    @Path("/login/{user}/{password}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Login(@PathParam("user") String user,@PathParam("password") String password){
        for(User u : LoginUsers.getUsers()){
            if(u.getUsername().equals(user)&&u.getPassword().equals(password)){
                u.setLogedin(true);
                LoginUsers.setHuidigeGebruiker(u);
            }
        }
        return Response.ok().build();
    }

    @GET
    @Path("getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(){
        boolean resp = false;
        if(LoginUsers.getHuidigeGebruiker().isLogedin()){
            resp=true;
        }
        return Response.ok(resp).build();
    }

    @POST
    @Path("/logout")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Logout(){
        LoginUsers.getHuidigeGebruiker().setLogedin(false);
        LoginUsers.setHuidigeGebruiker(null);
        return Response.ok().build();
    }
}
