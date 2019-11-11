package service.interf;

import model.Game;

public interface JuegoService {
    Game searchGameByName(String nombre);
    Game searchGameById(Long id);
}
