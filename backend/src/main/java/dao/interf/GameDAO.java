package dao.interf;

import model.Game;

public interface GameDAO {
    void save(Game game);
    Game recoverGameByName(String nombre);
    void update(Game game);
    Game recover(Long id);

}
