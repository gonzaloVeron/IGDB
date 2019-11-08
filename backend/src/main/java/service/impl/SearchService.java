package service.impl;

import dao.interf.SearchDAO;
import model.Genre;
import model.Game;
import model.Platform;

import java.util.List;
import static service.TransactionRunner.run;

public class SearchService {
 private SearchDAO searchDAO;


 public SearchService(SearchDAO searchDAO){
     this.searchDAO = searchDAO;
 }
 public SearchService() {}




 public List<Game> busquedaPorNombre(String nombre){
     return run(()->{ return this.searchDAO.busquedaPorNombre(nombre);});
 }

 public List<Game> busquedaPorgenero(Genre genre){
     return run(()->{ return this.searchDAO.busquedaPorGenero(genre);});
 }
 public List<Game> busquedaPorPlataforma(Platform platform){
     return run(()->{ return this.searchDAO.busquedaPorPlataforma(platform);});
 }
}
