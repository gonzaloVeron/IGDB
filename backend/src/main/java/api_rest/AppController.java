package api_rest;

import dao.impl.HibernateGameDAO;
import dao.impl.HibernateSearchDAO;
import io.javalin.Context;
import model.Genre;
import model.Game;
import model.Platform;
import service.impl.GameServiceImpl;
import service.impl.SearchService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class AppController {
    public GameServiceImpl juegoService = new GameServiceImpl(new HibernateGameDAO());
    public SearchService searchService = new SearchService(new HibernateSearchDAO());

    public Context buscarJuegoPorNombre(Context ctx){
        return ctx.json(juegoService.buscarJuego(ctx.pathParam("searchvalue")));
    }

    public Context buscarPorNombre(Context ctx){
        return ctx.json(searchService.searchGame(ctx.pathParam("nombre")));
    }

    public Context buscarPorGenero(Context ctx){
        return ctx.json(searchService.busquedaPorgenero(Genre.valueOf(ctx.pathParam("gender"))));
    }

    public Context buscarPorPlataforma(Context ctx){
        return ctx.json(searchService.busquedaPorPlataforma(Platform.valueOf(ctx.pathParam("platform"))));
    }

    public Context buscarJuegosPorNombreGeneroPlataforma(Context ctx){
        String gameName = ctx.pathParam("name");
        String gameGender = ctx.pathParam("gender");
        String gamePlatform = ctx.pathParam("platform");

        ArrayList<Game> games = new ArrayList<>();
        games.addAll(searchService.searchGame(gameName));
        games.addAll(searchService.busquedaPorgenero(Genre.valueOf(gameGender)));
        games.addAll(searchService.busquedaPorPlataforma(Platform.valueOf(gamePlatform)));

        return ctx.json(this.sinRepetidos(games));
    }


























    private List<Game> sinRepetidos(List<Game> lista){
        List<Game> nuevaLista = new ArrayList<>();
        List<String> listaDeNombres = lista.stream().map(e -> e.getNombre()).collect(Collectors.toList());
        for(int i = 0; i < lista.size(); i++){
            if(listaDeNombres.contains(lista.get(i).getNombre())){
                nuevaLista.add(lista.get(i));
                int finalI = i;
                listaDeNombres = listaDeNombres.stream().filter(n -> !n.equals(lista.get(finalI).getNombre())).collect(Collectors.toList());
            }
        }
        return nuevaLista;
    }

}