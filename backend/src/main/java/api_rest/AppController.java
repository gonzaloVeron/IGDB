package api_rest;

import api_rest.DataClass.*;
import dao.impl.*;

import io.javalin.Context;
import model.*;
import service.impl.*;
import service.interf.DataService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AppController {
    private GameServiceImpl gameService = new GameServiceImpl(new HibernateGameDAO());
    private SearchService searchService = new SearchService(new HibernateSearchDAO());
    private DeveloperServiceimpl developerService = new DeveloperServiceimpl(new HibernateDeveloper());
    private ServiceStudioimpl studioService = new ServiceStudioimpl(new HibernateStudioDAO());

    public Context searchGameById(Context ctx){
        Game game = gameService.searchGameById(Long.parseLong(ctx.pathParam("id")));
        DataGameFile dataGameFile = new DataGameFile(game);
        return ctx.json(dataGameFile);
    }

    public Context searchDeveloperById(Context ctx){
        Developer developer = developerService.searchDeveloperById(Long.parseLong(ctx.pathParam("id")));
        DataDeveloperFile dataDeveloperFile = new DataDeveloperFile(developer);
        return ctx.json(dataDeveloperFile);
    }

    public Context searchStudioById(Context ctx){
        Studio studio = studioService.searchStudioById(Long.parseLong(ctx.pathParam("id")));
        DataStudioFile dataStudioFile = new DataStudioFile(studio);
        return ctx.json(dataStudioFile);
    }

    public List<Game> searchGamesByNameGenrePlatform(Context ctx){
        ArrayList<Game> games = new ArrayList<>();
        games.addAll(searchService.searchByName(ctx.pathParam("name")));
        if (!ctx.pathParam("genre").equals("Any")){
            games.addAll(searchService.searchByGender(Genre.valueOf(ctx.pathParam("genre"))));
        }
        if (!ctx.pathParam("platform").equals("Any")) {
            games.addAll(searchService.searchByPlatform(Platform.valueOf(ctx.pathParam("platform"))));
        }
        return games;
    }


    public Context searchGameDevStdByNameGenrePlatform(Context ctx){
        List<Developer> devs = developerService.searchDeveloper(ctx.pathParam("name"));;
        List<Studio> studies = studioService.searchStudies(ctx.pathParam("name"));;
        List<Game> games = this.searchGamesByNameGenrePlatform(ctx);

        List<DataGameSearch> dataGames = parseToDataGameSearch(this.withoutRepeated(games));
        List<DataStudioSearch> dataStudios = parseToDataStudioSearch(studies);
        List<DataDeveloperSearch> dataDevs = parseToDataDeveloperSearch(devs);

        return ctx.json(new DataSearch(dataGames, dataStudios, dataDevs));
    }

    private List<DataDeveloperSearch> parseToDataDeveloperSearch(List<Developer> devs) {
        List<DataDeveloperSearch> retList = new ArrayList<>();
        devs.forEach(developer -> retList.add(new DataDeveloperSearch(developer)));
        return retList;
    }

    private List<DataStudioSearch> parseToDataStudioSearch(List<Studio> studios) {
        List<DataStudioSearch> retList = new ArrayList<>();
        studios.forEach(studio -> retList.add(new DataStudioSearch(studio)));
        return retList;
    }

    private List<DataGameSearch> parseToDataGameSearch(List<Game> games) {
        List<DataGameSearch> retList = new ArrayList<>();
        games.forEach(game -> retList.add(new DataGameSearch(game)));
        return retList;
    }

    private List<Game> withoutRepeated(List<Game> games){
        List<Game> retList = new ArrayList<>();
        games.forEach(game -> {
            boolean contains = retList.stream().anyMatch(game1 -> game1.getId().equals(game.getId()));
            if (!contains){
                retList.add(game);
            }
        });
        return retList;
    }

    // No eliminar ni modificar plox, esto asegura que la DB arranque limpia y solo cargue los elementos que nos interesan
    public void initializeDatabase() {
        DataService dataService = new DataServiceImpl(new HibernateDataDAO());
        dataService.eliminarDatos();
        dataService.crearDatosIniciales();
    }
}