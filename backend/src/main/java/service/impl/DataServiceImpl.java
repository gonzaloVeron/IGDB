package service.impl;

import dao.impl.HibernateDeveloper;
import dao.impl.HibernateGameDAO;
import dao.impl.HibernateStudyDAO;
import dao.interf.DataDAO;
import dao.interf.DeveloperDAO;
import dao.interf.GameDAO;
import dao.interf.StudyDAO;
import model.*;
import service.interf.DataService;

import java.text.SimpleDateFormat;
import java.util.Date;

import static service.TransactionRunner.run;

public class DataServiceImpl implements DataService {

    private Game lol;
    private Game residentEvil;
    private Game dragonBallZ;
    //DAOS
    private GameDAO gameDAO;
    private DataDAO dataDAO;
    private StudyDAO studyDAO;
    //
    private Game resident;
    private Game residentEvil3;
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


    //Desarrolladores
    private Developer hideoKojima;
    private Developer markusPersson;
    private Developer johnRomero;
    private Developer johnCarmack;
    private DeveloperDAO developerDAO;




    //ESTUDIOS
    private Study redBarrels;
    private Study nintendo;
    private Study activision;
    private Study valve;
    private Study eaDigitalIllusionsCe;
    private Study capcom;
    private Study sCESantaMonicaStudio;
    private Study generation;




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
            //DAOS
            gameDAO = new HibernateGameDAO();
            studyDAO = new HibernateStudyDAO();
            developerDAO = new HibernateDeveloper();

            //Estudios
            //NINTENDO
            nintendo = new Study();
            nintendo.setNombre("Nintendo");
            Date fundacion = new Date(1889,9,23);
            nintendo.setFechaDeFundacion(fundacion);
            nintendo.setEstaActivo(Boolean.TRUE);
            //RED
            redBarrels = new Study();
            redBarrels.setNombre("Red Barrels");
            Date fundacionred = new Date(2011,5,8);
            redBarrels.setFechaDeFundacion(fundacionred);
            redBarrels.setEstaActivo(Boolean.FALSE);
            //Activision
            activision = new Study();
            activision.setNombre("Activision");
            Date fundacionactivision= new Date(1978,10,1);
            activision.setFechaDeFundacion(fundacionactivision);
            activision.setEstaActivo(Boolean.TRUE);
            //Valve
            valve = new Study();
            valve.setNombre("Valve");
            Date fundacionValve= new Date(1996,5,1);
            valve.setFechaDeFundacion(fundacionValve);
            valve.setEstaActivo(Boolean.TRUE);
            // EaDigitalIllusionsCe
            eaDigitalIllusionsCe = new Study();
            eaDigitalIllusionsCe.setNombre("EaDigitalIllusionsCe");
            eaDigitalIllusionsCe.setEstaActivo(Boolean.TRUE);
            Date fundacionDigital = new Date(1992,6,23);
            eaDigitalIllusionsCe.setFechaDeFundacion(fundacionDigital);
            //Capcom
            capcom = new Study();
            capcom.setNombre("Capcom");
            capcom.setEstaActivo(Boolean.TRUE);
            Date fundacionCapcom = new Date(1979,4,30);
            capcom.setFechaDeFundacion(fundacionCapcom);
            //sCESantaMonicaStudio
            sCESantaMonicaStudio = new Study();
            sCESantaMonicaStudio.setNombre("SCE Santa Monica Studio");
            sCESantaMonicaStudio.setEstaActivo(Boolean.FALSE);
            Date fundacionmonica = new Date(2005,5,25);
            sCESantaMonicaStudio.setFechaDeFundacion(fundacionmonica);
            //generation
            generation = new Study();
            generation.setNombre("Generation");
            generation.setEstaActivo(Boolean.TRUE);
            Date fundaciongeneration = new Date(1985,30,30);
            generation.setFechaDeFundacion(fundaciongeneration);
            //DESARROLLADOR

            //hideoKojima
            hideoKojima = new Developer();
            hideoKojima.setName("Hideo");
            hideoKojima.setLastName("Kojima");
            hideoKojima.setActuallyWorking(Boolean.FALSE);
            hideoKojima.setUrlPhoto("Ninguna");
            Date nacimiento = new Date(1975,25,5);
            hideoKojima.setDateOfBirth(nacimiento);
            //markusPersson
            markusPersson = new Developer();
            markusPersson.setName("Markus");
            markusPersson.setLastName("Persson");
            markusPersson.setActuallyWorking(Boolean.TRUE);
            markusPersson.setUrlPhoto("Ninguna");
            Date nacimientoo = new Date(1971,25,5);
            markusPersson.setDateOfBirth(nacimientoo);

            //johnRomero
            johnRomero = new Developer();
            johnRomero.setName("John");
            johnRomero.setLastName("Romero");
            johnRomero.setActuallyWorking(Boolean.FALSE);
            johnRomero.setUrlPhoto("Ninguna");
            Date fechanacimiento = new Date(1980,25,6);
            johnRomero.setDateOfBirth(fechanacimiento);

            //johnCarmack
            johnCarmack = new Developer();
            johnCarmack.setName("John");
            johnCarmack.setLastName("Caramack");
            johnCarmack.setActuallyWorking(Boolean.TRUE);
            johnCarmack.setUrlPhoto("Ninguna");
            Date fechana = new Date(1985,29,1);
            johnCarmack.setDateOfBirth(fechana);


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
            marioBros.setGenre(Genre.Simulation);
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
            legendOfZelda= new Game();
            legendOfZelda.setNombre("Lengend Of Zelda");
            legendOfZelda.setGenre(Genre.Adventure);
            luigiMansion= new Game();
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

            //ESTUDIO y sus Juegos
            nintendo.addJuego(marioBros);
            nintendo.addJuego(sonic);
            nintendo.addJuego(fifa2019);
            nintendo.addJuego(sonicMania);
            nintendo.addJuego(legendOfZelda);
            nintendo.addJuego(luigiMansion);
            nintendo.addJuego(tetris);
            //RED
            redBarrels.addJuego(outlast);
            redBarrels.addJuego(outlast2);
            redBarrels.addJuego(outlastWhistleblower);
            //Activision
            activision.addJuego(callofDutyBlackOps);
            activision.addJuego(callofDutyBlackOps2);
            activision.addJuego(callofDutyBlackOps3);
            activision.addJuego(callofDutyBlackOps4);
            //Valve
            valve.addJuego(leftOfDead);
            valve.addJuego(leftOfDead2);
            valve.addJuego(halfLife);
            valve.addJuego(halfLife2);
            //EaDigitalIllusionsCe
            eaDigitalIllusionsCe.addJuego(battlefield);
            eaDigitalIllusionsCe.addJuego(battlefield1);
            eaDigitalIllusionsCe.addJuego(battlefield2);
            eaDigitalIllusionsCe.addJuego(battlefield3);
            eaDigitalIllusionsCe.addJuego(battlefield4);
            //Capcom
            capcom.addJuego(dragonBallZXenoverse);
            capcom.addJuego(dragonBallZ);
            capcom.addJuego(dragonAgeOrigins);
            capcom.addJuego(resident);
            capcom.addJuego(residentEvil);
            capcom.addJuego(residentEvil3);
            capcom.addJuego(batman);
            capcom.addJuego(batmanArkhamKnight);
            capcom.addJuego(superman);
            capcom.addJuego(iroMan);
            //sCESantaMonicaStudio
            sCESantaMonicaStudio.addJuego(godOfWar);
            sCESantaMonicaStudio.addJuego(godOfWar2);
            sCESantaMonicaStudio.addJuego(godOfWar3);
            sCESantaMonicaStudio.addJuego(godOfWarAscension);
            //generation
            generation.addJuego(lol);
            generation.addJuego(digimon);
            generation.addJuego(minecraft);
            generation.addJuego(theLastOfUs);
            generation.addJuego(naruto);
            generation.addJuego(narutoShippudenUltimate);
            generation.addJuego(diablo3);
            generation.addJuego(deathStranding);
            generation.addJuego(superHot);
            generation.addJuego(tombRaider);
            generation.addJuego(metroExodus);
            generation.addJuego(theSimpsons);
            generation.addJuego(assassinsCreed);
            generation.addJuego(braid);
            generation.addJuego(bastion);
            generation.addJuego(bayonetta);
            generation.addJuego(invisibleInc);
            generation.addJuego(devilMayCry);
            //DESARROLLADORES
            hideoKojima.addGame(dragonBallZ);
            hideoKojima.addGame(dragonBallZXenoverse);
            hideoKojima.addGame(dragonAgeOrigins);
            hideoKojima.addGame(resident);
            hideoKojima.addGame(residentEvil);
            hideoKojima.addGame(residentEvil3);
            hideoKojima.addStudy(capcom);
            capcom.addDeveloper(hideoKojima);
            //
            markusPersson.addGame(minecraft);
            markusPersson.addGame(diablo3);
            markusPersson.addGame(digimon);
            markusPersson.addGame(lol);
            markusPersson.addStudy(generation);
            generation.addDeveloper(markusPersson);
            markusPersson.addPreviousStudies(capcom);
            capcom.addHistoricalDeveloper(markusPersson);


            ////
            johnRomero.addGame(godOfWar);
            johnRomero.addGame(godOfWar2);
            johnRomero.addGame(godOfWar3);
            johnRomero.addGame(godOfWarAscension);
            sCESantaMonicaStudio.addDeveloper(johnRomero);
            johnRomero.addStudy(sCESantaMonicaStudio);
            //////
            johnCarmack.addGame(marioBros);
            johnCarmack.addGame(sonicMania);
            johnCarmack.addGame(sonic);
            johnCarmack.addGame(fifa2019);
            johnRomero.addStudy(nintendo);
            nintendo.addDeveloper(johnRomero);




            //DAOS ESTUDIOS
            studyDAO.guardar(nintendo);
            studyDAO.guardar(redBarrels);
            studyDAO.guardar(activision);
            studyDAO.guardar(valve);
            studyDAO.guardar(eaDigitalIllusionsCe);
            studyDAO.guardar(capcom);
            studyDAO.guardar(sCESantaMonicaStudio);
            studyDAO.guardar(generation);

            //DAOS DEVELODER
            developerDAO.guardar(hideoKojima);
            developerDAO.guardar(markusPersson);
            developerDAO.guardar(johnRomero);
            developerDAO.guardar(johnCarmack);



        });
    }
}
