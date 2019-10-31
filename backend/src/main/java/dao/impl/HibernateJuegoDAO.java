package dao.impl;

import dao.interf.JuegoDAO;
import model.Juego;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.TransactionRunner;

public class HibernateJuegoDAO implements JuegoDAO {

    public HibernateJuegoDAO(){

    }

    @Override
    public void guardar(Juego juego) {
        Session session = TransactionRunner.getCurrentSession();
        session.save(juego);
    }

    @Override
    public Juego recuperarJuegoPorNombre(String nombre) {
        Session session = TransactionRunner.getCurrentSession();
        String hql = "from Juego g " + "where g.nombre =  :nombre";
        Query<Juego> query = session.createQuery(hql, Juego.class);
        query.setParameter("nombre", nombre);

        return this.validacion(query.uniqueResult());
    }

    @Override
    public Juego recuperarJuegoPorId(Long id) {
        return null;
    }

    public Juego validacion(Juego juego){
        if(juego==null){
            throw  new RuntimeException("No esta persistido en la BD");
        }else{
            return juego;
        }

    }


    /*@Override
    public Juego recuperarJuegoPorId(Long id) {
        Session session = TransactionRunner.getCurrentSession();
        return this.validacion(session.get(id));
    }
     */

    @Override
    public void actualizar(Juego juego) {
        Session session = TransactionRunner.getCurrentSession();
        session.update(juego);

    }
}
