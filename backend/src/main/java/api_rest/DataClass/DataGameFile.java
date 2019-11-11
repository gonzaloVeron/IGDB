package api_rest.DataClass;

import model.Game;
import model.Genre;
import model.Platform;

public class DataGameFile {
    public Long id;
    public String name;
    public Genre genre;
    public Platform platform;
    public String sinopsis;
    public String urlImage;

    public DataGameFile(Game game){
        this.id = game.getId();
        this.name = game.getNombre();
        this.genre = game.getGenre();
        this.platform = game.getPlatform();
        this.sinopsis = game.getSinopsis();
        this.urlImage = game.getUrlImage();
    }
}