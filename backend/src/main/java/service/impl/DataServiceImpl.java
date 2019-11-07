package service.impl;

import dao.impl.HibernateDesarrollador;
import dao.impl.HibernateJuegoDAO;
import dao.interf.DataDAO;
import dao.interf.DesarrolladorDAO;
import dao.interf.JuegoDAO;
import model.*;
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


    //Desarrollador
    private DesarrolladorDAO desarrolladorDAO;
    private Desarrollador pedro;
    private Desarrollador alan;

    //ESTUDIOS
    private Estudio riot;



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
            //Estudios
            riot = new Estudio();

            //DESARROLLADOR
            desarrolladorDAO = new HibernateDesarrollador();
            pedro = new Desarrollador();
            pedro.setNombre("Pedro");
            alan = new Desarrollador();
            alan.setNombre("Alan");



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
            residentEvil.addPlataforma(Plataforma.PS1);
            resident = new Juego();
            resident.setNombre("Resident Evil 2");
            resident.setGenero(Genero.SurvivalHorror);
            resident.addPlataforma(Plataforma.PS1);
            residentEvil3 = new Juego();
            residentEvil3.setNombre("Resident Evil 3");
            residentEvil3.setGenero(Genero.SurvivalHorror);
            residentEvil3.addPlataforma(Plataforma.PS1);
            //DESARROLLADORES Y ESTUDIOS
            riot.addJuego(lol);
            alan.addStudy(riot);

            //DAOS
            juegoDAO.guardar(lol);
            juegoDAO.guardar(dragonBallZ);
            juegoDAO.guardar(residentEvil);
            juegoDAO.guardar(resident);
            juegoDAO.guardar(residentEvil3);

            //DESARROLLADOR
            desarrolladorDAO.guardar(pedro);
            desarrolladorDAO.guardar(alan);




        });
    }
}
