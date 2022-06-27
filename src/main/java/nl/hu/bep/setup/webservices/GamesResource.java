//package nl.hu.bep.setup.webservices;
//
//import nl.hu.bep.setup.model.Game;
//import nl.hu.bep.setup.model.GamesLijst;
//
//import javax.json.Json;
//import javax.json.JsonArrayBuilder;
//import javax.json.JsonObjectBuilder;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//@Path("/Games")
//public class GamesResource {
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getGames(){
//        JsonArrayBuilder jab = Json.createArrayBuilder();
//        for( Game g : GamesLijst.getGamelijst().getAllGamesList()){
//            JsonObjectBuilder job = Json.createObjectBuilder();
//            job.add("Game",g.getId()) ;
//            jab.add(job);
//        }
//        return jab.build().toString();
//    }
//
//    @GET
//    @Path("{code}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getLandInfo(@PathParam("code") String code) {
//        Game game = GamesLijst.getGamelijst().getGameById(id);
//
//        JsonArrayBuilder jab = Json.createArrayBuilder();
//        JsonObjectBuilder job = Json.createObjectBuilder();
//        job.add("Code",country.getCode()) ;
//        job.add("iso3",country.getIso3()) ;
//        job.add("name",country.getName()) ;
//        job.add("continent",country.getContinent()) ;
//        job.add("capital",country.getCapital());
//        job.add("region",country.getRegion());
//        job.add("surface",country.getSurface());
//        job.add("population",country.getPopulation());
//        job.add("government",country.getGovernment());
//        job.add("lat",country.getLatitude());
//        job.add("lng",country.getLongitude());
//        jab.add(job);
//        return jab.build().toString();
//    }
//}
