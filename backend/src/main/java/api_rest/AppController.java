package api_rest;

import api_rest.DataClass.DataGameSearch;
import dao.impl.HibernateDeveloper;
import dao.impl.HibernateGameDAO;

import dao.impl.HibernateSearchDAO;
import dao.impl.HibernateStudioDAO;
import dao.interf.DeveloperDAO;
import io.javalin.Context;
import model.Game;
import model.Genre;
import model.Platform;
import service.impl.DeveloperServiceimpl;
import service.impl.GameServiceImpl;
import service.impl.SearchService;
import service.impl.ServiceStudioimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AppController {
    public GameServiceImpl gameService = new GameServiceImpl(new HibernateGameDAO());
    public SearchService searchService = new SearchService(new HibernateSearchDAO());
    public DeveloperServiceimpl developerService = new DeveloperServiceimpl(new HibernateDeveloper());
    public ServiceStudioimpl studioService = new ServiceStudioimpl(new HibernateStudioDAO());

    public Context searchGameByName(Context ctx){
        Game datagame = gameService.searchGameByName(ctx.pathParam("name"));
        DataGameSearch game = new DataGameSearch(datagame.getId(), datagame.getNombre(), datagame.getGenre(), datagame.getPlatform(), datagame.getSinopsis());
        return ctx.json(game);
    }

    public Context searchGameById(Context ctx){
        Game datagame = gameService.searchGameById(Long.parseLong(ctx.pathParam("id")));
        DataGameSearch game = new DataGameSearch(datagame.getId(), datagame.getNombre(), datagame.getGenre(), datagame.getPlatform(), datagame.getSinopsis());
        return ctx.json(game);
    }

    public List<Game> searchByName(Context ctx){
        return searchService.searchByName(ctx.pathParam("name"));
    }

    public List<Game> searchByGender(Context ctx){
        return searchService.searchByGender(Genre.valueOf(ctx.pathParam("gender")));
    }

    public List<Game> searchByPlatform(Context ctx){
        return searchService.searchByPlatform(Platform.valueOf(ctx.pathParam("platform")));
    }
    //
    public Context searchDeveloperByName(Context ctx){
        return ctx.json(developerService.searchDeveloper(ctx.pathParam("developer")));
    }
    public Context searchDeveloperById(Context ctx){
        return ctx.json(developerService.searchDeveloperById(Long.parseLong(ctx.pathParam("developer"))));
    }
    //
    public Context searchStudioByName(Context ctx){
        return ctx.json(studioService.searchStudio(ctx.pathParam("name")));
    }
    //
    public Context searchStudioById(Context ctx){
        return ctx.json(studioService.searchStudioById(Long.parseLong(ctx.pathParam("id"))));
    }

    public Context searchGamesByNameGenrePlatform(Context ctx){
        ArrayList<Game> games = new ArrayList<>();
        games.addAll(this.searchByName(ctx));
        games.addAll(this.searchByGender(ctx));
        games.addAll(this.searchByPlatform(ctx));

        return ctx.json(this.withoutRepeated(games));
    }


    private List<Game> withoutRepeated(List<Game> list){
        List<Game> newList = new ArrayList<>();
        List<String> listOfNames = list.stream().map(e -> e.getNombre()).collect(Collectors.toList());
        for(int i = 0; i < list.size(); i++){
            if(listOfNames.contains(list.get(i).getNombre())){
                newList.add(list.get(i));
                int finalI = i;
                listOfNames = listOfNames.stream().filter(n -> !n.equals(list.get(finalI).getNombre())).collect(Collectors.toList());
            }
        }
        return newList;
    }

    public void initializeDatabase() {
    }
}