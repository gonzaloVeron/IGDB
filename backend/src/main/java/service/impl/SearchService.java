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

 public List<Game> searchAll(String game,Genre genre,Platform platform){
     return run(()-> {return this.searchDAO.searchAll(game,genre,platform);});
 }

}
