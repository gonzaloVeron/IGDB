import org.hibernate.Session;


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
