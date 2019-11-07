package service;

import dao.impl.HibernateDataDAO;
import dao.impl.HibernateDesarrollador;
import dao.interf.DataDAO;
import dao.interf.DesarrolladorDAO;
import model.Desarrollador;
import model.Juego;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.DataServiceImpl;
import service.impl.DesarrolladorServiceimpl;

import java.util.List;

public class TestDesarrollador {
    private DataServiceImpl dataService;
    private DataDAO dataDAO;
    private DesarrolladorDAO desarrolladorDAO;
    private DesarrolladorServiceimpl desarrolladorServiceimpl;


    @Before
    public void setUp(){
        desarrolladorDAO = new HibernateDesarrollador();
        desarrolladorServiceimpl = new DesarrolladorServiceimpl(desarrolladorDAO);
        dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        dataService.crearDatosIniciales();
    }

    @Test
    public void juegos_desarrollados_por_pedro(){
        List<Juego>juegosDesarrollados = desarrolladorServiceimpl.juegosDesarrollados("Pedro");
        Assert.assertEquals(0,juegosDesarrollados.size());
    }

    @Test
    public void juegos_desarrollados_por_Alan(){
        List<Juego>juegosDesarrollados = desarrolladorServiceimpl.juegosDesarrollados("Alan");
        Assert.assertEquals(1,juegosDesarrollados.size());
        Juego juegoDesarrollado = juegosDesarrollados.get(0);
        Assert.assertEquals("league of legends",juegoDesarrollado.getNombre());
    }



    @Test
    public void recupero_Pedro(){
        Desarrollador pedroRecuperado = desarrolladorServiceimpl.buscarDesarrollador("Pedro");
        Assert.assertEquals("Pedro",pedroRecuperado.getNombre());
    }

    @After
    public void eliminarDatos(){
        dataService.eliminarDatos();
    }
}
