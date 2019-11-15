package api_rest.DataClass;

import model.Game;
import model.Genre;
import model.Platform;

public class DataGameInDeveloper {
    public Long id;
    public String name;
    public Platform platform;
    public Genre genre;
    public String image;

    public DataGameInDeveloper(Game game) {
        id = game.getId();
        name = game.getName();
        platform = game.getPlatform();
        genre = game.getGenre();
        image = game.getUrlImage();
    }
}
