package api_rest.DataClass;

import model.Developer;
import model.Game;
import model.Studio;
import org.mockito.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataStudioFile {
    public Long id;
    public String name;
    public String imageUrl;
    public String foundationDate;
    public String isActive;
    public List<DataDeveloperInStudio> historicalDevelopers;
    public List<DataDeveloperInStudio> actualDevs;
    public List<DataGameInDeveloper> gamesDeveloped;

    public DataStudioFile(Studio studio){
        this.id = studio.getId();
        this.name = studio.getNombre();
        this.imageUrl = studio.getPortada();
        this.foundationDate = studio.getFechaDeFundacion().toString();
        this.isActive = studio.getEstaActivo();
        this.historicalDevelopers = this.parseToDataDev(studio.getHistoricalDevelopers());
        this.gamesDeveloped = this.parseToDataGame(studio.getJuegosDesarrollados());
        this.actualDevs = this.parseToDataDev(studio.desarrolladoresActuales());
    }

    private List<DataGameInDeveloper> parseToDataGame(List<Game> games) {
        List<DataGameInDeveloper> retList = new ArrayList<>();
        games.forEach(game -> retList.add(new DataGameInDeveloper(game)));
        return retList;
    }

    private List<DataDeveloperInStudio> parseToDataDev(List<Developer> developers) {
        List<DataDeveloperInStudio> retList = new ArrayList<>();
        developers.forEach(developer -> retList.add(new DataDeveloperInStudio(developer)));
        return retList;
    }
}
