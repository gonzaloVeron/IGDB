package dao.interf;


import model.User;

public interface UserDAO {
    void save(User study);
    void update(User Study);
    User recover(Long id);
}
