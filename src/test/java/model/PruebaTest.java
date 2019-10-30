package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PruebaTest {
    private Prueba prueba;

    @Before
    public void setUp() throws Exception {
        prueba = new Prueba("Gonza", 23, 1);
    }
    @After
    public void tearDown() throws Exception {
        //Nada
    }

    @Test
    public void getEdad() {
        int edadDeGonza = 23;
        assertEquals(edadDeGonza, prueba.getEdad());
    }

    @Test
    public void setEdad() {
        int nuevaEdad = 99;
        prueba.setEdad(nuevaEdad);
        assertEquals(nuevaEdad, prueba.getEdad());
    }

    @Test
    public void getNombre() {
        String nombreDeGonza = "Gonza";
        assertEquals(nombreDeGonza, prueba.getNombre());
    }

    @Test
    public void setNombre() {
        String nuevoNombre = "Gwyn";
        prueba.setNombre(nuevoNombre);
        assertEquals(nuevoNombre, prueba.getNombre());
    }

    @Test
    public void getIdPrueba() {
        int idAsignada = 1;
        assertEquals(idAsignada, prueba.getIdPrueba());
    }

    @Test
    public void setIdPrueba() {
        int nuevaId = 7;
        prueba.setIdPrueba(nuevaId);
        assertEquals(nuevaId, prueba.getIdPrueba());
    }
}