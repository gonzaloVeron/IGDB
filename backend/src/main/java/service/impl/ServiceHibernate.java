package service.impl;

import dao.interf.JuegoDAO;
import model.Game;
import static service.TransactionRunner.run;

public class ServiceHibernate {
    private JuegoDAO juegoDAO;


    public ServiceHibernate(JuegoDAO juegoDAO){this.juegoDAO = juegoDAO;}

    public ServiceHibernate(){}

    public void guardarJuego(Game game){
        run(() -> {
            this.juegoDAO.guardar(game);
        });
    }

}
