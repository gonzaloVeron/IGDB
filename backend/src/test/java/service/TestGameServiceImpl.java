package service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dao.impl.HibernateDataDAO;
import dao.impl.HibernateGameDAO;
import dao.impl.HibernateSearchDAO;
import dao.impl.HibernateStudioDAO;
import dao.interf.DataDAO;
import dao.interf.GameDAO;
import dao.interf.SearchDAO;
import dao.interf.StudioDAO;
import model.Developer;
import model.Studio;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.*;
import service.interf.DataService;
import service.interf.GameService;
import service.interf.ServiceStudio;

import java.util.List;

public class TestGameServiceImpl {
    private GameDAO gameDAO;
    private GameService gameService;
    private DataService dataService;
    private DataDAO dataDAO;
    private SearchDAO searchDAO;
    private SearchService searchService;
    private StudioDAO studioDAO;
    private ServiceStudio serviceStudio;


    @Before
    public void setUp(){
        gameDAO = new HibernateGameDAO();
        gameService = new GameServiceImpl(gameDAO);
        dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        searchDAO = new HibernateSearchDAO();
        searchService = new SearchService(searchDAO);
        dataService.crearDatosIniciales();
        studioDAO = new HibernateStudioDAO();
        serviceStudio = new ServiceStudioimpl(studioDAO);
    }

    @Test
    public void studios(){
        List<Studio> studios = serviceStudio.searchStudies("a");
        Assert.assertEquals(7,studios.size());
    }

    @Test
    public void recover_Studio_From_Just_Dance() {
        Studio bar = gameService.recoverStudioFromGameByName("Just Dance 2018");
        Assert.assertEquals(bar.getName(), "Red Barrels");
    }

    @Test
    public void recover_Developers_From_Qbert() {
        List<Developer> devs = gameService.recoverAllDevelopersForGameByName("Q*bert");
        String nameDevExpected = "Markus";
        Assert.assertTrue(devs.size() == 1);
        Assert.assertEquals(nameDevExpected, devs.get(0).getName());
    }


    @After
    public void clearData(){
        dataService.eliminarDatos();
   }

}
