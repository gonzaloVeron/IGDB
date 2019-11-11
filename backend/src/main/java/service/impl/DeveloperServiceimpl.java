package service.impl;

import dao.interf.DeveloperDAO;
import model.Developer;
import model.Game;
import model.Studio;

import java.util.List;

import static service.TransactionRunner.run;

public class DeveloperServiceimpl {
    private DeveloperDAO developerDAO;


    public DeveloperServiceimpl(DeveloperDAO developerDAO){
        this.developerDAO = developerDAO;
    }
    public DeveloperServiceimpl(){ }

    public List<Game> developedGames(String name){
        return run(()->{return this.developerDAO.juegosDesarrollados(name);});
    }


    public Studio currentJob(String name, String lastName){
        return run(()->{return this.developerDAO.currentJob(name,lastName);});
    }

    public List<Developer> searchDeveloper(String name){
        return run(()->{return this.developerDAO.searchDeveloper(name);});
    }

    public Developer searchDeveloperById(Long id) {
        return run(()->{return this.developerDAO.recuperar(id);});
    }
}
