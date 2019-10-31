package dao.interf;

import model.Genero;
import model.Juego;
import model.Plataforma;

import java.util.List;

public interface SearchDAO {
    List<Juego> busquedaPorGenero(Genero genero);
    List<Juego> busquedaPorPlataforma(Plataforma plataforma);
    List<Juego> busquedaPorNombre(String nombre);
}
