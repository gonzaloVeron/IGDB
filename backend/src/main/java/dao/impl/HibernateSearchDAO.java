package dao.impl;

import dao.interf.SearchDAO;
import model.Genero;
import model.Juego;
import model.Plataforma;
import org.hibernate.Session;
import service.TransactionRunner;

import java.util.List;

public class HibernateSearchDAO implements SearchDAO {
    @Override
    public List<Juego> busquedaPorGenero(Genero genero) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = "from Juego as j " +
                "where j.genero = :genero";

        return session.createQuery(hql,Juego.class).setParameter("genero", genero).getResultList();



    }

    @Override
    public List<Juego> busquedaPorPlataforma(Plataforma plataforma) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = "from Juego as j " +
                "where j.plataforma = :plataforma ";

        return session.createQuery(hql,Juego.class).setParameter("plataforma", plataforma).getResultList();
    }

    @Override
    public List<Juego> busquedaPorNombre(String nombre) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = "from Juego as j " +
                "where j.nombre  LIKE CONCAT('%',?1,'%')";

        return session.createQuery(hql,Juego.class).setParameter(1, nombre).getResultList();
    }
}
