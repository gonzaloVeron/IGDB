package dao.impl;

import dao.interf.StudyDAO;
import model.Game;
import model.Study;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.TransactionRunner;

import java.util.List;

public class HibernateStudyDAO extends HibernateDAO<Study> implements StudyDAO {
    public HibernateStudyDAO(){
        super(Study.class);
    }


    @Override
    public Study recuperarEstudioPorNombre(String name) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = " from Study as s " + " where s.nombre = :name ";
        Query<Study> query = session.createQuery(hql, Study.class);
        query.setParameter("name", name);

        return this.validacion(query.uniqueResult());
    }

    @Override
    public List<Game> gameOfStudy(String name) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = "select  sj "+
                     " from Study as s " +
                     "join s.juegosDesarrolladros as sj " +
                     " where s.nombre = :name ";
        Query<Game> query = session.createQuery(hql, Game.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Study> searchStudies(String name) {
        Session session = TransactionRunner.getCurrentSession();

        String hql = "from Study as s " +
                "where s.nombre  LIKE CONCAT('%',?1,'%')";

        return session.createQuery(hql, Study.class).setParameter(1, name).getResultList();
    }
}
