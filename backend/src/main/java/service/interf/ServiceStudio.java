package service.interf;

import model.Game;
import model.Studio;

import java.util.List;

public interface ServiceStudio {
    Studio searchStudio(String name);
    Studio searchStudioById(Long id);
    List<Game> gamesOfStudio(String name);
    List<Studio>searchStudies(String name);
}
