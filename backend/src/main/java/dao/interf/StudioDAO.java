package dao.interf;

import model.Game;
import model.Studio;

import java.util.List;

public interface StudioDAO {
    void save(Studio study);
    Studio recoverStudioByName(String name);
    void update(Studio Study);
    Studio recover(Long id);
    List<Game>gameOfStudio(String name);
    List<Studio> searchStudies(String name);
}
