public class PruebaServiceImpl implements PruebaService {

    private HibernatePruebaDAO pruebaDao;

    public PruebaServiceImpl(HibernatePruebaDAO pruebaDao){
        this.pruebaDao = pruebaDao;
    }

    public void crearPrueba(Prueba prueba) {
        Runner.runInSession(() -> {
           this.pruebaDao.guardar(prueba);
           return null;
        });
    }

    public Prueba getPrueba(int idPrueba) {
        return Runner.runInSession(() -> {
            return pruebaDao.recuperar(idPrueba);
        });
    }

    public void actualizarPrueba(Prueba prueba) {
        Runner.runInSession(() -> {
            this.pruebaDao.actualizar(prueba);
            return null;
        });
    }
}
