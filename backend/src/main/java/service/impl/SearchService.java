package service.impl;

import dao.interf.SearchDAO;
import model.Genero;
import model.Juego;
import model.Plataforma;

import java.util.List;
import static service.TransactionRunner.run;

public class SearchService {
 private SearchDAO searchDAO;


 public SearchService(SearchDAO searchDAO){
     this.searchDAO = searchDAO;
 }
 public SearchService() {}




 public List<Juego> busquedaPorNombre(String nombre){
     return run(()->{ return this.searchDAO.busquedaPorNombre(nombre);});
 }

 public List<Juego> busquedaPorgenero(Genero genero){
     return run(()->{ return this.searchDAO.busquedaPorGenero(genero);});
 }
 public List<Juego> busquedaPorPlataforma(Plataforma plataforma){
     return run(()->{ return this.searchDAO.busquedaPorPlataforma(plataforma);});
 }
}
