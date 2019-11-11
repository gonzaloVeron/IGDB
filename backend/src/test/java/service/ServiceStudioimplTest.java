package service;

import dao.impl.HibernateDataDAO;
import dao.impl.HibernateStudioDAO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.impl.DataServiceImpl;
import service.impl.ServiceStudioimpl;

import javax.sound.midi.SysexMessage;
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
        assertEquals("Valve", studioService.searchStudio("Valve").getNombre());
    }

    @Test
    public void searchStudioById() {
        assertEquals("Valve", studioService.searchStudioById(new Long(5)).getNombre());
    }

    @Test
    public void gamesOfStudio() {
        List<String> nombresDeJuegosDeValve = new ArrayList<>();
        nombresDeJuegosDeValve.add("Left of dead");
        nombresDeJuegosDeValve.add("Left of dead 2");
        nombresDeJuegosDeValve.add("Half life");
        nombresDeJuegosDeValve.add("Half life 2");

        assertEquals(nombresDeJuegosDeValve, studioService.gamesOfStudio("Valve").stream().map(g -> g.getNombre()).collect(Collectors.toList()));
    }

    @Test
    public void searchStudies() {
        List<String> nombreDeEstudiosBuscados = new ArrayList<>();
        nombreDeEstudiosBuscados.add("Nintendo");
        nombreDeEstudiosBuscados.add("SCE Santa Monica Studio");
        nombreDeEstudiosBuscados.add("Activision");
        nombreDeEstudiosBuscados.add("EaDigitalIllusionsCe");
        nombreDeEstudiosBuscados.add("Generation");

        assertEquals(nombreDeEstudiosBuscados, studioService.searchStudies("i").stream().map(g -> g.getNombre()).collect(Collectors.toList()));
    }
}