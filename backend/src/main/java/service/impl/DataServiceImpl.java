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

    private Game lol;
    private Game residentEvil;
    private Game dragonBallZ;
    private JuegoDAO juegoDAO;
    private DataDAO dataDAO;
    private Game resident;
    private Game residentEvil3;


    //Developer
    private DesarrolladorDAO desarrolladorDAO;
    private Developer pedro;
    private Developer alan;

    //ESTUDIOS
    private Study riot;



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
            riot = new Study();

            //DESARROLLADOR
            desarrolladorDAO = new HibernateDesarrollador();
            pedro = new Developer();
            pedro.setName("Pedro");
            alan = new Developer();
            alan.setName("Alan");



            juegoDAO = new HibernateJuegoDAO();
            //JUEGOS
            lol = new Game();
            lol.setNombre("league of legends");
            lol.setGenre(Genre.Estrategy);
            dragonBallZ = new Game();
            dragonBallZ.setNombre("Dragon ball Z");
            dragonBallZ.setGenre(Genre.Fighting);
            residentEvil = new Game();
            residentEvil.setNombre("Resident Evil");
            residentEvil.setGenre(Genre.SurvivalHorror);
            residentEvil.addPlataforma(Platform.PS1);
            resident = new Game();
            resident.setNombre("Resident Evil 2");
            resident.setGenre(Genre.SurvivalHorror);
            resident.addPlataforma(Platform.PS1);
            residentEvil3 = new Game();
            residentEvil3.setNombre("Resident Evil 3");
            residentEvil3.setGenre(Genre.SurvivalHorror);
            residentEvil3.addPlataforma(Platform.PS1);
            //DESARROLLADORES Y ESTUDIOS
            riot.addJuego(lol);
            alan.addStudy(riot);

            //DAOS
//            juegoDAO.guardar(dragonBallZ);
//            juegoDAO.guardar(residentEvil);
//            juegoDAO.guardar(resident);
//            juegoDAO.guardar(residentEvil3);

            //DESARROLLADOR
            desarrolladorDAO.guardar(pedro);
            desarrolladorDAO.guardar(alan);




        });
    }
}
