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
    @Override
    public void updateReviewGame(Long user,Long review,Long game,String descrition,Integer stars){
         run(()->{
             User user1 = userDAO.recover(user);
             Game game1 = gameDAO.recover(game);
             Review review1 = reviewDAO.recover(review);
             review1.setDescription(descrition);
             review1.setStar(stars);
             user1.deleteReview(review);
             game1.deleteReview(review);
             user1.addReview(review1);
             game1.addReview(review1);
             userDAO.update(user1);
             gameDAO.update(game1);

        });
    }

    @Override
    public void deleteReview(Long review, Long user, Long game) {
        run(()->{
            User u = userDAO.recover(user);
            Game game1 = gameDAO.recover(game);
            u.deleteReview(review);
            game1.deleteReview(review);
            userDAO.update(u);
            gameDAO.update(game1);
        });
    }


}
