package service.impl;

import dao.interf.GameDAO;
import model.Game;
import service.interf.JuegoService;
import static service.TransactionRunner.run;

public class GameServiceImpl implements JuegoService {
    private GameDAO gameDAO;



    public GameServiceImpl(GameDAO gameDAO){
        this.gameDAO = gameDAO;
    }

    @Override
    public Game searchGameByName(String nombre) {   return run(()->{ return this.gameDAO.recuperarJuegoPorNombre(nombre);}); }

    @Override
    public Game searchGameById(Long id) {
        return run(()->{return this.gameDAO.recuperar(id);});
    }


}
