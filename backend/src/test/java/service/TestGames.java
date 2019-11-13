package service;

import dao.impl.HibernateDataDAO;
import dao.impl.HibernateGameDAO;
import dao.impl.HibernateStudioDAO;
import dao.interf.DataDAO;
import dao.interf.GameDAO;
import dao.interf.StudioDAO;
import model.Game;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.DataServiceImpl;
import service.impl.GameServiceImpl;
import service.impl.ServiceStudioimpl;
import service.interf.DataService;
import service.interf.GameService;
import service.interf.ServiceStudio;

import java.util.List;

public class TestGames {
    private DataDAO dataDAO;
    private DataService dataService;
    //Servicio juego
    private GameDAO gameDAO;
    private GameService gameService;
    //Service estudio
    private StudioDAO studioDAO;
    private ServiceStudio serviceStudyimpl;


    @Before
    public void setUp(){
        dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        gameDAO = new HibernateGameDAO();
        gameService = new GameServiceImpl(gameDAO);
        studioDAO = new HibernateStudioDAO();
        serviceStudyimpl = new ServiceStudioimpl(studioDAO);
        dataService.crearDatosIniciales();


    }
    @Test
    public void create_data(){
        Game mario = gameService.searchGameByName("Super Mario Bros Deluxe");
        Assert.assertEquals("Super Mario Bros Deluxe",mario.getName());
        Game sonic = gameService.searchGameByName("Sonic Forces");
        Assert.assertEquals("Sonic Forces",sonic.getName());
        Game fifa = gameService.searchGameByName("FiFA 2019");
        Assert.assertEquals("FiFA 2019",fifa.getName());
        Game sonicMania = gameService.searchGameByName("Sonic Mania");
        Assert.assertEquals("Sonic Mania",sonicMania.getName());
        Game lengendOfZelda = gameService.searchGameByName("Legend Of Zelda");
        Assert.assertEquals("Legend Of Zelda",lengendOfZelda.getName());
        Game luigiMansion = gameService.searchGameByName("Luigi Mansion");
        Assert.assertEquals("Luigi Mansion",luigiMansion.getName());
        Game tetris = gameService.searchGameByName("Tetris");
        Assert.assertEquals("Tetris",tetris.getName());
    }
    @Test
    public void nintendo_games(){
        List<Game> juegosDeNintendo = serviceStudyimpl.gamesOfStudio("Nintendo");
        Assert.assertEquals(7,juegosDeNintendo.size());
        Game mario = juegosDeNintendo.get(0);
        Assert.assertEquals("Super Mario Bros Deluxe",mario.getName());
        Game sonic = juegosDeNintendo.get(1);
        Assert.assertEquals("Sonic Mania",sonic.getName());
        Game fifa = juegosDeNintendo.get(2);
        Assert.assertEquals("Sonic Forces",fifa.getName());
        Game sonicMania = juegosDeNintendo.get(3);
        Assert.assertEquals("FiFA 2019",sonicMania.getName());
        Game lengendOfZelda = juegosDeNintendo.get(4);;
        Assert.assertEquals("Legend Of Zelda",lengendOfZelda.getName());
        Game luigiMansion = juegosDeNintendo.get(5);
        Assert.assertEquals("Luigi Mansion",luigiMansion.getName());
        Game tetris = juegosDeNintendo.get(6);
        Assert.assertEquals("Tetris",tetris.getName());


    }

    @Test
    public void red_Barrels_games(){
        List<Game> juegosDeredBarrels = serviceStudyimpl.gamesOfStudio("Red Barrels");
        Assert.assertEquals(4,juegosDeredBarrels.size());
        Game outlast = juegosDeredBarrels.get(0);
        Assert.assertEquals("Outlast",outlast.getName());
        Game outlast2 = juegosDeredBarrels.get(1);
        Assert.assertEquals("Outlast 2",outlast2.getName());
        Game outlastWhistleblawer = juegosDeredBarrels.get(2);
        Assert.assertEquals("Outlast Whistleblower",outlastWhistleblawer.getName());
        Game justDance = juegosDeredBarrels.get(3);
        Assert.assertEquals("Just Dance 2018", justDance.getName());

    }
    @Test
    public void activision_games(){
        List<Game> juegosDeActivision = serviceStudyimpl.gamesOfStudio("Activision");
        Assert.assertEquals(4,juegosDeActivision.size());
        Game callofdutyblackops = juegosDeActivision.get(0);
        Assert.assertEquals("Call of duty black ops",callofdutyblackops.getName());
        Game callofdutyblackops2 = juegosDeActivision.get(1);
        Assert.assertEquals("Call of duty black ops 2",callofdutyblackops2.getName());
        Game callofdutyblackops3 = juegosDeActivision.get(2);
        Assert.assertEquals("Call of duty black ops 3",callofdutyblackops3.getName());
        Game callofdutyblackops4 = juegosDeActivision.get(3);
        Assert.assertEquals("Call of duty black ops 4",callofdutyblackops4.getName());


    }
    @Test
    public void valve_games(){
        List<Game>juegosDeValve = serviceStudyimpl.gamesOfStudio("Valve");
        Assert.assertEquals(4,juegosDeValve.size());
        Game leftOfDead = juegosDeValve.get(0);
        Assert.assertEquals("Left 4 dead",leftOfDead.getName());
        Game leftOfDead2 = juegosDeValve.get(1);
        Assert.assertEquals("Left 4 dead 2",leftOfDead2.getName());
        Game halfLife = juegosDeValve.get(2);
        Assert.assertEquals("Half life",halfLife.getName());
        Game halfLife2 = juegosDeValve.get(3);
        Assert.assertEquals("Half life 2",halfLife2.getName());

    }
    @Test
    public void eaDigitalIllusionsCe_games(){
        List<Game>juegosdeeaDigitalIllusionsCe= serviceStudyimpl.gamesOfStudio("EaDigitalIllusionsCe");
        Assert.assertEquals(5,juegosdeeaDigitalIllusionsCe.size());
    }

    @Test
    public void capcom_games(){
        List<Game>juegosDeCapcom = serviceStudyimpl.gamesOfStudio("Capcom");
        Assert.assertEquals(10,juegosDeCapcom.size());
    }
    @Test
    public void sCESantaMonicaStudio_games(){
        List<Game>juegossCESantaMonicaStudio = serviceStudyimpl.gamesOfStudio("SCE Santa Monica Studio");
        Assert.assertEquals(4,juegossCESantaMonicaStudio.size());
    }
    @Test
    public void generation_games(){
        List<Game>juegosdeGeneration = serviceStudyimpl.gamesOfStudio("Generation");
        Assert.assertEquals(18,juegosdeGeneration.size());
    }

    @After
    public void clearData(){
        dataService.eliminarDatos();
    }




}
