package service.interf;

import model.Game;
import model.Review;
import model.User;

public interface ServiceUser {
    User searchUser(Long id);
    void createUser(User user);
    User searchByName(String name);
    void reviewGame(String name,String review,Integer stars,String nameGame);
    void updateReviewGame(Long user,Long review,Long game,String descrition,Integer stars);
    void deleteReview(Long review, Long user, Long game);


}
