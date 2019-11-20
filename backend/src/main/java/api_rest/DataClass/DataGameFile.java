package api_rest.DataClass;

import model.*;

import java.util.List;
import java.util.stream.Collectors;

public class DataGameFile {
    public Long id;
    public String name;
    public Genre genre;
    public Platform platform;
    public String sinopsis;
    public String urlImage;
    public List<String> videos;
    public List<String> images;
    public List<DataDeveloperInGame> devs;
    public DataStudioInGame studio;

    public DataGameFile(Game game){
        this.id = game.getId();
        this.name = game.getName();
        this.genre = game.getGenre();
        this.platform = game.getPlatform();
        this.sinopsis = game.getSinopsis();
        this.urlImage = game.getUrlImage();
        this.videos = game.getVideos();
        this.images = game.getImages();
        this.devs = game.getDevelopers().stream().map(dev -> new DataDeveloperInGame(dev.getId(), dev.getName(), dev.getLastName(), dev.getUrlPhoto())).collect(Collectors.toList());
        this.studio = new DataStudioInGame(game.getStudio());
    }
}
