package service.impl;

import dao.impl.HibernateDeveloper;
import dao.impl.HibernateGameDAO;
import dao.interf.DataDAO;
import dao.interf.DeveloperDAO;
import dao.interf.GameDAO;
import model.*;
import service.interf.DataService;
import static service.TransactionRunner.run;

public class DataServiceImpl implements DataService {

    private Game lol;
    private Game residentEvil;
    private Game dragonBallZ;
    private GameDAO gameDAO;
    private DataDAO dataDAO;
    private Game resident;
    private Game residentEvil3;
    //GAMES NEWS
    private Game marioBros;
    private Game sonic;
    private Game digimon;
    private Game fifa2019;
    private Game minecraft;
    private Game theLastOfUs;
    private Game batman;
    private Game superman;
    private Game iroMan;
    private Game theSimpsons;
    private Game assassinsCreed;
    private Game braid;
    private Game invisibleInc;
    private Game sonicMania;
    private Game bastion;
    private Game batmanArkhamKnight;
    private Game bayonetta;
    private Game devilMayCry;
    private Game dragonAgeOrigins;
    private Game metroExodus;
    private Game tombRaider;
    private Game outlast;
    private Game outlast2;
    private Game outlastWhistleblower;
    private Game godOfWar;
    private Game godOfWarAscension;
    private Game godOfWar2;
    private Game godOfWar3;
    private Game superHot;
    private Game callofDutyBlackOps;
    private Game callofDutyBlackOps2;
    private Game callofDutyBlackOps3;
    private Game callofDutyBlackOps4;
    private Game leftOfDead;
    private Game leftOfDead2;
    private Game halfLife;
    private Game halfLife2;
    private Game legendOfZelda;
    private Game luigiMansion;
    private Game tetris;
    private Game deathStranding;
    private Game naruto;
    private Game narutoShippudenUltimate;
    private Game dragonBallZXenoverse;
    private Game battlefield;
    private Game battlefield1;
    private Game battlefield2;
    private Game battlefield3;
    private Game battlefield4;
    private Game diablo3;


    //Developer
    private DeveloperDAO developerDAO;
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
            developerDAO = new HibernateDeveloper();
            pedro = new Developer();
            pedro.setName("Pedro");
            alan = new Developer();
            alan.setName("Alan");



            gameDAO = new HibernateGameDAO();
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
            //Game news
            marioBros = new Game();
            marioBros.setNombre("Mario Bros");
            marioBros.setGenre(Genre.Adventure);
            sonic =  new Game();;
            sonic.setNombre("Sonic");
            sonic.setGenre(Genre.Adventure);
            digimon = new Game();;
            digimon.setNombre("Digimon");
            digimon.setGenre(Genre.Adventure);
            fifa2019= new Game();;
            fifa2019.setNombre("FiFA 2019");
            fifa2019.setGenre(Genre.Deports);
            minecraft= new Game();
            minecraft.setNombre("Minecraft");
            minecraft.setGenre(Genre.Adventure);

            theLastOfUs= new Game();
            theLastOfUs.setNombre("The last of us");
            theLastOfUs.setGenre(Genre.SurvivalHorror);
            batman= new Game();
            batman.setNombre("Batman");
            batman.setGenre(Genre.Adventure);
            superman= new Game();;
            superman.setNombre("Superman");
            superman.setGenre(Genre.Adventure);
            iroMan= new Game();;
            iroMan.setNombre("Iron Man");
            iroMan.setGenre(Genre.Fighting);
            theSimpsons= new Game();
            theSimpsons.setNombre("The simpsons");
            theSimpsons.setGenre(Genre.Adventure);
            assassinsCreed= new Game();
            assassinsCreed.setNombre("Assassins Creed");
            assassinsCreed.setGenre(Genre.Adventure);
            braid= new Game();
            braid.setNombre("Braid");
            braid.setGenre(Genre.Race);
            invisibleInc= new Game();;
            invisibleInc.setNombre("Invisible Inc");
            invisibleInc.setGenre(Genre.Simulation);

            sonicMania= new Game();
            sonicMania.setNombre("Sonic Mania");
            sonicMania.setGenre(Genre.Adventure);
            bastion= new Game();;
            bastion.setNombre("Bastion");
            bastion.setGenre(Genre.Shooter);
            batmanArkhamKnight= new Game();
            batmanArkhamKnight.setNombre("Batman Arkham night");
            batmanArkhamKnight.setGenre(Genre.Adventure);
            bayonetta= new Game();;
            bayonetta.setNombre("Bayonetta");
            bayonetta.setGenre(Genre.SurvivalHorror);
            devilMayCry= new Game();
            devilMayCry.setNombre("Devil May Cry");
            devilMayCry.setGenre(Genre.SurvivalHorror);
            dragonAgeOrigins= new Game();
            dragonAgeOrigins.setNombre("Dragon age origins");
            dragonAgeOrigins.setGenre(Genre.Fighting);
            metroExodus= new Game();;
            metroExodus.setNombre("Metro Exodus");
            metroExodus.setGenre(Genre.SurvivalHorror);
            tombRaider= new Game();;
            tombRaider.setNombre("Tomb Raider");
            tombRaider.setGenre(Genre.Adventure);
            outlast= new Game();;
            outlast.setNombre("Outlast");
            outlast.setGenre(Genre.SurvivalHorror);
            outlast2= new Game();
            outlast2.setNombre("Outlast 2");
            outlast2.setGenre(Genre.SurvivalHorror);
            outlastWhistleblower= new Game();;
            outlastWhistleblower.setNombre("Outlast Whistleblower");
            godOfWar= new Game();
            godOfWar.setNombre("God of war");
            godOfWar.setGenre(Genre.Adventure);
            godOfWarAscension= new Game();;
            godOfWarAscension.setNombre("God of war Ascension");
            godOfWarAscension.setGenre(Genre.Adventure);
            godOfWar2= new Game();;
            godOfWar2.setNombre("God of war 2");
            godOfWar2.setGenre(Genre.Adventure);
            godOfWar3= new Game();
            godOfWar3.setNombre("God of war 3");
            godOfWar3.setGenre(Genre.Adventure);
            superHot= new Game();
            superHot.setNombre("Super hot");
            superHot.setGenre(Genre.Shooter);
            callofDutyBlackOps= new Game();
            callofDutyBlackOps.setNombre("Call of duty black ops");
            callofDutyBlackOps.setGenre(Genre.Shooter);
            callofDutyBlackOps2= new Game();;
            callofDutyBlackOps2.setNombre("Call of duty black ops 2");
            callofDutyBlackOps2.setGenre(Genre.Shooter);

            callofDutyBlackOps3= new Game();
            callofDutyBlackOps3.setNombre("Call of duty black ops 3");
            callofDutyBlackOps3.setGenre(Genre.Shooter);
            callofDutyBlackOps4= new Game();
            callofDutyBlackOps4.setNombre("Call of duty black ops 4");
            callofDutyBlackOps4.setGenre(Genre.Shooter);
            leftOfDead= new Game();;
            leftOfDead.setNombre("Left of dead");
            leftOfDead.setGenre(Genre.SurvivalHorror);
            leftOfDead2= new Game();;
            leftOfDead2.setNombre("Left of dead 2");
            halfLife= new Game();;
            halfLife.setNombre("Half life");
            halfLife.setGenre(Genre.Adventure);
            halfLife2= new Game();;
            halfLife2.setNombre("Half life 2");
            halfLife2.setGenre(Genre.Adventure);
            legendOfZelda= new Game();;
            legendOfZelda.setNombre("Legend of zelda");
            legendOfZelda.setGenre(Genre.Adventure);
            luigiMansion= new Game();;
            luigiMansion.setNombre("Luigi Mansion");
            luigiMansion.setGenre(Genre.Adventure);
            tetris= new Game();;
            tetris.setNombre("Tetris");
            tetris.setGenre(Genre.Adventure);
            deathStranding= new Game();;
            deathStranding.setNombre("Seath stranding");
            deathStranding.setGenre(Genre.Adventure);
            naruto= new Game();
            naruto.setNombre("Naruto");
            naruto.setGenre(Genre.Fighting);
            narutoShippudenUltimate= new Game();;
            narutoShippudenUltimate.setNombre("Naruto shippuden ultimate");
            narutoShippudenUltimate.setGenre(Genre.Fighting);
            dragonBallZXenoverse= new Game();;
            dragonBallZXenoverse.setNombre("Dragon Ball Xenoverse");
            dragonBallZXenoverse.setGenre(Genre.Fighting);
            battlefield= new Game();
            battlefield.setNombre("Battlefield");
            battlefield.setGenre(Genre.Shooter);
            battlefield1= new Game();
            battlefield1.setNombre("Battlefield 1");
            battlefield1.setGenre(Genre.Shooter);
            battlefield2= new Game();;
            battlefield2.setNombre("Battlefield 2");
            battlefield2.setGenre(Genre.Shooter);
            battlefield3= new Game();;
            battlefield3.setNombre("Battlefield 3");
            battlefield3.setGenre(Genre.Shooter);
            battlefield4= new Game();;
            battlefield4.setNombre("Battlefield 4");
            battlefield4.setGenre(Genre.Shooter);
            diablo3= new Game();
            diablo3.setNombre("Diablo 3");
            diablo3.setGenre(Genre.SurvivalHorror);

            //DESARROLLADORES Y ESTUDIOS
            riot.addJuego(lol);
            alan.addStudy(riot);
            alan.addGame(lol);


            //DAOS
            gameDAO.guardar(dragonBallZ);
            gameDAO.guardar(residentEvil);
            gameDAO.guardar(resident);
            gameDAO.guardar(residentEvil3);

            //DESARROLLADOR
            developerDAO.guardar(pedro);
            developerDAO.guardar(alan);




        });
    }
}
