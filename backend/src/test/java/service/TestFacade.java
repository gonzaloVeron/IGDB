package service;

import dao.impl.HibernateDataDAO;
import dao.interf.DataDAO;
import model.Game;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.DataServiceImpl;
import service.impl.Facade;
import service.interf.DataService;

public class TestFacade {
    private Facade facade;
    private DataDAO dataDAO;
    private DataService dataService;



    @Before
    public void setUp(){
        facade = new Facade();
        dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        dataService.crearDatosIniciales();
    }

    @Test
    public void buscarJuegoPorNombre(){
        Game game = facade.buscarPorNombre("Resident Evil");
        Assert.assertEquals("Resident Evil", game.getNombre());
    }


    @After
    public void clear(){
        dataService.eliminarDatos();
    }







}
