package dao.impl;

import dao.interf.UserDAO;
import model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.TransactionRunner;

public class HibernateUserDAO extends HibernateDAO<User> implements UserDAO {

    public HibernateUserDAO() {
        super(User.class);
    }

    @Override
    public User searchByName(String name) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = " from User as u " + " where u.name = :name ";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("name", name);

        return this.validate(query.uniqueResult());
    }
}
