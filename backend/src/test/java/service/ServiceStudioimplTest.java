package service;

import dao.impl.HibernateDataDAO;
import dao.impl.HibernateStudioDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.impl.DataServiceImpl;
import service.impl.ServiceStudioimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ServiceStudioimplTest {

    private ServiceStudioimpl studioService;

    private HibernateStudioDAO dao;

    private DataServiceImpl dataService;

    private HibernateDataDAO dataDao;

    @Before
    public void setUp() throws Exception {
        dao = new HibernateStudioDAO();
        dataDao = new HibernateDataDAO();

        studioService = new ServiceStudioimpl(dao);
        dataService = new DataServiceImpl(dataDao);

        dataService.crearDatosIniciales();
    }

    @After
    public void tearDown() throws Exception {
        dataService.eliminarDatos();
    }

    @Test
    public void searchStudio() {
        assertEquals("Valve", studioService.searchStudio("Valve").getName());
    }

    @Test
    public void searchStudioById() {
        assertEquals("Valve", studioService.searchStudioById(new Long(7)).getName());
    }

    @Test
    public void gamesOfStudio() {
        List<String> nombresDeJuegosDeValve = new ArrayList<>();
        nombresDeJuegosDeValve.add("Left 4 dead");
        nombresDeJuegosDeValve.add("Left 4 dead 2");
        nombresDeJuegosDeValve.add("Half life");
        nombresDeJuegosDeValve.add("Half life 2");

        assertEquals(nombresDeJuegosDeValve, studioService.gamesOfStudio("Valve").stream().map(g -> g.getName()).collect(Collectors.toList()));
    }

    @Test
    public void searchStudies() {
        List<String> nombreDeEstudiosBuscados = new ArrayList<>();
        nombreDeEstudiosBuscados.add("Nintendo");
        nombreDeEstudiosBuscados.add("SCE Santa Monica Studio");
        nombreDeEstudiosBuscados.add("Generation");
        nombreDeEstudiosBuscados.add("Activision");
        nombreDeEstudiosBuscados.add("EaDigitalIllusionsCe");

        assertEquals(nombreDeEstudiosBuscados, studioService.searchStudies("i").stream().map(g -> g.getName()).collect(Collectors.toList()));
    }
}