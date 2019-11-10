package dao.impl;

import dao.interf.DeveloperDAO;
import model.Developer;
import model.Game;
import model.Study;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.TransactionRunner;

import java.util.List;

public class HibernateDeveloper extends HibernateDAO<Developer> implements DeveloperDAO {

 public HibernateDeveloper(){
     super(Developer.class);
 }

    @Override
    public Developer recuperarJuegoPorNombre(String nombre) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = " from Developer as d "+" where d.name = :nombre";
        Query<Developer> query = session.createQuery(hql, Developer.class);
        query.setParameter("nombre", nombre);

        return this.validacion(query.uniqueResult());

    }

    @Override
    public List<Game>juegosDesarrollados(String nombre){
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
    public Study currentJob(String name) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = " select s " +
                     " from Study as s " +
                     " join s.desarrolladoresActuales as sd" +
                     " where sd.name = :name ";


        Query<Study> query = session.createQuery(hql, Study.class);
        query.setParameter("name",name);

        return query.getSingleResult();
    }


    @Override
    public List<Developer> busquedaPorNombre(String name) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = " from Developer as d " +
                " where d.name  LIKE CONCAT('%',?1,'%')";

        return session.createQuery(hql, Developer.class).setParameter(1, name).getResultList();
    }


}
