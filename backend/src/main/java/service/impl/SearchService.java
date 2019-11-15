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




 public List<Game> searchByName(String nombre){
     return run(()->{ return this.searchDAO.searchByName(nombre);});
 }

 public List<Game> searchByGender(Genre genre){
     return run(()->{ return this.searchDAO.searchByGenre(genre);});
 }
 public List<Game> searchByPlatform(Platform platform){
     return run(()->{ return this.searchDAO.searchByPlatform(platform);});
 }
}
