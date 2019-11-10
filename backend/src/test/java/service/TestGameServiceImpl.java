package service;

import dao.impl.HibernateDataDAO;
import dao.impl.HibernateGameDAO;
import dao.impl.HibernateSearchDAO;
import dao.impl.HibernateStudyDAO;
import dao.interf.DataDAO;
import dao.interf.GameDAO;
import dao.interf.SearchDAO;
import dao.interf.StudyDAO;
import model.Genre;
import model.Game;
import model.Platform;
import model.Study;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.*;
import service.interf.DataService;
import service.interf.JuegoService;
import service.interf.ServiceStudy;

import java.util.List;

public class TestGameServiceImpl {
    private GameDAO gameDAO;
    private JuegoService juegoService;
    private DataService dataService;
    private DataDAO dataDAO;
    private SearchDAO searchDAO;
    private SearchService searchService;
    private StudyDAO studyDAO;
    private ServiceStudy serviceStudy;


    @Before
    public void setUp(){
        gameDAO = new HibernateGameDAO();
        juegoService = new GameServiceImpl(gameDAO);
        dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        searchDAO = new HibernateSearchDAO();
        searchService = new SearchService(searchDAO);
        dataService.crearDatosIniciales();
        studyDAO = new HibernateStudyDAO();
        serviceStudy = new ServiceStudyimpl(studyDAO);
    }

    @Test
    public void studies(){
        List<Study> studies = serviceStudy.searchStudies("a");
        Assert.assertEquals(7,studies.size());
    }


    @After
    public void eliminarDatos(){
        dataService.eliminarDatos();
   }

}
