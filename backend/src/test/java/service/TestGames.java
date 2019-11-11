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
import service.interf.JuegoService;
import service.interf.ServiceStudio;

import java.util.List;

public class TestGames {
    private DataDAO dataDAO;
    private DataService dataService;
    //Servicio juego
    private GameDAO gameDAO;
    private JuegoService juegoService;
    //Service estudio
    private StudioDAO studioDAO;
    private ServiceStudio serviceStudyimpl;


    @Before
    public void setUp(){
        dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        gameDAO = new HibernateGameDAO();
        juegoService = new GameServiceImpl(gameDAO);
        studioDAO = new HibernateStudioDAO();
        serviceStudyimpl = new ServiceStudioimpl(studioDAO);
        dataService.crearDatosIniciales();


    }
    @Test
    public void crear_datos(){
        Game mario = juegoService.searchGameByName("Super Mario Bros Deluxe");
        Assert.assertEquals("Super Mario Bros Deluxe",mario.getNombre());
        Game sonic = juegoService.searchGameByName("Sonic Forces");
        Assert.assertEquals("Sonic Forces",sonic.getNombre());
        Game fifa = juegoService.searchGameByName("FiFA 2019");
        Assert.assertEquals("FiFA 2019",fifa.getNombre());
        Game sonicMania = juegoService.searchGameByName("Sonic Mania");
        Assert.assertEquals("Sonic Mania",sonicMania.getNombre());
        Game lengendOfZelda = juegoService.searchGameByName("Lengend Of Zelda");
        Assert.assertEquals("Lengend Of Zelda",lengendOfZelda.getNombre());
        Game luigiMansion = juegoService.searchGameByName("Luigi Mansion");
        Assert.assertEquals("Luigi Mansion",luigiMansion.getNombre());
        Game tetris = juegoService.searchGameByName("Tetris");
        Assert.assertEquals("Tetris",tetris.getNombre());
    }
    @Test
    public void juegos_de_nintendo(){
        List<Game> juegosDeNintendo = serviceStudyimpl.gamesOfStudio("Nintendo");
        Assert.assertEquals(7,juegosDeNintendo.size());
        Game mario = juegosDeNintendo.get(0);
        Assert.assertEquals("Super Mario Bros Deluxe",mario.getNombre());
        Game sonic = juegosDeNintendo.get(1);
        Assert.assertEquals("Sonic Forces",sonic.getNombre());
        Game fifa = juegosDeNintendo.get(2);
        Assert.assertEquals("FiFA 2019",fifa.getNombre());
        Game sonicMania = juegosDeNintendo.get(3);
        Assert.assertEquals("Sonic Mania",sonicMania.getNombre());
        Game lengendOfZelda = juegosDeNintendo.get(4);;
        Assert.assertEquals("Lengend Of Zelda",lengendOfZelda.getNombre());
        Game luigiMansion = juegosDeNintendo.get(5);
        Assert.assertEquals("Luigi Mansion",luigiMansion.getNombre());
        Game tetris = juegosDeNintendo.get(6);
        Assert.assertEquals("Tetris",tetris.getNombre());


    }

    @Test
    public void juegos_de_red_Barrels(){
        List<Game> juegosDeredBarrels = serviceStudyimpl.gamesOfStudio("Red Barrels");
        Assert.assertEquals(3,juegosDeredBarrels.size());
        Game outlast = juegosDeredBarrels.get(0);
        Assert.assertEquals("Outlast",outlast.getNombre());
        Game outlast2 = juegosDeredBarrels.get(1);
        Assert.assertEquals("Outlast 2",outlast2.getNombre());
        Game outlastWhistleblawer = juegosDeredBarrels.get(2);
        Assert.assertEquals("Outlast Whistleblower",outlastWhistleblawer.getNombre());

    }
    @Test
    public void juegos_de_activision(){
        List<Game> juegosDeActivision = serviceStudyimpl.gamesOfStudio("Activision");
        Assert.assertEquals(4,juegosDeActivision.size());
        Game callofdutyblackops = juegosDeActivision.get(0);
        Assert.assertEquals("Call of duty black ops",callofdutyblackops.getNombre());
        Game callofdutyblackops2 = juegosDeActivision.get(1);
        Assert.assertEquals("Call of duty black ops 2",callofdutyblackops2.getNombre());
        Game callofdutyblackops3 = juegosDeActivision.get(2);
        Assert.assertEquals("Call of duty black ops 3",callofdutyblackops3.getNombre());
        Game callofdutyblackops4 = juegosDeActivision.get(3);
        Assert.assertEquals("Call of duty black ops 4",callofdutyblackops4.getNombre());


    }
    @Test
    public void juegos_de_valve(){
        List<Game>juegosDeValve = serviceStudyimpl.gamesOfStudio("Valve");
        Assert.assertEquals(4,juegosDeValve.size());
        Game leftOfDead = juegosDeValve.get(0);
        Assert.assertEquals("Left of dead",leftOfDead.getNombre());
        Game leftOfDead2 = juegosDeValve.get(1);
        Assert.assertEquals("Left of dead 2",leftOfDead2.getNombre());
        Game halfLife = juegosDeValve.get(2);
        Assert.assertEquals("Half life",halfLife.getNombre());
        Game halfLife2 = juegosDeValve.get(3);
        Assert.assertEquals("Half life 2",halfLife2.getNombre());

    }
    @Test
    public void juegos_de_eaDigitalIllusionsCe(){
        List<Game>juegosdeeaDigitalIllusionsCe= serviceStudyimpl.gamesOfStudio("EaDigitalIllusionsCe");
        Assert.assertEquals(5,juegosdeeaDigitalIllusionsCe.size());
    }

    @Test
    public void juegos_de_capcom(){
        List<Game>juegosDeCapcom = serviceStudyimpl.gamesOfStudio("Capcom");
        Assert.assertEquals(10,juegosDeCapcom.size());
    }
    @Test
    public void juegos_de_sCESantaMonicaStudio(){
        List<Game>juegossCESantaMonicaStudio = serviceStudyimpl.gamesOfStudio("SCE Santa Monica Studio");
        Assert.assertEquals(4,juegossCESantaMonicaStudio.size());
    }
    @Test
    public void juegos_de_generation(){
        List<Game>juegosdeGeneration = serviceStudyimpl.gamesOfStudio("Generation");
        Assert.assertEquals(18,juegosdeGeneration.size());
    }

    @After
    public void eliminarDatos(){
        dataService.eliminarDatos();
    }




}
