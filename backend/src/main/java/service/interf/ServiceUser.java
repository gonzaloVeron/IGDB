package service.interf;

import model.User;

public interface ServiceUser {
    User searchUser(Long id);
    void createUser(User user);
    User searchByName(String name);


}
