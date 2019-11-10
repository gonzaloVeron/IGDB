package service.interf;

import model.Game;

public interface JuegoService {
    Game buscarJuego(String nombre);
    Game searchGameForId(Long id);
}
