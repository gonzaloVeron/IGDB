package dao.interf;

import model.Game;

public interface JuegoDAO {
    void guardar(Game game);
    Game recuperarJuegoPorNombre(String nombre);
    void actualizar(Game game);

}
