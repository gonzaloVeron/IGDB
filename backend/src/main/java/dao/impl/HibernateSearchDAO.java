package dao.impl;

import dao.interf.SearchDAO;
import model.Genre;
import model.Game;
import model.Platform;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.TransactionRunner;

import java.util.List;

public class HibernateSearchDAO implements SearchDAO {
    
    @Override
    public List<Game> searchAll(String name, Genre genre, Platform platform) {

        Session session = TransactionRunner.getCurrentSession();

        String hql = "SELECT g from Game as g ";

        if (!name.isEmpty() || !genre.equals(Genre.Any) || !platform.equals(Platform.Any)){
            hql += "WHERE ";
        }
        if (!name.isEmpty()){
            hql += "g.name  LIKE CONCAT('%',:name,'%')";
        }
        if (!genre.equals(Genre.Any)){
            if (!name.isEmpty()){
                hql += "and ";
            }
            hql += "g.genre = :genre ";
        }
        if (!platform.equals(Platform.Any)){
            if (!name.isEmpty() || !genre.equals(Genre.Any)){
                hql += "and ";
            }
            hql += "g.platform = :platform ";
        }

        Query<Game> query = session.createQuery(hql, Game.class);
        if (!name.isEmpty()) {
            query.setParameter("name", name);
        }
        if (!genre.equals(Genre.Any)){
            query.setParameter("genre", genre);
        }
        if (!platform.equals(Platform.Any)){
            query.setParameter("platform", platform);
        }

        return query.getResultList();
    }

}
