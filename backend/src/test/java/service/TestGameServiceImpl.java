package service;

import dao.impl.HibernateDataDAO;
import dao.impl.HibernateGameDAO;
import dao.impl.HibernateSearchDAO;
import dao.impl.HibernateStudioDAO;
import dao.interf.DataDAO;
import dao.interf.GameDAO;
import dao.interf.SearchDAO;
import dao.interf.StudioDAO;
import model.Studio;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.*;
import service.interf.DataService;
import service.interf.JuegoService;
import service.interf.ServiceStudio;

import java.util.List;

public class TestGameServiceImpl {
    private GameDAO gameDAO;
    private JuegoService juegoService;
    private DataService dataService;
    private DataDAO dataDAO;
    private SearchDAO searchDAO;
    private SearchService searchService;
    private StudioDAO studioDAO;
    private ServiceStudio serviceStudy;


    @Before
    public void setUp(){
        gameDAO = new HibernateGameDAO();
        juegoService = new GameServiceImpl(gameDAO);
        dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        searchDAO = new HibernateSearchDAO();
        searchService = new SearchService(searchDAO);
        dataService.crearDatosIniciales();
        studioDAO = new HibernateStudioDAO();
        serviceStudy = new ServiceStudioimpl(studioDAO);
    }

    @Test
    public void studios(){
        List<Studio> studios = serviceStudy.searchStudies("a");
        Assert.assertEquals(7,studios.size());
    }


    @After
    public void clearData(){
        dataService.eliminarDatos();
   }

}
