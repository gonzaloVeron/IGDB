package dao.impl;

import dao.interf.UserDAO;
import model.User;

public class HibernateUserDAO extends HibernateDAO<User> implements UserDAO {

    public HibernateUserDAO() {
        super(User.class);
    }
}
