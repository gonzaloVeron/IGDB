package dao.interf;

import model.Developer;
import model.Game;
import model.Review;
import model.Studio;

import java.util.List;

public interface GameDAO {
    void save(Game game);
    Game recoverGameByName(String nombre);
    void update(Game game);
    Game recover(Long id);
    Studio recoverStudioFromGameByID(Long id);
    List<Developer> recoverAllDevelopersForGameByID(Long id);
    Studio recoverStudioFromGameByName(String name);
    List<Developer> recoverAllDevelopersForGameByName(String name);
    List<Review> gamereviews(String name);
    Double averageScoreOfAGame(String name);
}
