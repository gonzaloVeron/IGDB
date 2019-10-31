package service.impl;

import dao.interf.JuegoDAO;
import model.Juego;
import service.interf.JuegoService;
import static service.TransactionRunner.run;

public class JuegoServiceImpl implements JuegoService {
    private JuegoDAO juegoDAO;

    public JuegoServiceImpl(JuegoDAO juegoDAO){
        this.juegoDAO = juegoDAO;
    }

    @Override
    public Juego buscarJuego(String nombre) {
        return run(()->{ return this.juegoDAO.recuperarJuegoPorNombre(nombre);});
    }
}
