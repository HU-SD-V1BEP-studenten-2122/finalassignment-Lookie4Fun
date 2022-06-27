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
import java.util.List;


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
        Game newGame = new Game();
        GameLijst.alleGames.add(newGame);
        GameLijst.
        return Response.ok().build();
    }

    @POST
    @Path("/move")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response move(BattlesnakeRequest request){

        System.out.println("naam: "+request.you.get("name"));

        MoveResponse move =new MoveResponse("up","Going Up!");
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


        return Response.ok(lijst).build();
    }

}
