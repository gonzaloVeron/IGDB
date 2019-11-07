package service.impl;

import dao.interf.DesarrolladorDAO;
import model.Desarrollador;
import model.Juego;

import java.util.List;

import static service.TransactionRunner.run;

public class DesarrolladorServiceimpl {
    private DesarrolladorDAO desarrolladorDAO;


    public DesarrolladorServiceimpl(DesarrolladorDAO desarrolladorDAO){
        this.desarrolladorDAO = desarrolladorDAO;
    }
    public DesarrolladorServiceimpl(){ }

    public List<Juego> juegosDesarrollados(String nombre){
        return run(()->{ return this.desarrolladorDAO.juegosDesarrollados(nombre);});
    }

    public Desarrollador buscarDesarrollador(String nombre){
        return run(()->{return this.desarrolladorDAO.recuperarJuegoPorNombre(nombre);});
    }
}
