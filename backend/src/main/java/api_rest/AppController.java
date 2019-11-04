package api_rest;

import dao.impl.HibernateJuegoDAO;
import io.javalin.Context;
import io.javalin.json.JavalinJson;
import model.Genero;
import model.Plataforma;
import service.impl.JuegoServiceImpl;
import service.impl.SearchService;

public class AppController {
    public JuegoServiceImpl juegoService = new JuegoServiceImpl(new HibernateJuegoDAO());
    public SearchService searchService = new SearchService();

    public void buscarJuegoPorNombre(Context ctx){
        ctx.json(juegoService.buscarJuego(ctx.pathParam("nombre")));
    }

    public void buscarPorNombre(Context ctx){
        ctx.json(searchService.busquedaPorNombre(ctx.pathParam("nombre")));
    }

    public void buscarPorGenero(Context ctx){
        ctx.json(searchService.busquedaPorgenero(Genero.valueOf(ctx.pathParam("genero"))));
    }

    public void buscarPorPlataforma(Context ctx){
        ctx.json(searchService.busquedaPorPlataforma(Plataforma.valueOf(ctx.pathParam("plataforma"))));
    }
}