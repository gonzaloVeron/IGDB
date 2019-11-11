package api_rest.DataClass;

import model.Genre;
import model.Platform;

public class DataGameSearch {
    public Long id;
    public String name;
    public Genre genre;
    public Platform platform;
    public String sinopsis;

    public DataGameSearch(Long id, String name, Genre genre, Platform platform, String sinopsis){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.platform = platform;
        this.sinopsis = sinopsis;
    }
}
