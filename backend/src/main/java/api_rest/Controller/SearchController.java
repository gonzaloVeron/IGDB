package api_rest.Controller;

import api_rest.DataClass.*;
import dao.impl.*;

import io.javalin.Context;
import model.*;
import service.impl.*;
import service.interf.DataService;

import java.util.ArrayList;
import java.util.List;


public class SearchController {
    private GameServiceImpl gameService = new GameServiceImpl(new HibernateGameDAO());
    private SearchService searchService = new SearchService(new HibernateSearchDAO());
    private DeveloperServiceimpl developerService = new DeveloperServiceimpl(new HibernateDeveloper());
    private ServiceStudioimpl studioService = new ServiceStudioimpl(new HibernateStudioDAO());
    private ServiceUserimpl userService = new ServiceUserimpl(new HibernateUserDAO());

    public Context searchGameById(Context ctx){
        Game game = gameService.searchGameById(Long.parseLong(ctx.pathParam("id")));
        Double score = gameService.averageScoreOfAGame(game.getName());
        System.out.print(score);
        if (score == null)
            score = 0.00;
        DataGameFile dataGameFile = new DataGameFile(game, score);
        ctx.status(200);
        return ctx.json(dataGameFile);
    }

    public Context searchUserById(Context ctx){
        User user = userService.searchUser(Long.parseLong(ctx.pathParam("id")));
        DataUserSearch dataUserFile = new DataUserSearch(user);
        ctx.status(200);
        return ctx.json(dataUserFile);
    }

    public Context searchDeveloperById(Context ctx){
        Developer developer = developerService.searchDeveloperById(Long.parseLong(ctx.pathParam("id")));
        DataDeveloperFile dataDeveloperFile = new DataDeveloperFile(developer);
        ctx.status(200);
        return ctx.json(dataDeveloperFile);
    }

    public Context searchStudioById(Context ctx){
        Studio studio = studioService.searchStudioById(Long.parseLong(ctx.pathParam("id")));
        DataStudioFile dataStudioFile = new DataStudioFile(studio);
        ctx.status(200);
        return ctx.json(dataStudioFile);
    }

    public List<Game> searchGamesByNameGenrePlatform(Context ctx){
        Genre genre = (ctx.queryParam("genre").equals("Any")) ? null : Genre.valueOf(ctx.queryParam("genre"));
        Platform platform = (ctx.queryParam("platform").equals("Any")) ? null : Platform.valueOf(ctx.queryParam("platform"));

        return searchService.searchAll(ctx.queryParam("name"), genre, platform);
    }


    public Context searchGameDevStdByNameGenrePlatform(Context ctx){
        List<Developer> devs = developerService.searchDeveloper(ctx.queryParam("name"));;
        List<Studio> studies = studioService.searchStudies(ctx.queryParam("name"));;
        List<Game> games = this.searchGamesByNameGenrePlatform(ctx);

        List<DataGameSearch> dataGames = parseToDataGameSearch(this.withoutRepeated(games));
        List<DataStudioSearch> dataStudios = parseToDataStudioSearch(studies);
        List<DataDeveloperSearch> dataDevs = parseToDataDeveloperSearch(devs);

        ctx.status(200);
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