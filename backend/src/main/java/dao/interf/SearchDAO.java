package dao.interf;

import model.Genre;
import model.Game;
import model.Platform;

import java.util.List;

public interface SearchDAO {
    List<Game> searchAll(String name, Genre genre, Platform platform);
}
