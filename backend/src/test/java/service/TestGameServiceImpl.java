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
import model.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import service.impl.*;
import service.interf.DataService;
import service.interf.GameService;
import service.interf.ServiceStudio;

import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void reviews_of_bastion(){
        List<Review> reviews = gameService.gamereviews("Bastion");
        Assert.assertEquals(2,reviews.size());
    }

    @Test
    public void average_score_of_bastion() {
        Double average = gameService.averageScoreOfAGame("Bastion");
        Assert.assertEquals(new Double(5), average);
    }

    @Test
    public void search_All(){
        List<Game> games = searchService.searchAll("",null,null);
        Assert.assertEquals(57,games.size());

    }

    @Test
    public void search_by_Name(){
        List<Game> byName = searchService.searchAll("Left 4 dead 2",null,null);
        Assert.assertEquals(1,byName.size());
        Assert.assertEquals("Left 4 dead 2",byName.get(0).getName());
    }

    @Test
    public void search_Genre(){
        List<Game> games_genre = searchService.searchAll("", Genre.Strategy,null);
        Assert.assertEquals(1,games_genre.size());
        Assert.assertEquals("league of legends",games_genre.get(0).getName());
    }

    @Test
    public void search_Platform(){
        List<Game> games_platform = searchService.searchAll("",null,Platform.PS4);
        Assert.assertEquals(15,games_platform.size());
    }

    @Test
    public void search_by_name_and_Genre(){
        List<Game> games = searchService.searchAll("league of legends",Genre.Strategy,null);
        Assert.assertEquals(1,games.size());
        Assert.assertEquals("league of legends",games.get(0).getName());

    }

    @Test
    public void search_by_name_and_Platform(){
        List<Game> games_platform = searchService.searchAll("Batman",null,Platform.PS4);
        Assert.assertEquals(2,games_platform.size());
        Assert.assertEquals("batman",games_platform.get(0).getName());
        Assert.assertEquals("Batman Arkham knight",games_platform.get(1).getName());


        List<Game> games = searchService.searchAll("God of war",null,Platform.PS4);
        System.out.println("lista test " + games.stream().map(n->n.getName()).collect(Collectors.toList()));
        Assert.assertEquals(0,games.size());


        List<Game> games1 = searchService.searchAll("God of war",null,Platform.PS2);
        Assert.assertEquals(2,games1.size());

    }

    @Test
    public void search_by_Genre_and_Platform(){
        List<Game> games_platform = searchService.searchAll("",Genre.Fighting,Platform.PS4);
        Assert.assertEquals(19,games_platform.size());

    }



    @After
    public void clearData(){
        dataService.eliminarDatos();
   }

}
