package dao.interf;

import model.Desarrollador;
import model.Juego;

import java.util.List;

public interface DesarrolladorDAO {
    void guardar(Desarrollador desarrollador);
    Desarrollador recuperarJuegoPorNombre(String nombre);
    void actualizar(Desarrollador juego);
    List<Juego> juegosDesarrollados(String nombre);
}
