package dao.impl;

import dao.interf.SearchDAO;
import model.Genre;
import model.Game;
import model.Platform;
import org.hibernate.Session;
import service.TransactionRunner;

import java.util.List;

public class HibernateSearchDAO implements SearchDAO {

    @Override
    public List<Game> busquedaPorGenero(Genre genre) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = " from Game as g " +
                     " where g.genre = :genre";

        return session.createQuery(hql, Game.class).setParameter("genre", genre).getResultList();



    }

    @Override
    public List<Game> busquedaPorPlataforma(Platform platform) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = "from Game as g " +
                "where g.platform = :platform ";

        return session.createQuery(hql, Game.class).setParameter("platform", platform).getResultList();
    }

    @Override
    public List<Game> busquedaPorNombre(String nombre) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = "from Game as g " +
                      "where g.nombre  LIKE CONCAT('%',?1,'%')";

        return session.createQuery(hql, Game.class).setParameter(1, nombre).getResultList();
    }
}
