package service.interf;

import model.Prueba;

public interface PruebaService {

    void crearPrueba(Prueba prueba);

    Prueba getPrueba(int idPrueba);

    void actualizarPrueba(Prueba prueba);

}

