package dao.interf;

import model.Genre;
import model.Game;
import model.Platform;

import java.util.List;

public interface SearchDAO {
    List<Game> busquedaPorGenero(Genre genre);
    List<Game> busquedaPorPlataforma(Platform platform);
    List<Game> busquedaPorNombre(String nombre);
}
