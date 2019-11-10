package service.interf;

import model.Game;
import model.Study;

import java.util.List;

public interface ServiceStudy {
    Study searchStudy(String name);
    List<Game> gamesOfStudy(String name);
}
