package api_rest.DataClass;

import model.Game;
import model.Studio;
import org.mockito.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class DataDeveloperSearch {
        public Long id;
        public String name;
        public String lastName;
        public String imageUrl;
        public String dateOfBirth;
        public String isWorking;
        public List<Studio> devStudiesWorked;
        public List<Game> gamesParticipated;

        public DataDeveloperSearch(Long id, String name, String lastName, String imageUrl, LocalDate dateOfBirth, String isWorking, List<Studio> devStudiesWorked, List<Game> gamesParticipated){
            this.id = id;
            this.name = name;
            this.lastName = lastName;
            this.imageUrl = imageUrl;
            this.dateOfBirth = dateOfBirth.toString();
            this.isWorking = isWorking;
            this.devStudiesWorked = devStudiesWorked;
            this.gamesParticipated = gamesParticipated;

        }

        private String dateToString(Date date){
            return date.getDay() + "/" + date.getMonth() + "/" + date.getYear();
        }
}
