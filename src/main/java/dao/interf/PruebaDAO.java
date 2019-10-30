package dao.interf;

import model.Prueba;

public interface PruebaDAO {

    void guardar(Prueba prueba);

    void actualizar(Prueba bicho);

    Prueba recuperar(int idPrueba);

}
