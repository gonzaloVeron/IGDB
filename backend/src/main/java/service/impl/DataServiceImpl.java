package service.impl;

import dao.impl.HibernateJuegoDAO;
import dao.interf.DataDAO;
import dao.interf.JuegoDAO;
import model.Genero;
import model.Juego;
import model.Plataforma;
import service.interf.DataService;
import static service.TransactionRunner.run;

public class DataServiceImpl implements DataService {

    private Juego lol;
    private Juego residentEvil;
    private Juego dragonBallZ;
    private JuegoDAO juegoDAO;
    private DataDAO dataDAO;
    private Juego resident;
    private Juego residentEvil3;

    public DataServiceImpl(DataDAO dataDAO){
        this.dataDAO = dataDAO;

    }
    public DataServiceImpl(){

    }

    @Override
    public void eliminarDatos() { run(()-> this.dataDAO.clear());}



    @Override
    public void crearDatosIniciales() {
        run(() -> {
            juegoDAO = new HibernateJuegoDAO();
            //JUEGOS
            lol = new Juego();
            lol.setNombre("league of legends");
            lol.setGenero(Genero.Strategy);
            lol.addPlataforma(Plataforma.PC);
            lol.setSinopsis("League of Legends (también conocido por sus siglas LoL) es un videojuego del género multijugador de arena de batalla en línea (MOBA) y deporte electrónico.");
            dragonBallZ = new Juego();
            dragonBallZ.setNombre("Dragon ball Z");
            dragonBallZ.setGenero(Genero.Fighting);
            dragonBallZ.addPlataforma(Plataforma.WIIU);
            dragonBallZ.setSinopsis("Dragon Ball FighterZ es un videojuego de lucha en 2D desarrollado por Arc System Works y distribuido por Bandai Namco Entertainment, basado en la franquicia Dragon Ball.");
            residentEvil = new Juego();
            residentEvil.setNombre("Resident Evil");
            residentEvil.setGenero(Genero.SurvivalHorror);
            residentEvil.setSinopsis("Resident Evil es el primer título de una serie de videojuegos que salió a la venta en Japón en el año 1996.");
            residentEvil.addPlataforma(Plataforma.PS1);
            resident = new Juego();
            resident.setNombre("Resident Evil 2");
            resident.setGenero(Genero.SurvivalHorror);
            resident.setSinopsis("Resident Evil 2 es un videojuego japonés del género survival horror.");
            resident.addPlataforma(Plataforma.PS1);
            residentEvil3 = new Juego();
            residentEvil3.setNombre("Resident Evil 3");
            residentEvil3.setGenero(Genero.SurvivalHorror);
            residentEvil3.setSinopsis("Resident Evil 3: Nemesis es un videojuego de acción-aventura del estilo survival horror desarrollado y distribuido por Capcom.");
            residentEvil3.addPlataforma(Plataforma.PS1);

            //DAOS
            juegoDAO.guardar(lol);
            juegoDAO.guardar(dragonBallZ);
            juegoDAO.guardar(residentEvil);
            juegoDAO.guardar(resident);
            juegoDAO.guardar(residentEvil3);




        });
    }
}
