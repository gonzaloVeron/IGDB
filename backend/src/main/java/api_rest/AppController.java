package api_rest;

import api_rest.DataClass.DataDeveloperSearch;
import api_rest.DataClass.DataGameSearch;
import api_rest.DataClass.DataSearch;
import api_rest.DataClass.DataStudioSearch;
import dao.impl.*;

import dao.interf.DeveloperDAO;
import io.javalin.Context;
import model.*;
import service.impl.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AppController {
    public GameServiceImpl gameService = new GameServiceImpl(new HibernateGameDAO());
    public SearchService searchService = new SearchService(new HibernateSearchDAO());
    public DeveloperServiceimpl developerService = new DeveloperServiceimpl(new HibernateDeveloper());
    public ServiceStudioimpl studioService = new ServiceStudioimpl(new HibernateStudioDAO());

    public Context searchGameByName(Context ctx){ //Borrar ?
        Game datagame = gameService.searchGameByName(ctx.pathParam("name"));
        DataGameSearch game = new DataGameSearch(datagame.getId(), datagame.getNombre(), datagame.getGenre(), datagame.getPlatform(), datagame.getSinopsis(), datagame.getUrlImage());
        return ctx.json(game);
    }

    public Context searchGameById(Context ctx){
        Game datagame = gameService.searchGameById(Long.parseLong(ctx.pathParam("id")));
        DataGameSearch game = new DataGameSearch(datagame.getId(), datagame.getNombre(), datagame.getGenre(), datagame.getPlatform(), datagame.getSinopsis(), datagame.getUrlImage());
        return ctx.json(game);
    }

    public List<Game> searchByName(Context ctx){
        return searchService.searchByName(ctx.pathParam("name"));
    }

    public List<Game> searchByGender(Context ctx){
        return searchService.searchByGender(Genre.valueOf(ctx.pathParam("genre")));
    }

    public List<Game> searchByPlatform(Context ctx){
        return searchService.searchByPlatform(Platform.valueOf(ctx.pathParam("platform")));
    }

    public Context searchDeveloperByName(Context ctx){ //Borrar ?
        return ctx.json(developerService.searchDeveloper(ctx.pathParam("name")));
    }

    public Context searchDeveloperById(Context ctx){
        Developer datadev = developerService.searchDeveloperById(Long.parseLong(ctx.pathParam("id")));                                                                          /*  al usar datadev.getStudies() da stack overflow */
        DataDeveloperSearch dev = new DataDeveloperSearch(datadev.getId(), datadev.getName(), datadev.getLastName(), datadev.getUrlPhoto(), datadev.getDateOfBirth(), datadev.getActuallyWorking(), new ArrayList<Studio>(), datadev.getGames());
        return ctx.json(dev);
    }

    public Context searchStudioByName(Context ctx){ //Borrar ?
        Studio dataStudio = studioService.searchStudio(ctx.pathParam("name"));
        DataStudioSearch studio = new DataStudioSearch(dataStudio.getId(), dataStudio.getNombre(), dataStudio.getPortada(), dataStudio.getFechaDeFundacion(), dataStudio.getEstaActivo(), dataStudio.getHistoricalDevelopers(), dataStudio.getJuegosDesarrollados(), dataStudio.desarrolladoresActuales());
        return ctx.json(studio);
    }

    public Context searchStudioById(Context ctx){
        Studio dataStudio = studioService.searchStudioById(Long.parseLong(ctx.pathParam("id")));
        DataStudioSearch studio = new DataStudioSearch(dataStudio.getId(), dataStudio.getNombre(), dataStudio.getPortada(), dataStudio.getFechaDeFundacion(), dataStudio.getEstaActivo(), dataStudio.getHistoricalDevelopers(), dataStudio.getJuegosDesarrollados(), dataStudio.desarrolladoresActuales());
        return ctx.json(studio);
    }

    public List<Studio> searchStudiesByName(String name){
        return studioService.searchStudies(name);
    }

    public List<Developer> searchDevelopersByName(String name){
        return developerService.searchDeveloper(name);
    }

    public List<Game> searchGamesByNameGenrePlatform(Context ctx){
        ArrayList<Game> games = new ArrayList<>();
        games.addAll(this.searchByName(ctx));
        games.addAll(this.searchByGender(ctx));
        games.addAll(this.searchByPlatform(ctx));

        return games;
    }

    public List<Studio> searchStudiesByName(Context ctx){
        ArrayList<Studio> studies = new ArrayList<>();
        studies.addAll(this.searchStudiesByName(ctx.pathParam("name")));

        return studies;
    }

    public List<Developer> searchDevelopersByName(Context ctx){
        ArrayList<Developer> developers = new ArrayList<>();
        developers.addAll(this.searchDevelopersByName(ctx.pathParam("name")));

        return developers;
    }

    public Context searchGameDevStdByNameGenrePlatform(Context ctx){
        List<DataSearch> dataGames = new ArrayList<>();
        List<Developer> devs = this.searchDevelopersByName(ctx);
        List<Studio> studies = this.searchStudiesByName(ctx);
        List<Game> games = this.searchGamesByNameGenrePlatform(ctx);

        dataGames.addAll(games.stream().map(e -> this.createDataSearch(e.getId(), e.getNombre(), "Game")).collect(Collectors.toList()));
        dataGames.addAll(devs.stream().map(e -> this.createDataSearch(e.getId(), e.getName(), "Dev")).collect(Collectors.toList()));
        dataGames.addAll(studies.stream().map(e -> this.createDataSearch(e.getId(), e.getNombre(), "Studio")).collect(Collectors.toList()));

        return ctx.json(withoutRepeated(dataGames));
    }

    private List<DataSearch> withoutRepeated(List<DataSearch> list){
        List<DataSearch> newList = new ArrayList<>();
        List<String> listOfNames = list.stream().map(e -> e.name).collect(Collectors.toList());
        for(int i = 0; i < list.size(); i++){
            if(listOfNames.contains(list.get(i).name)){
                newList.add(list.get(i));
                int finalI = i;
                listOfNames = listOfNames.stream().filter(n -> !n.equals(list.get(finalI).name)).collect(Collectors.toList());
            }
        }
        return newList;
    }

    public DataSearch createDataSearch(Long id, String name, String type){
        return new DataSearch(id, name, type);
    }

    public void initializeDatabase() {
       new DataServiceImpl(new HibernateDataDAO()).crearDatosIniciales();
    }
}