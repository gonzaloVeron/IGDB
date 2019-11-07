package dao.impl;

import dao.interf.DesarrolladorDAO;
import model.Desarrollador;
import model.Juego;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.TransactionRunner;

import java.util.List;

public class HibernateDesarrollador extends HibernateDAO<Desarrollador> implements DesarrolladorDAO {

 public HibernateDesarrollador(){
     super(Desarrollador.class);
 }

    @Override
    public Desarrollador recuperarJuegoPorNombre(String nombre) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = " from Desarrollador as d"+" where d.nombre = :nombre";
        Query<Desarrollador> query = session.createQuery(hql, Desarrollador.class);
        query.setParameter("nombre", nombre);

        return this.validacion(query.uniqueResult());

    }

    @Override
    public List<Juego>juegosDesarrollados(String nombre){
       Session session = TransactionRunner.getCurrentSession();

       String hql = "select j " +
                    " from Desarrollador as d" +
                    " join d.previousStudies as dp " +
                    " join dp.juegosDesarrolladros as j" +
                    " where d.nombre = :nombre";

       Query<Juego> query = session.createQuery(hql,Juego.class);
       query.setParameter("nombre",nombre);

       return query.getResultList();


    }

}
