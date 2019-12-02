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
import service.impl.DataServiceImpl;
import service.impl.GameServiceImpl;
import service.impl.ServiceUserimpl;
import service.interf.DataService;
import service.interf.GameService;
import service.interf.ServiceUser;

import java.util.List;

public class TestServiceUser {
    private DataService dataService;
    private ServiceUser serviceUser;
    private User pedro;
    private GameService gameService;
    private User jose;

    @Before
    public void setUp(){
        DataDAO dataDAO = new HibernateDataDAO();
        dataService = new DataServiceImpl(dataDAO);
        UserDAO userDAO = new HibernateUserDAO();
        serviceUser = new ServiceUserimpl(userDAO);
        dataService.crearDatosIniciales();
        pedro = new User();
        pedro.setName("Pedro");
        jose = new User();
        jose.setName("Jose");
        GameDAO gameDAO = new HibernateGameDAO();
        gameService = new GameServiceImpl(gameDAO);

    }

    @Test
    public void recovered_Pedro_by_id(){
        serviceUser.createUser(pedro);
        User pedroRecovered = serviceUser.searchUser(1L);
        Assert.assertEquals("Pedro",pedroRecovered.getName());

    }

    @Test
    public void recovered_Pedro_by_name(){
        User pedroRecovered = serviceUser.searchByName("Pedro");
        Assert.assertEquals("Pedro",pedroRecovered.getName());

    }
    @Test
    public void review_game(){
        serviceUser.createUser(pedro);
        Game gameBatman = gameService.searchGameByName("Batman Arkham knight");
        serviceUser.reviewGame(pedro.getId(),"No me gusto el juego",3,gameBatman.getId(), "LALA");

        User pedroRecoveredAgain = serviceUser.searchUser(pedro.getId());
        Game batmanRecovered = gameService.searchGameById(gameBatman.getId());

        List<Review> reviewsPedro = pedroRecoveredAgain.getMyReviews();

        Assert.assertEquals(1,reviewsPedro.size());
        Assert.assertTrue(reviewsPedro.stream().allMatch(review -> review.getUser().equals(pedroRecoveredAgain)));

        List<Review> reviewsBatman = batmanRecovered.getMyReviews();
        Assert.assertEquals(1,reviewsBatman.size());
        Assert.assertTrue(reviewsBatman.stream().allMatch(review -> review.getGame().equals(batmanRecovered)));

    }

    @Test
    public void bastion_Average(){
        serviceUser.createUser(pedro);
        Game gameBatman = gameService.searchGameByName("Batman Arkham knight");
        serviceUser.reviewGame(pedro.getId(),"No me gusto el juego",1,gameBatman.getId(), "LALA");
        serviceUser.createUser(jose);
        serviceUser.reviewGame(jose.getId(),"el juego es excelent",5,gameBatman.getId(), "LALA");

        Double average = gameService.averageScoreOfAGame("Batman Arkham knight");
        Game gameBatmanAgain = gameService.searchGameByName("Batman Arkham knight");
        List<Review> reviewsBatman = gameBatmanAgain.getMyReviews();

        Assert.assertEquals("No me gusto el juego",reviewsBatman.get(0).getDescription());
        Assert.assertEquals("el juego es excelent",reviewsBatman.get(1).getDescription());
        Assert.assertEquals(new Double(3),average);

    }


    @Test
    public void delete_review(){
        User pedro2 = serviceUser.searchByName("Pedro");
        Game gameBatman = gameService.searchGameByName("Batman Arkham knight");
        serviceUser.reviewGame(pedro2.getId(),"No me gusto el juego",1,gameBatman.getId(), "LALA");

        Game gameBatmanAgain = gameService.searchGameByName("Batman Arkham knight");
        List<Review> reviewsBatman = gameBatmanAgain.getMyReviews();
        Assert.assertEquals(1, reviewsBatman.size());
        Assert.assertEquals("No me gusto el juego",reviewsBatman.get(0).getDescription());
        Assert.assertEquals(pedro2.getId(), reviewsBatman.get(0).getUser().getId());

        User pedro3 = serviceUser.searchUser(pedro2.getId());
        List<Review> reviewsPedro = pedro3.getMyReviews();

        Assert.assertEquals(1,reviewsPedro.size());
        Assert.assertTrue(reviewsPedro.stream().allMatch(review -> review.getUser().getId().equals(pedro3.getId())));
        Assert.assertEquals(gameBatmanAgain.getId(), reviewsPedro.get(0).getGame().getId());

        Assert.assertEquals(reviewsBatman.get(0).getId(), reviewsPedro.get(0).getId());

        serviceUser.deleteReview(pedro2.getId(), gameBatman.getId());

        Game gameBatmanOnceAgain = gameService.searchGameById(gameBatman.getId());
        User pedro4 = serviceUser.searchUser(pedro2.getId());

        Assert.assertTrue(pedro4.getMyReviews().isEmpty());
        Assert.assertTrue(gameBatmanOnceAgain.getMyReviews().isEmpty());

    }
    @Test
    public void userChangePhoto(){
        User pedro2 = serviceUser.searchByName("Pedro");
        serviceUser.changeProfilePhoto(new Long(1),"No tengo Foto");
        User recoverPedro = serviceUser.searchUser(new Long(1));
        Assert.assertEquals("No tengo Foto",recoverPedro.getPhoto());
        serviceUser.changeProfilePhoto(new Long(1),"Foto no disponible");
        User recoverPedro1 = serviceUser.searchUser(new Long(1));
        Assert.assertEquals("Foto no disponible",recoverPedro1.getPhoto());

    }

    @After
    public void clear(){
        this.dataService.eliminarDatos();
    }
}
