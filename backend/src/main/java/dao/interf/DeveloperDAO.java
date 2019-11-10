package dao.interf;

import model.Developer;
import model.Game;
import model.Study;

import java.util.List;

public interface DeveloperDAO {
    void guardar(Developer desarrollador);
    Developer recuperarJuegoPorNombre(String nombre);
    void actualizar(Developer desarrolador);
    List<Game> juegosDesarrollados(String nombre);
    Developer recuperar(Long id);
    Study currentJob(String name);
}
