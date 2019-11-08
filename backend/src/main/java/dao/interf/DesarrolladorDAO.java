package dao.interf;

import model.Developer;
import model.Game;

import java.util.List;

public interface DesarrolladorDAO {
    void guardar(Developer desarrollador);
    Developer recuperarJuegoPorNombre(String nombre);
    void actualizar(Developer desarrolador);
    List<Game> juegosDesarrollados(String nombre);
    Developer recuperar(Long id);
}
