package api_rest.DataClass;

import model.Developer;
import model.Game;
import model.Studio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataDeveloperFile {
        public Long id;
        public String name;
        public String lastName;
        public String imageUrl;
        public String dateOfBirth;
        public String isWorking;
        public List<DataStudioInDeveloper> historicalStudios;
        public List<DataStudioInDeveloper> currentStudios;
        public List<DataGameInDeveloper> gamesParticipated;

        public DataDeveloperFile(Developer developer){
            this.id = developer.getId();
            this.name = developer.getName();
            this.lastName = developer.getLastName();
            this.imageUrl = developer.getUrlPhoto();
            this.dateOfBirth = developer.getDateOfBirth().toString();
            this.isWorking = developer.getActuallyWorking();
            this.historicalStudios = this.parseToDataStudio(developer.getStudies());
            this.currentStudios = this.parseToDataStudio(developer.getCurrentStudios());
            this.gamesParticipated = this.parseToDataGame(developer.getGames());
        }

    private List<DataGameInDeveloper> parseToDataGame(List<Game> games) {
        List<DataGameInDeveloper> retList = new ArrayList<>();
        games.forEach(game -> retList.add(new DataGameInDeveloper(game)));
            return retList;
    }

    private List<DataStudioInDeveloper> parseToDataStudio(List<Studio> studios){
            List<DataStudioInDeveloper> retList = new ArrayList<>();
            studios.forEach(studio -> {
                retList.add(new DataStudioInDeveloper(studio));
            });
            return retList;
        }
}
