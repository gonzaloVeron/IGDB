package dao.impl;

import org.hibernate.Session;
import service.TransactionRunner;

public class HibernateDAO<T> {
    private Class<T> entityType;

    public HibernateDAO(Class<T> entityType){
        this.entityType = entityType;
    }

    public void save(T item) {
        Session session = TransactionRunner.getCurrentSession();
        session.save(item);
    }

    public T recover(Long id) {
        Session session = TransactionRunner.getCurrentSession();
        return this.validate(session.get(entityType, id));
    }

    public T validate(T tipe){
        if(tipe==null){
            throw  new RuntimeException("No esta persistido en la BD");
        }else{
            return tipe;
        }

    }

    public void update(T item){
        Session session = TransactionRunner.getCurrentSession();
        session.update(item);
    }

}
