package dao.impl;

import dao.interf.SearchDAO;
import model.Genre;
import model.Game;
import model.Platform;
import org.hibernate.Session;
import service.TransactionRunner;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

public class HibernateSearchDAO implements SearchDAO {

    @Override
    public List<Game> searchAll(String name, Genre genre, Platform platform) {

        List<Game> games = new ArrayList<>();

        if (name == "" && genre == null && platform == null) {
            Session session = TransactionRunner.getCurrentSession();

            String hql = "SELECT g from Game as g ";

            return session.createQuery(hql, Game.class).getResultList();
        }

        if (name != "") {
            games.addAll(this.searchByName(name));
        }
        if (genre != null) {
            games.addAll(this.searchByGenre(genre));
        }
        if (platform != null) {
            games.addAll(this.searchByPlatform(platform));
        }

        return games;
    }

    @Override
    public List<Game> searchByGenre(Genre genre) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = " from Game as g " +
                     " where g.genre = :genre";

        return session.createQuery(hql, Game.class).setParameter("genre", genre).getResultList();



    }

    @Override
    public List<Game> searchByPlatform(Platform platform) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = "from Game as g " +
                "where g.platform = :platform ";

        return session.createQuery(hql, Game.class).setParameter("platform", platform).getResultList();
    }

    @Override
    public List<Game> searchByName(String nombre) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = "from Game as g " +
                      "where g.name  LIKE CONCAT('%',?1,'%')";

        return session.createQuery(hql, Game.class).setParameter(1, nombre).getResultList();
    }
}
