package dao.impl;

import dao.interf.DeveloperDAO;
import model.Developer;
import model.Game;
import model.Studio;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.TransactionRunner;

import java.util.List;

public class HibernateDeveloper extends HibernateDAO<Developer> implements DeveloperDAO {

 public HibernateDeveloper(){
     super(Developer.class);
 }

    @Override
    public Developer recoverGameByName(String nombre) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = " from Developer as d "+" where d.name = :nombre";
        Query<Developer> query = session.createQuery(hql, Developer.class);
        query.setParameter("nombre", nombre);

        return this.validate(query.uniqueResult());

    }

    @Override
    public List<Game> developedGames(String nombre){
       Session session = TransactionRunner.getCurrentSession();

       String hql = "select dg " +
                    " from Developer as d " +
                    " join d.games as dg " +
                    " where d.name = :nombre ";

       Query<Game> query = session.createQuery(hql, Game.class);
       query.setParameter("nombre",nombre);

       return query.getResultList();


    }

    @Override
    public Studio currentJob(String name, String lastName) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = " select s " +
                     " from Studio as s " +
                     " join s.currentDevelopers as sd" +
                     " where sd.name = :name " +
                     " and sd.lastName = :lastName";


        Query<Studio> query = session.createQuery(hql, Studio.class);
        query.setParameter("name",name);
        query.setParameter("lastName",lastName);

        return query.setMaxResults(1).uniqueResult();
    }


    @Override
    public List<Developer> searchDeveloper(String name) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = " from Developer as d " +
                " where d.name  LIKE CONCAT('%',?1,'%')" +
                " or d.lastName  LIKE CONCAT('%',?1,'%')";


        return session.createQuery(hql, Developer.class).setParameter(1, name).getResultList();
    }


}
