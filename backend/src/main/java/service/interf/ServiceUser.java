package service.interf;

import model.Review;
import model.User;

public interface ServiceUser {
    User searchUser(Long id);
    void createUser(User user);
    User searchByName(String name);
    void reviewGame(Long userID,String review,Integer stars,Long gameID);
    void deleteReview(Long userID, Long gameID);
    void updateReview(Long userID,Long gameID,String description,Integer stars);
}
