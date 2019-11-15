package dao.impl;

import dao.interf.GameDAO;
import model.Developer;
import model.Game;
import model.Studio;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.TransactionRunner;

import java.util.List;

public class HibernateGameDAO extends HibernateDAO<Game> implements GameDAO {

    public HibernateGameDAO(){
        super(Game.class);

    }

    @Override
    public Game recoverGameByName(String nombre) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = "from Game g " + "where g.name =  :nombre";
        Query<Game> query = session.createQuery(hql, Game.class);
        query.setParameter("nombre", nombre);

        return this.validate(query.uniqueResult());
    }

    @Override
    public Studio recoverStudioFromGameByID(Long id) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = "select st " +
                "from Game g " +
                "join g.studio as st " +
                "where g.id = :id ";
        Query<Studio> query = session.createQuery(hql, Studio.class);
        query.setParameter("id", id);

        return query.uniqueResult();
    }

    @Override
    public List<Developer> recoverAllDevelopersForGameByID(Long id) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = "select dev " +
                "from Game g " +
                "join g.developers as dev " +
                "where g.id = :id ";
        Query<Developer> query = session.createQuery(hql, Developer.class);
        query.setParameter("id", id);

        return query.getResultList();
    }

    @Override
    public Studio recoverStudioFromGameByName(String name) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = "select st " +
                "from Game g " +
                "join g.studio as st " +
                "where g.name = :name ";
        Query<Studio> query = session.createQuery(hql, Studio.class);
        query.setParameter("name", name);

        return query.uniqueResult();
    }

    @Override
    public List<Developer> recoverAllDevelopersForGameByName(String name) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = "select dev " +
                "from Game g " +
                "join g.developers as dev " +
                "where g.name = :name ";
        Query<Developer> query = session.createQuery(hql, Developer.class);
        query.setParameter("name", name);

        return query.getResultList();
    }


}
