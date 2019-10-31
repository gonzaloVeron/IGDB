package dao.interf;

import model.Juego;

public interface JuegoDAO {
    void guardar(Juego juego);
    Juego recuperarJuegoPorNombre(String nombre);
    Juego recuperarJuegoPorId(Long id);
    void actualizar(Juego juego);

}
