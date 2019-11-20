package api_rest.DataClass;

import model.Game;
import model.Genre;
import model.Platform;

public class DataGameSearch {
    public Long id;
    public String name;
    public Genre genre;
    public Platform platform;
    public String urlImage;

    public DataGameSearch(Game game){
        this.id = game.getId();
        this.name = game.getName();
        this.genre = game.getGenre();
        this.platform = game.getPlatform();
        this.urlImage = game.getUrlImage();
    }

}
