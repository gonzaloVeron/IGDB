package dao.impl;

import dao.interf.PruebaDAO;
import model.Prueba;
import org.hibernate.Session;
import service.Runner;


public class HibernatePruebaDAO implements PruebaDAO {

    public void guardar(Prueba prueba) {
        Session session = Runner.getCurrentSession();
        session.save(prueba);
    }

    public void actualizar(Prueba prueba) {
        Session session = Runner.getCurrentSession();
        session.update(prueba);
    }

    public Prueba recuperar(int idPrueba) {
        Session session = Runner.getCurrentSession();
        return session.get(Prueba.class, idPrueba);
    }
}
