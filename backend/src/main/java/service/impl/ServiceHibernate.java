package service.impl;

import dao.interf.JuegoDAO;
import model.Juego;
import static service.TransactionRunner.run;

public class ServiceHibernate {
    private JuegoDAO juegoDAO;


    public ServiceHibernate(JuegoDAO juegoDAO){this.juegoDAO = juegoDAO;}

    public ServiceHibernate(){}

    public void guardarJuego(Juego juego){
        run(() -> {
            this.juegoDAO.guardar(juego);
        });
    }

}
