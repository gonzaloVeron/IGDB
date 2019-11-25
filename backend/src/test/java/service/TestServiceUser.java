package service;

import dao.impl.HibernateDataDAO;
import dao.impl.HibernateGameDAO;
import dao.impl.HibernateUserDAO;
import dao.interf.DataDAO;
import dao.interf.GameDAO;
import dao.interf.UserDAO;
import model.Game;
import model.Review;
import model.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import service.impl.DataServiceImpl;
import service.impl.GameServiceImpl;
import service.impl.ServiceUserimpl;
import service.interf.DataService;
import service.interf.GameService;
import service.interf.ServiceUser;

import java.util.List;

public class TestServiceUser {
    private DataDAO dataDAO;
    private DataService dataService;
    private UserDAO userDAO;
    private ServiceUser serviceUser;
    private User pedro;
    private GameService gameService;
    private GameDAO gameDAO;
    private User jose;

    @Before
    public void setUp(){
        dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        userDAO = new HibernateUserDAO();
        serviceUser = new ServiceUserimpl(userDAO);
        dataService.crearDatosIniciales();
        pedro = new User();
        pedro.setName("Pedro");
        jose = new User();
        jose.setName("Jose");
        gameDAO = new HibernateGameDAO();
        gameService = new GameServiceImpl(gameDAO);

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
    @Test
    public void review_game(){
        serviceUser.createUser(pedro);
        serviceUser.reviewGame("Pedro","No me gusto el juego",3,"Batman Arkham knight");
        User pedroRecovered = serviceUser.searchByName("Pedro");
        List<Review> reviewsPedro = pedroRecovered.getMyReviews();
        Assert.assertEquals(1,reviewsPedro.size());
        Assert.assertEquals("Pedro",reviewsPedro.get(0).getNameUser());
        Game gameBatman = gameService.searchGameByName("Batman Arkham knight");
        List<Review> reviewsBatman = gameBatman.getMyReviews();
        Assert.assertEquals(1,reviewsBatman.size());
        Assert.assertEquals("Pedro",reviewsBatman.get(0).getNameUser());

    }

    @Test
    public void bastion_Average(){
        serviceUser.createUser(pedro);
        serviceUser.reviewGame("Pedro","No me gusto el juego",1,"Batman Arkham knight");
        serviceUser.createUser(jose);
        serviceUser.reviewGame("Pedro","el juego es excelent",5,"Batman Arkham knight");
        Double average = gameService.averageScoreOfAGame("Batman Arkham knight");
        Game gameBatman = gameService.searchGameByName("Batman Arkham knight");
        List<Review> reviewsBatman = gameBatman.getMyReviews();
        Assert.assertEquals("No me gusto el juego",reviewsBatman.get(0).getDescription());
        Assert.assertEquals("el juego es excelent",reviewsBatman.get(1).getDescription());
        Assert.assertEquals(new Double(3),average);

    }
    @Test
    public void bastion_reseña_cambiada(){
        serviceUser.createUser(pedro);
        serviceUser.reviewGame("Pedro","No me gusto el juego",1,"Batman Arkham knight");
        Game gameBatman = gameService.searchGameByName("Batman Arkham knight");
        List<Review> reviewsBatman = gameBatman.getMyReviews();
        Assert.assertEquals("No me gusto el juego",reviewsBatman.get(0).getDescription());
        Assert.assertEquals(new Long(3),reviewsBatman.get(0).getId());
        serviceUser.updateReviewGame(new Long(1),new Long(3),new Long(28),"Lo odie",0);
        Game gameBatmanActualizado = gameService.searchGameByName("Batman Arkham knight");
        Assert.assertEquals("Lo odie",gameBatmanActualizado.getMyReviews().get(0).getDescription());
        Assert.assertEquals(new Integer(0),gameBatmanActualizado.getMyReviews().get(0).getStar());
        User pedroActualizado = serviceUser.searchUser(new Long(1));
        Assert.assertEquals("Lo odie",pedroActualizado.getMyReviews().get(0).getDescription());
        Assert.assertEquals(new Integer(0),pedroActualizado.getMyReviews().get(0).getStar());




    }
    @Test
    public void delete_Review(){
        serviceUser.createUser(pedro);
        serviceUser.reviewGame("Pedro","No me gusto el juego",1,"Batman Arkham knight");
        serviceUser.createUser(jose);
        serviceUser.reviewGame("Pedro","el juego es excelent",5,"Batman Arkham knight");
        Double average = gameService.averageScoreOfAGame("Batman Arkham knight");
        Game gameBatman = gameService.searchGameByName("Batman Arkham knight");
        Assert.assertEquals(new Long(28),gameBatman.getId());
        List<Review> reviewsBatman = gameBatman.getMyReviews();
        Assert.assertEquals("No me gusto el juego",reviewsBatman.get(0).getDescription());
        Assert.assertEquals("el juego es excelent",reviewsBatman.get(1).getDescription());
        Assert.assertEquals(new Double(3),average);
        serviceUser.deleteReview(new Long(3), new Long(1),new Long(28));
        Game batman = gameService.searchGameById(new Long(28));
        Assert.assertEquals(1,batman.getMyReviews().size());



    }

    @After
    public void clear(){
        this.dataService.eliminarDatos();
    }
}
