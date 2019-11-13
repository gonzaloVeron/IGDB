package service;

import dao.impl.HibernateDataDAO;
import dao.impl.HibernateDeveloper;
import dao.interf.DataDAO;
import dao.interf.DeveloperDAO;
import model.Developer;
import model.Game;
import model.Studio;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.DataServiceImpl;
import service.impl.DeveloperServiceimpl;

import java.util.List;
import java.util.stream.Collectors;

public class TestDeveloper {
    private DataServiceImpl dataService;
    private DataDAO dataDAO;
    private DeveloperDAO developerDAO;
    private DeveloperServiceimpl developerServiceimpl;


    @Before
    public void setUp() {
        developerDAO = new HibernateDeveloper();
        developerServiceimpl = new DeveloperServiceimpl(developerDAO);
        dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        dataService.crearDatosIniciales();
    }
    @Test
    public void developer_John(){
        Developer hideo = developerServiceimpl.searchDeveloperById(new Long(1));
        Assert.assertEquals("John",hideo.getName());
        Assert.assertEquals("Romero",hideo.getLastName());

    }
    @Test
    public void kojima_games(){
        Developer hideo = developerServiceimpl.searchDeveloperById(new Long(1));
        Assert.assertEquals("John",hideo.getName());
        Assert.assertEquals("Romero",hideo.getLastName());
        List<Game> games = hideo.getGames();
        Assert.assertEquals(4,games.size());

        System.out.println(hideo.getStudies().stream().map(s -> s.getId()).collect(Collectors.toList()));
    }

    @Test
    public void two_developers_John(){
        List<Developer> developers = developerServiceimpl.searchDeveloper("John");
        Assert.assertEquals(2,developers.size());
        Developer developer1 = developers.get(0);
        Assert.assertEquals("John",developer1.getName());
        Developer developer2 = developers.get(1);
        Assert.assertEquals("John",developer2.getName());
        Assert.assertTrue(!developer1.getLastName().equals(developer2.getLastName()));

    }
    @Test
    public void _John_job_in_nintendo(){
        Studio job = developerServiceimpl.currentJob("John","Romero");
        Assert.assertEquals("Nintendo",job.getName());
    }

    @Test
    public void developer_Hideo_Kojima_can_return_his_studios(){
        Developer hideo = developerServiceimpl.searchDeveloperById(new Long(1));
        List<Studio> prv = hideo.getStudies();
        List<Studio> crr = hideo.getCurrentStudios();
    }


    @After
    public void clear(){
        dataService.eliminarDatos();
    }
}