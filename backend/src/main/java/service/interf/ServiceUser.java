package service.interf;


import model.User;

public interface ServiceUser {
    User searchUser(Long id);
    void createUser(User user);
    User searchByName(String name);
    void reviewGame(Long userID,String review,Integer stars,Long gameID);
    void deleteReview(Long userID, Long gameID);

}
