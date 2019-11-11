package api_rest.DataClass;

import model.Developer;
import model.Game;
import model.Studio;

import java.util.Date;
import java.util.List;

public class DataStudioSearch {
    public Long id;
    public String name;
    public String imageUrl;
    public Date foundationDate;
    public Boolean isActive;
    public List<Developer> historicalDevelopers;
    public List<Developer> actualDevs;
    public List<Game> gamesDeveloped;

    public DataStudioSearch(Long id, String name, String imageUrl, Date foundationDate, Boolean isActive, List<Developer> historicalDevelopers, List<Game> gamesDeveloped, List<Developer> actualDevs){
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.foundationDate = foundationDate;
        this.isActive = isActive;
        this.historicalDevelopers = historicalDevelopers;
        this.gamesDeveloped = gamesDeveloped;
        this.actualDevs = actualDevs;
    }
}
