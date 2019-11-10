package service;

import dao.impl.HibernateDataDAO;
import dao.impl.HibernateDeveloper;
import dao.interf.DataDAO;
import dao.interf.DeveloperDAO;
import model.Developer;
import model.Game;
import model.Study;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.DataServiceImpl;
import service.impl.DeveloperServiceimpl;

import java.util.List;

public class TestDeveloper {
    private DataServiceImpl dataService;
    private DataDAO dataDAO;
    private DeveloperDAO developerDAO;
    private DeveloperServiceimpl developerServiceimpl;


    @Before
    public void setUp(){
        developerDAO = new HibernateDeveloper();
        developerServiceimpl = new DeveloperServiceimpl(developerDAO);
        dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        dataService.crearDatosIniciales();
    }

    @Test
    public void juegos_desarrollados_por_pedro(){
        List<Game>juegosDesarrollados = developerServiceimpl.juegosDesarrollados("Pedro");
        Assert.assertEquals(0,juegosDesarrollados.size());
    }

    @Test
    public void juegos_desarrollados_por_Alan(){
        List<Game>juegosDesarrollados = developerServiceimpl.juegosDesarrollados("Alan");
        Assert.assertEquals(1,juegosDesarrollados.size());
        Game gameDesarrollado = juegosDesarrollados.get(0);
        Assert.assertEquals("league of legends", gameDesarrollado.getNombre());
    }



    @Test
    public void recupero_Pedro(){
        Developer pedroRecuperado = developerServiceimpl.buscarDesarrollador("Pedro");
        Assert.assertEquals("Pedro",pedroRecuperado.getName());
    }

//    @Test
//    public void trabaja_en_riot(){
//        Study riot = developerServiceimpl.currentJob("Alan");
//        Assert.assertEquals("Riot",riot.getNombre());
//    }

    @After
    public void eliminarDatos(){
        dataService.eliminarDatos();
    }
}
