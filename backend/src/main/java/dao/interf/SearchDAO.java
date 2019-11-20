package dao.interf;

import model.Genre;
import model.Game;
import model.Platform;

import java.util.List;

public interface SearchDAO {
    List<Game> searchByGenre(Genre genre);
    List<Game> searchByPlatform(Platform platform);
    List<Game> searchByName(String nombre);
}
