package service.impl;

import dao.interf.GameDAO;
import model.Developer;
import model.Game;
import model.Studio;
import service.interf.GameService;

import java.util.List;

import static service.TransactionRunner.run;

public class GameServiceImpl implements GameService {
    private GameDAO gameDAO;



    public GameServiceImpl(GameDAO gameDAO){
        this.gameDAO = gameDAO;
    }

    @Override
    public Game searchGameByName(String nombre) {   return run(()->{ return this.gameDAO.recoverGameByName(nombre);}); }

    @Override
    public Game searchGameById(Long id) {
        return run(()->{return this.gameDAO.recover(id);});
    }

    @Override
    public Studio recoverStudioFromGameByID(Long id) {
        return run(()->{return this.gameDAO.recoverStudioFromGameByID(id);});
    }

    @Override
    public List<Developer> recoverAllDevelopersForGameByID(Long id) {
        return run(()->{return this.gameDAO.recoverAllDevelopersForGameByID(id);});
    }

    @Override
    public Studio recoverStudioFromGameByName(String name) {
        return run(()->{return this.gameDAO.recoverStudioFromGameByName(name);});
    }

    @Override
    public List<Developer> recoverAllDevelopersForGameByName(String name) {
        return run(()->{return this.gameDAO.recoverAllDevelopersForGameByName(name);});
    }

}
