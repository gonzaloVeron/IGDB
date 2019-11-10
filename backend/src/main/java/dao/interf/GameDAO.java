package dao.interf;

import model.Game;

public interface GameDAO {
    void guardar(Game game);
    Game recuperarJuegoPorNombre(String nombre);
    void actualizar(Game game);

}
