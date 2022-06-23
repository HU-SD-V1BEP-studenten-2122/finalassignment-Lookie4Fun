package nl.hu.bep.setup;

import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/bepslang")
public class BattlesnakeApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBattlesnake(){
        GameInfo info = new GameInfo();

        return Response.ok(info).build();
    }

    @POST
    @Path("/start")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response Start(){

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
    public Response End(){

        return Response.ok().build();
    }
}
