package service.impl;

import dao.interf.GameDAO;
import model.Game;
import static service.TransactionRunner.run;

public class ServiceHibernate {
    private GameDAO gameDAO;


    public ServiceHibernate(GameDAO gameDAO){this.gameDAO = gameDAO;}

    public ServiceHibernate(){}

    public void guardarJuego(Game game){
        run(() -> {
            this.gameDAO.guardar(game);
        });
    }

}
