package service.impl;

import dao.impl.HibernateGameDAO;
import dao.impl.HibernateReviewDAO;
import dao.interf.GameDAO;
import dao.interf.ReviewDAO;
import dao.interf.UserDAO;
import model.Game;
import model.Review;
import model.User;
import service.interf.ServiceUser;

import java.util.ArrayList;
import java.util.stream.Collector;

import static service.TransactionRunner.run;

public class ServiceUserimpl implements ServiceUser {
    private UserDAO userDAO;
    private GameDAO gameDAO;
    private ReviewDAO reviewDAO;


    public ServiceUserimpl(UserDAO userDAO){

        this.userDAO = userDAO;
        this.gameDAO = new HibernateGameDAO();
        this.reviewDAO = new HibernateReviewDAO();
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
    public void reviewGame(Long userID, String review, Integer stars, Long gameID) {
          run(()->{
              Review newReview = new Review();
              newReview.setDescription(review);
              newReview.setStar(stars);
              User userRecover = userDAO.recover(userID);
              userRecover.addReview(newReview);
              userDAO.update(userRecover);
              Game gameRecover = gameDAO.recover(gameID);
              gameRecover.addReview(newReview);
              gameDAO.update(gameRecover);
          });
    }



    @Override
    public void deleteReview(Long userID, Long gameID) {
        run(()->{
            User userRecover = userDAO.recover(userID);
            Game gameRecover = gameDAO.recover(gameID);
            Review review = userRecover.getMyReviews().stream().filter(review1 -> review1.getUser().equals(userRecover) && review1.getGame().equals(gameRecover))
                    .findAny()
                    .orElse(null);
            userRecover.removeReview(review);
            gameRecover.removeReview(review);
            gameDAO.update(gameRecover);
            userDAO.update(userRecover);
        });
    }


}
