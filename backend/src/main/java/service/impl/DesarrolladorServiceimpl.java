package service.impl;

import dao.interf.DesarrolladorDAO;
import model.Developer;
import model.Game;

import java.time.LocalDate;
import java.util.List;

import static service.TransactionRunner.run;

public class DesarrolladorServiceimpl {
    private DesarrolladorDAO desarrolladorDAO;


    public DesarrolladorServiceimpl(DesarrolladorDAO desarrolladorDAO){
        this.desarrolladorDAO = desarrolladorDAO;
    }
    public DesarrolladorServiceimpl(){ }

    public List<Game> juegosDesarrollados(String nombre){
        return run(()->{return this.desarrolladorDAO.juegosDesarrollados(nombre);});
    }

    public Developer buscarDesarrollador(String nombre){
        return run(()->{return this.desarrolladorDAO.recuperarJuegoPorNombre(nombre);});
    }

    public Developer searchByID(Long id) {
        return run(()->{return this.desarrolladorDAO.recuperar(id);});
    }
}
