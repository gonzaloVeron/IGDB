import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PruebaServiceImplTest {

    private HibernatePruebaDAO pruebaDao;

    private PruebaServiceImpl pruebaService;

    private Prueba prueba;

    @Before
    public void setUp() throws Exception {
        pruebaDao = new HibernatePruebaDAO();
        pruebaService = new PruebaServiceImpl(pruebaDao);
        prueba = new Prueba("Gonza", 23, 1);
    }

    @After
    public void tearDown() throws Exception {
        SessionFactoryProvider.destroy();
    }

    @Test
    public void crearPrueba() {
        pruebaService.crearPrueba(prueba);
    }

    @Test
    public void getPrueba() {
        pruebaService.crearPrueba(prueba);

        int idSolicitado = 1;
        String nombreEsperado = "Gonza";

        assertEquals(nombreEsperado, pruebaService.getPrueba(idSolicitado).getNombre());
    }

    @Test
    public void actualizarPrueba() {
        pruebaService.crearPrueba(prueba);

        String nuevoNombre = "Gwyn";
        int nuevaEdad = 99;

        prueba.setNombre(nuevoNombre);
        prueba.setEdad(nuevaEdad);

        pruebaService.actualizarPrueba(prueba);

        Prueba pruebaActualizada = pruebaService.getPrueba(prueba.getIdPrueba());

        assertEquals(nuevoNombre, pruebaActualizada.getNombre());
        assertEquals(nuevaEdad, pruebaActualizada.getEdad());
    }
}