package service.impl;

import dao.interf.StudioDAO;
import model.Game;
import model.Studio;
import service.interf.ServiceStudio;

import java.util.List;

import static service.TransactionRunner.run;

public class ServiceStudioimpl implements ServiceStudio {

    private StudioDAO studioDAO;

    public ServiceStudioimpl(){

    }
    public ServiceStudioimpl(StudioDAO studyDAO){
        this.studioDAO = studyDAO;
    }



    @Override
    public Studio searchStudio(String name){
        return run(()->{ return this.studioDAO.recoverStudioByName(name);});    }

    @Override
    public Studio searchStudioById(Long id) {
        return run(()->{return this.studioDAO.recover(id);});
    }

    @Override
    public List<Game> gamesOfStudio(String name){
        return run(()->{return this.studioDAO.gameOfStudio(name);});
    }

    @Override
    public List<Studio> searchStudies(String name) {
        return run(()->{return this.studioDAO.searchStudies(name);});
    }
}
