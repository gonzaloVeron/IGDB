package service.impl;

import dao.interf.DeveloperDAO;
import model.Developer;
import model.Game;
import model.Study;

import java.util.List;

import static service.TransactionRunner.run;

public class DeveloperServiceimpl {
    private DeveloperDAO developerDAO;


    public DeveloperServiceimpl(DeveloperDAO developerDAO){
        this.developerDAO = developerDAO;
    }
    public DeveloperServiceimpl(){ }

    public List<Game> juegosDesarrollados(String nombre){
        return run(()->{return this.developerDAO.juegosDesarrollados(nombre);});
    }

    public Developer buscarDesarrollador(String nombre){
        return run(()->{return this.developerDAO.recuperarJuegoPorNombre(nombre);});
    }

    public Study currentJob(String name){
        return run(()->{return this.developerDAO.currentJob(name);});
    }

    public Developer searchByID(Long id) {
        return run(()->{return this.developerDAO.recuperar(id);});
    }
}
