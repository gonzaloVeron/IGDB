package service.impl;

import dao.impl.HibernateJuegoDAO;
import dao.impl.HibernateSearchDAO;
import dao.interf.JuegoDAO;
import dao.interf.SearchDAO;
import model.Genero;
import model.Juego;
import model.Plataforma;
import service.interf.JuegoService;

import java.util.List;

public class Facade {
    private JuegoDAO juegoDAO;
    private JuegoService juegoService;
    private SearchDAO searchDAO;
    private SearchService searchService;


    public Facade(){
        this.juegoDAO = new HibernateJuegoDAO();
        this.juegoService = new JuegoServiceImpl(juegoDAO);
        this.searchDAO = new HibernateSearchDAO();
        this.searchService = new SearchService();
    }

    public Juego buscarPorNombre(String nombre){
        return this.juegoService.buscarJuego(nombre);
    }

    public List<Juego>buscarListaDeJuegosPorNormbre(String nombre){
        return  this.searchService.busquedaPorNombre(nombre);
    }


    public List<Juego>buscarListaDeJuegosPorGenero(Genero genero){
        return  this.searchService.busquedaPorgenero(genero);
    }

    public List<Juego>buscarListaDeJuegosPorNormbre(Plataforma plataforma){
        return  this.searchService.busquedaPorPlataforma(plataforma);
    }











}
