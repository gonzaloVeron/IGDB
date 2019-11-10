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

    public List<Developer> searchDeveloper(String name){
        return run(()->{return this.developerDAO.searchDeveloper(name);});
    }

    public Study currentJob(String name,String lastName){

        return run(()->{return this.developerDAO.currentJob(name,lastName);});
    }

    public Developer searchStudyById(Long id) {

        return run(()->{return this.developerDAO.recuperar(id);});
    }
}
