package dao.impl;

import dao.interf.DesarrolladorDAO;
import model.Developer;
import model.Game;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.TransactionRunner;

import java.util.List;

public class HibernateDesarrollador extends HibernateDAO<Developer> implements DesarrolladorDAO {

 public HibernateDesarrollador(){
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

}
