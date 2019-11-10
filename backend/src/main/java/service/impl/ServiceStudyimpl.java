package service.impl;

import dao.interf.StudyDAO;
import model.Game;
import model.Study;
import service.interf.ServiceStudy;

import java.util.List;

import static service.TransactionRunner.run;

public class ServiceStudyimpl implements ServiceStudy {

    private StudyDAO studyDAO;

    public ServiceStudyimpl(){

    }
    public ServiceStudyimpl(StudyDAO studyDAO){
        this.studyDAO = studyDAO;
    }



    @Override
    public Study searchStudy(String name){
        return run(()->{ return this.studyDAO.recuperarJuegoPorNombre(name);});    }

    @Override
    public Study searchStudyById(Long id) {
        return run(()->{return this.studyDAO.recuperar(id);});
    }

    @Override
    public List<Game> gamesOfStudy(String name){
        return run(()->{return this.studyDAO.gameOfStudy(name);});
    }
}
