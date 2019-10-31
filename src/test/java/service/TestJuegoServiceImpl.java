package service;

import dao.impl.HibernateJuegoDAO;
import dao.impl.HibernateDataDAO;
import dao.impl.HibernateSearchDAO;
import dao.interf.DataDAO;
import dao.interf.JuegoDAO;
import dao.interf.SearchDAO;
import model.Genero;
import model.Juego;
import model.Plataforma;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.DataServiceImpl;
import service.impl.JuegoServiceImpl;
import service.impl.SearchService;
import service.impl.ServiceHibernate;
import service.interf.DataService;
import service.interf.JuegoService;

import java.util.List;

public class TestJuegoServiceImpl {
    private JuegoDAO juegoDAO;
    private JuegoService juegoService;
    private DataService dataService;
    private DataDAO dataDAO;
    private Juego lol;
    private ServiceHibernate serviceHibernate;
    private SearchDAO searchDAO;
    private SearchService searchService;


    @Before
    public void setUp(){
        juegoDAO = new HibernateJuegoDAO();
        juegoService = new JuegoServiceImpl(juegoDAO);
        dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        serviceHibernate = new ServiceHibernate(juegoDAO);
        searchDAO = new HibernateSearchDAO();
        searchService = new SearchService(searchDAO);
        dataService.crearDatosIniciales();
    }

    @Test
    public void recupero_juego(){
        Assert.assertEquals("league of legends",juegoService.buscarJuego("league of legends").getNombre());
    }

    @Test
    public void lista_de_juegos_por_nombre(){

        List<Juego> juegos = searchService.busquedaPorNombre("Resident");
        Assert.assertEquals(3,juegos.size());
        Assert.assertEquals("Resident Evil",juegos.get(0).getNombre());
        Assert.assertEquals("Resident Evil 2",juegos.get(1).getNombre());
        Assert.assertEquals("Resident Evil 3", juegos.get(2).getNombre());

    }
    @Test
    public void lista_de_juegos_por_Genero(){
        List<Juego> juegos = searchService.busquedaPorgenero(Genero.Fighting);
        Assert.assertEquals(1,juegos.size());
        Assert.assertEquals("Dragon ball Z",juegos.get(0).getNombre());


    }
    @Test
    public void lista_de_juegos_por_Plataforma(){
        List<Juego> juegos = searchService.busquedaPorPlataforma(Plataforma.PS1);
        Assert.assertEquals(3,juegos.size());
        Assert.assertEquals("Resident Evil", juegos.get(0).getNombre());
        Assert.assertEquals("Resident Evil 2", juegos.get(1).getNombre());
        Assert.assertEquals("Resident Evil 3", juegos.get(2).getNombre());

    }

    @After
    public void eliminarDatos(){
        dataService.eliminarDatos();
   }

}
