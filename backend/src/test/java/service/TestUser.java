package service;

import dao.impl.HibernateDataDAO;
import dao.impl.HibernateUserDAO;
import dao.interf.DataDAO;
import dao.interf.UserDAO;
import model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.impl.DataServiceImpl;
import service.impl.ServiceUserimpl;
import service.interf.DataService;
import service.interf.ServiceUser;

public class TestUser {
    private DataDAO dataDAO;
    private DataService dataService;
    private UserDAO userDAO;
    private ServiceUser serviceUser;
    private User pedro;


    @Before
    public void setUp(){
        dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        userDAO = new HibernateUserDAO();
        serviceUser = new ServiceUserimpl(userDAO);
        dataService.crearDatosIniciales();
        pedro = new User();
        pedro.setName("Pedro");
    }

    @Test
    public void recovered_Pedro_by_id(){
        serviceUser.createUser(pedro);
        User pedroRecovered = serviceUser.searchUser(new Long(1));
        Assert.assertEquals("Pedro",pedroRecovered.getName());

    }

    @Test
    public void recovered_Pedro_by_name(){
        serviceUser.createUser(pedro);
        User pedroRecovered = serviceUser.searchByName("Pedro");
        Assert.assertEquals("Pedro",pedroRecovered.getName());

    }
}
