package dao.interf;

import model.Game;
import model.Studio;

import java.util.List;

public interface StudioDAO {
    void guardar(Studio study);
    Studio recuperarEstudioPorNombre(String name);
    void actualizar(Studio Study);
    Studio recuperar(Long id);
    List<Game>gameOfStudio(String name);
    List<Studio> searchStudies(String name);
}
