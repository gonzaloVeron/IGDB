package api_rest.DataClass;

import model.Game;
import model.Studio;

import java.util.Date;
import java.util.List;

public class DataDeveloperSearch {
        public Long id;
        public String name;
        public String lastName;
        public String imageUrl;
        public Date dateOfBirth;
        public Boolean isWorking;
        public List<Studio> devStudiesWorked;
        public List<Game> gamesParticipated;

        public DataDeveloperSearch(Long id, String name, String lastName, String imageUrl, Date dateOfBirth, Boolean isWorking, List<Studio> devStudiesWorked, List<Game> gamesParticipated){
            this.id = id;
            this.name = name;
            this.lastName = lastName;
            this.imageUrl = imageUrl;
            this.dateOfBirth = dateOfBirth;
            this.isWorking = isWorking;
            this.devStudiesWorked = devStudiesWorked;
            this.gamesParticipated = gamesParticipated;

        }
}
