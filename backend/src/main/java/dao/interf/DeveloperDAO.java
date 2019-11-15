package dao.interf;

import model.Developer;
import model.Game;
import model.Studio;

import java.util.List;

public interface DeveloperDAO {
    List<Developer> searchDeveloper(String nombre);
    void save(Developer desarrollador);
    Developer recoverGameByName(String nombre);
    void update(Developer desarrolador);
    List<Game> developedGames(String nombre);
    Developer recover(Long id);
    Studio currentJob(String name, String lastName);
}
