package service.impl;

import dao.impl.HibernateGameDAO;
import dao.interf.GameDAO;
import dao.interf.UserDAO;
import model.Game;
import model.Review;
import model.User;
import service.interf.ServiceUser;
import static service.TransactionRunner.run;

public class ServiceUserimpl implements ServiceUser {
    private UserDAO userDAO;
    private GameDAO gameDAO;


    public ServiceUserimpl(UserDAO userDAO){

        this.userDAO = userDAO;
        this.gameDAO = new HibernateGameDAO();
    }


    @Override
    public User searchUser(Long id) {
        return run(()-> {return this.userDAO.recover(id);});
    }

    //Lo guarda en la Base
    @Override
    public void createUser(User user) {
        run(()->{this.userDAO.save(user);});

    }

    @Override
    public User searchByName(String name) {
        return run(()->{return this.userDAO.searchByName(name);});
    }

    @Override
    public void reviewGame(String name,String review,Integer stars,String nameGame) {
          run(()->{
              Review newReview = new Review();
              newReview.setDescription(review);
              newReview.setStar(stars);
              newReview.setNameUser(name);
              newReview.setNameGame(nameGame);
              User userRecover = userDAO.searchByName(name);
              userRecover.addReview(newReview);
              userDAO.update(userRecover);
              Game gameRecover = gameDAO.recoverGameByName(nameGame);
              gameRecover.addReview(newReview);
              gameDAO.update(gameRecover);
          });
    }
}
