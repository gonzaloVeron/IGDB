package api_rest.DataClass;

import java.util.List;

public class DataSearch {
    public List<DataGameSearch> games;
    public List<DataStudioSearch> studios;
    public List<DataDeveloperSearch> devs;

    public DataSearch(List<DataGameSearch> dataGames, List<DataStudioSearch> dataStudios, List<DataDeveloperSearch> dataDevs) {
        this.games = dataGames;
        this.studios = dataStudios;
        this.devs = dataDevs;
    }
}
