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
            lol.setGenero(Genero.Estrategy);
            dragonBallZ = new Juego();
            dragonBallZ.setNombre("Dragon ball Z");
            dragonBallZ.setGenero(Genero.Fighting);
            residentEvil = new Juego();
            residentEvil.setNombre("Resident Evil");
            residentEvil.setGenero(Genero.SurvivalHorror);
            residentEvil.setPlataforma(Plataforma.PS1);
            resident = new Juego();
            resident.setNombre("Resident Evil 2");
            resident.setGenero(Genero.SurvivalHorror);
            resident.setPlataforma(Plataforma.PS1);
            residentEvil3 = new Juego();
            residentEvil3.setNombre("Resident Evil 3");
            residentEvil3.setGenero(Genero.SurvivalHorror);
            residentEvil3.setPlataforma(Plataforma.PS1);

            //DAOS
            juegoDAO.guardar(lol);
            juegoDAO.guardar(dragonBallZ);
            juegoDAO.guardar(residentEvil);
            juegoDAO.guardar(resident);
            juegoDAO.guardar(residentEvil3);




        });
    }
}
