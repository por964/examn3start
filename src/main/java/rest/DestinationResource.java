package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.SportDTO;
import dtos.SportTeamDTO;
import dtos.SportTeamsDTO;
import dtos.SportsDTO;
import entities.Favourite;
import errorhandling.AlreadyExistsException;
import errorhandling.MissingInputException;
import facades.UserFacade;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeoutException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import facades.DestinationFacade;
import facades.SportFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import utils.EMF_Creator;

@Path("destination")
public class DestinationResource {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final ExecutorService es = Executors.newCachedThreadPool();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final DestinationFacade DESTINATIONFACADE = DestinationFacade.getDestinationFacade(EMF);
    private static final SportFacade SPORTFACADE = SportFacade.getSportFacade(EMF);

    @Context
    UriInfo uriInfo;

    @GET
    @Path("open/favourites/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getFavorites(@PathParam("user") String user) throws IOException, InterruptedException, ExecutionException, TimeoutException {
        List<Favourite> result = DESTINATIONFACADE.getFavorites(user);
        ArrayList<String> stringResult = new ArrayList<>();

        result.forEach(favourite -> {
            stringResult.add(favourite.getCountryName());
        });

        return stringResult;
    }

    @GET
    @Path("open/{country}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getOpenDestination(@PathParam("country") String country) throws IOException, InterruptedException, ExecutionException, TimeoutException {
        String result = DestinationFacade.getDestination(country, es, gson);
        return result;
    }

    @GET
    @Path("restricted/{country}")
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRestrictedDestination(@PathParam("country") String country) throws IOException, InterruptedException, ExecutionException, TimeoutException {
        String result = DestinationFacade.getDestination(country, es, gson);
        return result;
    }

    @POST
    @Path("open/{country}/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public String saveFavourite(@PathParam("country") String country, @PathParam("userName") String userName) throws IOException, InterruptedException, ExecutionException, TimeoutException, MissingInputException, AlreadyExistsException {
        String result = gson.toJson(DESTINATIONFACADE.addFavourite(country, userName));
        return result;
    }

    @DELETE
    @Path("open/{country}/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteFavourite(@PathParam("country") String country, @PathParam("userName") String userName) throws IOException, InterruptedException, ExecutionException, TimeoutException, MissingInputException, AlreadyExistsException {
        String result = gson.toJson(DESTINATIONFACADE.deleteFavourite(country, userName));
        return result;
    }

    @GET
    @Path("open/sports")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSports() throws IOException, InterruptedException, ExecutionException, TimeoutException {
        SportsDTO result = SPORTFACADE.getAllSports();
        return gson.toJson(result);

    }

    @POST
    @Path("sport")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addSport(String sport) throws MissingInputException {
        SportDTO spDTO = gson.fromJson(sport, SportDTO.class);
        String result = SPORTFACADE.addSport(spDTO.getName(), spDTO.getDescription());
        return gson.toJson(result);
    }


    @POST
    @Path("addteam/{sport}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addTeam(@PathParam("sport") String sportname, String teamName) throws MissingInputException {
        SportTeamDTO st = gson.fromJson(teamName, SportTeamDTO.class);
        String result = SPORTFACADE.addSportTeam(st.getPricePerYear(), st.getTeamName(), st.getMinAge(), st.getMaxAge(), sportname);
        return gson.toJson(result);
    }

    @GET
    @Path("open/teams")
    @Produces(MediaType.APPLICATION_JSON)
    public String getTeams() throws IOException, InterruptedException, ExecutionException, TimeoutException {
        SportTeamsDTO result = SPORTFACADE.getAllTeams();
        return gson.toJson(result);

    }

}
