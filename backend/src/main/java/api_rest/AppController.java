package api_rest;

import dao.impl.HibernateGameDAO;

import dao.impl.HibernateSearchDAO;
import io.javalin.Context;
import model.Game;
import model.Genre;
import model.Platform;
import service.impl.GameServiceImpl;
import service.impl.SearchService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AppController {
    public GameServiceImpl gameService = new GameServiceImpl(new HibernateGameDAO());
    public SearchService searchService = new SearchService(new HibernateSearchDAO());

    public Context searchGameByName(Context ctx){
        return ctx.json(gameService.searchGameByName(ctx.pathParam("searchvalue")));
    }
/*
    public Context searchGameById(Context ctx){
        return ctx.json(gameService.searchGameById(ctx.pathParam("searchvalue")));
    }
*/
    public Context searchByName(Context ctx){
        return ctx.json(searchService.searchByName(ctx.pathParam("nombre")));
    }

    public Context searchByGender(Context ctx){
        return ctx.json(searchService.searchByGender(Genre.valueOf(ctx.pathParam("gender"))));
    }

    public Context searchByPlatform(Context ctx){
        return ctx.json(searchService.searchByPlatform(Platform.valueOf(ctx.pathParam("platform"))));
    }

    /*
    public Context searchDeveloper(Context ctx){
        return ctx.json(searchService.searchDeveloper(ctx.pathParam("developer")));
    }

    public Context searchStudy(Context ctx){
        return ctx.json(searchService.searchStudy(ctx.pathParam("study")));
    }
    */

    public Context searchGamesByNameGenrePlatform(Context ctx){
        String gameName = ctx.pathParam("name");
        String gameGender = ctx.pathParam("gender");
        String gamePlatform = ctx.pathParam("platform");

        ArrayList<Game> games = new ArrayList<>();
        games.addAll(searchService.searchByName(gameName));
        games.addAll(searchService.searchByGender(Genre.valueOf(gameGender)));
        games.addAll(searchService.searchByPlatform(Platform.valueOf(gamePlatform)));

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