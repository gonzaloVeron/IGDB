package service.impl;

import dao.interf.StudyDAO;
import model.Game;
import model.Study;

import java.util.List;

import static service.TransactionRunner.run;

public class ServiceStudy {
    private StudyDAO studyDAO;

    public ServiceStudy(){

    }
    public ServiceStudy(StudyDAO studyDAO){
        this.studyDAO = studyDAO;
    }




    public Study buscarEstudio(String nombre){
        return run(()->{ return this.studyDAO.recuperarJuegoPorNombre(nombre);});    }

    public List<Game> gamesOfStudy(String name){
        return run(()->{return this.studyDAO.gameOfStudy(name);});
    }
}
