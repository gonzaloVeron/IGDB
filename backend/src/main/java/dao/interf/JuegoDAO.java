package dao.interf;

import model.Juego;

public interface JuegoDAO {
    void guardar(Juego juego);
    Juego recuperarJuegoPorNombre(String nombre);
    void actualizar(Juego juego);

}
