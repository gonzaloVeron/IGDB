package dao.impl;

import dao.interf.JuegoDAO;
import model.Juego;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.TransactionRunner;

public class HibernateJuegoDAO extends HibernateDAO<Juego> implements JuegoDAO {

    public HibernateJuegoDAO(){
        super(Juego.class);

    }

    @Override
    public Juego recuperarJuegoPorNombre(String nombre) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = "from Juego g " + "where g.nombre =  :nombre";
        Query<Juego> query = session.createQuery(hql, Juego.class);
        query.setParameter("nombre", nombre);

        return this.validacion(query.uniqueResult());
    }


}
