package dao.interf;

import model.Developer;
import model.Game;
import model.Studio;

import java.util.List;

public interface DeveloperDAO {
    List<Developer> searchDeveloper(String nombre);
    void guardar(Developer desarrollador);
    Developer recuperarJuegoPorNombre(String nombre);
    void actualizar(Developer desarrolador);
    List<Game> juegosDesarrollados(String nombre);
    Developer recuperar(Long id);
    Studio currentJob(String name, String lastName);
}
