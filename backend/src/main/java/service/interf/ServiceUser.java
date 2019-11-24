package service.interf;

import model.User;

public interface ServiceUser {
    User searchUser(Long id);
    void createUser(User user);
    User searchByName(String name);
    void reviewGame(String name,String review,Integer stars,String nameGame);


}
