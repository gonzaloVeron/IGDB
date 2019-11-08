package dao.impl;

import dao.interf.JuegoDAO;
import model.Game;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.TransactionRunner;

public class HibernateJuegoDAO extends HibernateDAO<Game> implements JuegoDAO {

    public HibernateJuegoDAO(){
        super(Game.class);

    }

    @Override
    public Game recuperarJuegoPorNombre(String nombre) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = "from Game g " + "where g.nombre =  :nombre";
        Query<Game> query = session.createQuery(hql, Game.class);
        query.setParameter("nombre", nombre);

        return this.validacion(query.uniqueResult());
    }


}
