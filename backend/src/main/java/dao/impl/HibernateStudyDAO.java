package dao.impl;

import dao.interf.StudyDAO;
import model.Study;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.TransactionRunner;

public class HibernateStudyDAO extends HibernateDAO<Study> implements StudyDAO {
    public HibernateStudyDAO(){
        super(Study.class);
    }


    @Override
    public Study recuperarJuegoPorNombre(String name) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = " from Study as s " + " where s.nombre = :name ";
        Query<Study> query = session.createQuery(hql, Study.class);
        query.setParameter("name", name);

        return this.validacion(query.uniqueResult());
    }
}
