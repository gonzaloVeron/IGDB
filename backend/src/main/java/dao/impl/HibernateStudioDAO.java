package dao.impl;

import dao.interf.StudioDAO;
import model.Game;
import model.Studio;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.TransactionRunner;

import java.util.List;

public class HibernateStudioDAO extends HibernateDAO<Studio> implements StudioDAO {
    public HibernateStudioDAO(){
        super(Studio.class);
    }


    @Override
    public Studio recoverStudioByName(String name) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = " from Studio as s " + " where s.name = :name ";
        Query<Studio> query = session.createQuery(hql, Studio.class);
        query.setParameter("name", name);

        return this.validate(query.uniqueResult());
    }

    @Override
    public List<Game> gameOfStudio(String name) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = "select  sj "+
                     " from Studio as s " +
                     "join s.developedGames as sj " +
                     " where s.name = :name ";
        Query<Game> query = session.createQuery(hql, Game.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Studio> searchStudies(String name) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = "from Studio as s " +
                "where s.name  LIKE CONCAT('%',?1,'%')";

        return session.createQuery(hql, Studio.class).setParameter(1, name).getResultList();
    }
}
