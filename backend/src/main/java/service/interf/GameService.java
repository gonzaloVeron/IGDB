package service.interf;

import model.Developer;
import model.Game;
import model.Studio;

import java.util.List;

public interface GameService {
    Game searchGameByName(String nombre);
    Game searchGameById(Long id);
    Studio recoverStudioFromGameByID(Long id);
    List<Developer> recoverAllDevelopersForGameByID(Long id);
    Studio recoverStudioFromGameByName(String name);
    List<Developer> recoverAllDevelopersForGameByName(String name);
}
