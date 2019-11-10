package service.interf;

import model.Game;
import model.Study;

import java.util.List;

public interface ServiceStudy {
    Study searchStudy(String name);
    Study searchStudyById(Long id);
    List<Game> gamesOfStudy(String name);
    List<Study>searchStudies(String name);
}
