

package service.impl;

import dao.impl.HibernateDeveloper;
import dao.impl.HibernateGameDAO;
import dao.impl.HibernateStudioDAO;
import dao.interf.DataDAO;
import dao.interf.DeveloperDAO;
import dao.interf.GameDAO;
import dao.interf.StudioDAO;
import model.*;
import service.interf.DataService;

import java.time.LocalDate;

import static service.TransactionRunner.run;

public class DataServiceImpl implements DataService {

    private Game lol;
    private Game residentEvil;
    private Game dragonBallZ;
    //DAOS
    private GameDAO gameDAO;
    private DataDAO dataDAO;
    private StudioDAO studioDAO;
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
    private Game justDance;
    private Game qbert;


    //Desarrolladores
    private Developer hideoKojima;
    private Developer markusPersson;
    private Developer johnRomero;
    private Developer johnCarmack;
    private DeveloperDAO developerDAO;




    //ESTUDIOS
    private Studio redBarrels;
    private Studio nintendo;
    private Studio activision;
    private Studio valve;
    private Studio eaDigitalIllusionsCe;
    private Studio capcom;
    private Studio sCESantaMonicaStudio;
    private Studio generation;




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
            studioDAO = new HibernateStudioDAO();
            developerDAO = new HibernateDeveloper();

            //Estudios
            //NINTENDO
            nintendo = new Studio();
            nintendo.setName("Nintendo");
            LocalDate fundacion = LocalDate.of(1889, 9, 23);
            nintendo.setFundationDate(fundacion);
            nintendo.setIsActive("Actualmente Activo");
            nintendo.setCoverPage("http://www.brandemia.org/sites/default/files/inline/images/nintendo_switch_logo_positivo.jpg");
            //RED
            redBarrels = new Studio();
            redBarrels.setName("Red Barrels");
            LocalDate fundacionred = LocalDate.of(2011, 5, 8);
            redBarrels.setFundationDate(fundacionred);
            redBarrels.setIsActive("Actualmente Clausurado");
            redBarrels.setCoverPage("https://pbs.twimg.com/profile_images/666640514326876163/eMthmgzk_400x400.png");
            //Activision
            activision = new Studio();
            activision.setName("Activision");
            LocalDate fundacionactivision= LocalDate.of(1978, 10, 1);
            activision.setFundationDate(fundacionactivision);
            activision.setIsActive("Actualmente Activo");
            activision.setCoverPage("https://pbs.twimg.com/profile_images/1054805141432360960/nPaXg6pP_400x400.jpg");

            //Valve
            valve = new Studio();
            valve.setName("Valve");
            LocalDate fundacionValve= LocalDate.of(1996, 5, 1);
            valve.setFundationDate(fundacionValve);
            valve.setIsActive("Actualmente Activo");
            valve.setCoverPage("https://dankfacts.com/wp-content/uploads/2018/10/valve-logo.jpg");

            // EaDigitalIllusionsCe
            eaDigitalIllusionsCe = new Studio();
            eaDigitalIllusionsCe.setName("EaDigitalIllusionsCe");
            eaDigitalIllusionsCe.setIsActive("Actualmente Clausurado");
            LocalDate fundacionDigital = LocalDate.of(1992, 6, 23);
            eaDigitalIllusionsCe.setFundationDate(fundacionDigital);
            eaDigitalIllusionsCe.setCoverPage("http://mytorchlight.ru/wp-content/uploads/2013/08/1344515580_dice.jpg");

            //Capcom
            capcom = new Studio();
            capcom.setName("Capcom");
            capcom.setIsActive("Actualmente Activo");
            LocalDate fundacionCapcom = LocalDate.of(1979, 4, 30);
            capcom.setFundationDate(fundacionCapcom);
            capcom.setCoverPage("https://vignette.wikia.nocookie.net/aceattorney/images/a/ac/Camcom_logo.png/revision/latest?cb=20131220100514&path-prefix=es");
            //sCESantaMonicaStudio
            sCESantaMonicaStudio = new Studio();
            sCESantaMonicaStudio.setName("SCE Santa Monica Studio");
            sCESantaMonicaStudio.setIsActive("Actualmente Activo");
            LocalDate fundacionmonica = LocalDate.of(2005, 5, 25);
            sCESantaMonicaStudio.setFundationDate(fundacionmonica);
            sCESantaMonicaStudio.setCoverPage("https://vignette.wikia.nocookie.net/godofwar/images/c/c0/Santa_monica.png/revision/latest?cb=20150226150344&path-prefix=es");
            //generation
            generation = new Studio();
            generation.setName("Generation");
            generation.setIsActive("Actualmente Clausurado");
            LocalDate fundaciongeneration = LocalDate.of(1984, 1, 30);
            generation.setFundationDate(fundaciongeneration);
            generation.setCoverPage("https://i.vimeocdn.com/portrait/8390464_300x300");
            //DESARROLLADOR

            //hideoKojima
            hideoKojima = new Developer();
            hideoKojima.setName("Hideo");
            hideoKojima.setLastName("Kojima");
            hideoKojima.setActuallyWorking("Trabaja en KojimaProductions");
            hideoKojima.setUrlPhoto("Ninguna");
            LocalDate nacimiento = LocalDate.of(1975,5,25);
            hideoKojima.setDateOfBirth(nacimiento);
            //markusPersson
            markusPersson = new Developer();
            markusPersson.setName("Markus");
            markusPersson.setLastName("Persson");
            markusPersson.setActuallyWorking("Desempleado");
            markusPersson.setUrlPhoto("http://prod-upp-image-read.ft.com/f06a484a-4000-11e4-936b-00144feabdc0");
            LocalDate nacimientoo = LocalDate.of(1971,5,25);
            markusPersson.setDateOfBirth(nacimientoo);

            //johnRomero
            johnRomero = new Developer();
            johnRomero.setName("John");
            johnRomero.setLastName("Romero");
            johnRomero.setActuallyWorking("Desempleado");
            johnRomero.setUrlPhoto("https://upload.wikimedia.org/wikipedia/commons/0/02/John_Romero_-_Jason_Scott_interview_%286951215353%29_%28cropped%29.jpg");
            LocalDate fechanacimiento = LocalDate.of(1980,6,25);
            johnRomero.setDateOfBirth(fechanacimiento);

            //johnCarmack
            johnCarmack = new Developer();
            johnCarmack.setName("John");
            johnCarmack.setLastName("Caramack");
            johnCarmack.setActuallyWorking("Trabaja en Oculus VR");
            johnCarmack.setUrlPhoto("https://as.com/meristation/imagenes/2019/11/12/noticias/1573560691_813107_1573560743_noticia_normal.jpg");
            LocalDate fechana = LocalDate.of(1985,1,29);
            johnCarmack.setDateOfBirth(fechana);


            //JUEGOS

            lol = new Game();
            lol.setName("league of legends");
            lol.setGenre(Genre.Strategy);
            lol.setPlatform(Platform.PC);
            lol.setSinopsis("League of Legends takes place in the fictional world of Runaterra. Where the champions are a collection of heroes and villains that have a variety of stories");
            lol.setUrlImage("https://dla.cdncimeco.com/uploads/2018/08/image5b70a69b8fd2d.jpg");

            dragonBallZ = new Game();
            dragonBallZ.setName("Dragon Ball Z: The Legend");
            dragonBallZ.setGenre(Genre.Fighting);
            dragonBallZ.setPlatform(Platform.PS1);
            dragonBallZ.setSinopsis("The characters fly around each other and use quick punches and kicks, and Ki bursts, either individually or quickly by holding down the assigned button for a short period of time.");
            dragonBallZ.setUrlImage("https://cdn11.bigcommerce.com/s-m92i69d8x0/images/stencil/1280x1775/products/8689/9074/dragon_ball_z_legends__23087.1504471018.jpg?c=2&imbypass=on&imbypass=on");

            residentEvil = new Game();
            residentEvil.setName("Resident Evil");
            residentEvil.setGenre(Genre.SurvivalHorror);
            residentEvil.addPlataform(Platform.PS1);
            residentEvil.setSinopsis("A series of strange murders occur, with victims whose remains show signs of cannibalism. The local city council sends the Bravo team of the elite group of the city's police, the S.T.A.R.S");
            residentEvil.setUrlImage("https://images-na.ssl-images-amazon.com/images/I/91AF0%2BBXxbL._AC_SL1481_.jpg");

            resident = new Game();
            resident.setName("Resident Evil 2");
            resident.setGenre(Genre.SurvivalHorror);
            resident.addPlataform(Platform.PS1);
            resident.setSinopsis("The majority of its inhabitants have been transformed into zombies by the effect of the T-virus, a biological weapon secretly developed by the pharmaceutical company Umbrella.");
            resident.setUrlImage("https://http2.mlstatic.com/resident-evil-2-ps3-clasico-de-ps1-15-min-D_NQ_NP_987239-MLA32295939258_092019-F.webp");

            residentEvil3 = new Game();
            residentEvil3.setName("Resident Evil 3");
            residentEvil3.setGenre(Genre.SurvivalHorror);
            residentEvil3.addPlataform(Platform.PS1);
            residentEvil3.setSinopsis("After the warnings of the survivors of the Spencer mansion incident were not heard or taken into account. Slowly a strange skin disease with a cannibal tendency spreads through the city");
            residentEvil3.setUrlImage("https://cdn.shopify.com/s/files/1/1603/1263/products/SPS1G346B_l_1024x1024.jpg?v=1563357935");
            //Game news

            marioBros = new Game();
            marioBros.setName("Super Mario Bros Deluxe");
            marioBros.setGenre(Genre.Simulation);
            marioBros.setPlatform(Platform.SWITCH);
            marioBros.setSinopsis("In the game, Mario is portrayed as an Italian-American plumber who, along with his younger brother Luigi, has to defeat the creatures that have come from the sewers under New York.");
            marioBros.setUrlImage("https://sm.ign.com/t/ign_es/screenshot/default/new-super-mario-bros-u-deluxe-key-art-03_j73n.1280.png");

            sonic =  new Game();;
            sonic.setName("Sonic Forces");
            sonic.setGenre(Genre.Adventure);
            sonic.setPlatform(Platform.SWITCH);
            sonic.setSinopsis("Dr.Eggman finds a power he uses to conquer 99% of the Planet. Sonic, Tails, Knuckles, Amy, Silver and members of the Chaotix detective agency lead a resistance, which continues to fight against the Eggman Empire");
            sonic.setUrlImage("https://i11c.3djuegos.com/juegos/13520/sonic_2017/fotos/ficha/sonic_2017-3835214.jpg");


            digimon = new Game();;
            digimon.setName("Digimon World 2");
            digimon.setGenre(Genre.Adventure);
            digimon.setPlatform(Platform.PS1);
            digimon.setSinopsis("The Digimon live peacefully in the Continent Directory until one day the Wild Digimon began attacking the Digital City.");
            digimon.setUrlImage("http://images1.wikia.nocookie.net/__cb20090121212045/digimon/es/images/7/7c/Digimonworld2.jpg");

            fifa2019= new Game();;
            fifa2019.setName("FiFA 2019");
            fifa2019.setGenre(Genre.Sports);
            fifa2019.setPlatform(Platform.PS4);
            fifa2019.setSinopsis("It's just one more fifa");
            fifa2019.setUrlImage("https://http2.mlstatic.com/juego-playstation-4-fifa-19-en-espanol-ps4-2019-catalogue-group-D_NQ_NP_899589-MLA30981717486_062019-F.webp");

            minecraft= new Game();
            minecraft.setName("Minecraft");
            minecraft.setGenre(Genre.Adventure);
            minecraft.setPlatform(Platform.PS4);
            minecraft.setSinopsis("The player is free to move through the terrain, consisting of different biomes, among which are deserts, savannas, jungles, oceans, plains, tundras, and so on.");
            minecraft.setUrlImage("https://thesamstore.com/wp-content/uploads/2019/07/minecraft-pc.jpg");

            theLastOfUs= new Game();
            theLastOfUs.setName("The last of us");
            theLastOfUs.setGenre(Genre.SurvivalHorror);
            theLastOfUs.setPlatform(Platform.PS4);
            theLastOfUs.setSinopsis("");
            theLastOfUs.setUrlImage("https://i11d.3djuegos.com/juegos/8274/last_of_us/fotos/ficha/last_of_us-2507095.jpg");


            batman= new Game();
            batman.setName("batman");
            batman.setGenre(Genre.Adventure);
            batman.setPlatform(Platform.PS4);
            batman.setSinopsis("");
            batman.setUrlImage("");

            superman= new Game();;
            superman.setName("Superman");
            superman.setGenre(Genre.Adventure);
            superman.setPlatform(Platform.PS4);
            superman.setSinopsis("");
            superman.setUrlImage("");

            iroMan= new Game();;
            iroMan.setName("Iron Man");
            iroMan.setGenre(Genre.Fighting);
            iroMan.setPlatform(Platform.PS4);
            iroMan.setSinopsis("");
            iroMan.setUrlImage("https://i11d.3djuegos.com/juegos/16534/iron_man_vr/fotos/ficha/iron_man_vr-4825443.jpg");



            theSimpsons= new Game();
            theSimpsons.setName("The simpsons");
            theSimpsons.setGenre(Genre.Adventure);
            theSimpsons.setPlatform(Platform.PC);
            theSimpsons.setSinopsis("");
            theSimpsons.setUrlImage("https://cloud10.todocoleccion.online/videojuegos-pc/tc/2015/01/27/10/47422246.jpg");






            assassinsCreed= new Game();
            assassinsCreed.setName("Assassins Creed");
            assassinsCreed.setGenre(Genre.Adventure);
            assassinsCreed.setPlatform(Platform.PS3);
            assassinsCreed.setSinopsis("");
            assassinsCreed.setUrlImage("https://vignette.wikia.nocookie.net/theassassinscreed/images/6/6a/Accover.jpg/revision/latest?cb=20100918021958&path-prefix=es");



            braid= new Game();
            braid.setName("Braid");
            braid.setGenre(Genre.Shooter);
            braid.setPlatform(Platform.PS3);
            braid.setSinopsis("");
            braid.setUrlImage("https://assets1.ignimgs.com/2019/01/05/braid---button-1546669924816.jpg");







            invisibleInc= new Game();;
            invisibleInc.setName("Invisible Inc");
            invisibleInc.setGenre(Genre.Simulation);
            invisibleInc.setPlatform(Platform.PS4);
            invisibleInc.setSinopsis("");
            invisibleInc.setUrlImage("https://hb.imgix.net/a2853c10d159c292c906dc43564f080e8454009d.jpg?auto=compress,format&fit=crop&h=353&w=616&s=53ac74313082f6f910d07f21a780db4a");

            sonicMania = new Game();
            sonicMania.setName("Sonic Mania");
            sonicMania.setGenre(Genre.Adventure);
            sonicMania.setPlatform(Platform.SWITCH);
            sonicMania.setSinopsis("The game takes place after the events of Sonic the Hedgehog 3 & Knuckles. Sonic and Tails receive a warning of a strange energy coming from Angel Island, so they ride the Tornado to go in search of the source of that signal.");
            sonicMania.setUrlImage("https://eshop.keengamer.com/81362/sonic-mania.jpg");


            bastion= new Game();;
            bastion.setName("Bastion");
            bastion.setGenre(Genre.Shooter);
            bastion.setPlatform(Platform.WII);
            bastion.setSinopsis("");
            bastion.setUrlImage("https://lh3.googleusercontent.com/pqaa9nOR5DViX6zMBp18cXvwI7e95-gCNbK5m1p-7s9pOf7eFwNYgPRKiG_VbJpY2TRXnYcV16DbphtyRmqtKUw");


            batmanArkhamKnight= new Game();
            batmanArkhamKnight.setName("Batman Arkham knight");
            batmanArkhamKnight.setGenre(Genre.Adventure);
            batmanArkhamKnight.setPlatform(Platform.PS4);
            batmanArkhamKnight.setSinopsis("");
            batmanArkhamKnight.setUrlImage("https://i11b.3djuegos.com/juegos/10762/batman_arkham_knight/fotos/ficha/batman_arkham_knight-2479241.jpg");


            bayonetta= new Game();;
            bayonetta.setName("Bayonetta");
            bayonetta.setGenre(Genre.SurvivalHorror);
            bayonetta.setPlatform(Platform.PS3);
            bayonetta.setSinopsis("");
            bayonetta.setUrlImage("https://i11c.3djuegos.com/juegos/2995/bayonetta/fotos/ficha/bayonetta-1693130.jpg");


            devilMayCry= new Game();
            devilMayCry.setName("Devil May Cry");
            devilMayCry.setGenre(Genre.SurvivalHorror);
            devilMayCry.setPlatform(Platform.PS4);
            devilMayCry.setSinopsis("");
            devilMayCry.setUrlImage("https://dnsgamer.s3-accelerate.amazonaws.com/wp-content/uploads/2018/10/Devil-May-Cry-HD-Collection-Devil-May-Cry-4-Special-Edition.png");

            dragonAgeOrigins= new Game();
            dragonAgeOrigins.setName("Dragon age origins");
            dragonAgeOrigins.setGenre(Genre.Fighting);
            dragonAgeOrigins.setPlatform(Platform.PS3);
            dragonAgeOrigins.setSinopsis("The blood wizards that caused all this were expelled and returned immediately to Thedas, but when they returned they were no longer human, but something much worse: the first dark engenders.");
            dragonAgeOrigins.setUrlImage("https://i11c.3djuegos.com/juegos/2045/dragon_age/fotos/ficha/dragon_age-1694542.jpg");

            metroExodus= new Game();;
            metroExodus.setName("Metro Exodus");
            metroExodus.setGenre(Genre.SurvivalHorror);
            metroExodus.setPlatform(Platform.PC);
            metroExodus.setSinopsis("");
            metroExodus.setUrlImage("https://i.ytimg.com/vi/gTNrBp_Ckio/maxresdefault.jpg");





            tombRaider= new Game();;
            tombRaider.setName("Tomb Raider");
            tombRaider.setGenre(Genre.Adventure);
            tombRaider.setPlatform(Platform.PS4);
            tombRaider.setSinopsis("");
            tombRaider.setUrlImage("https://i11b.3djuegos.com/juegos/10534/tomb_raider_definitive_edition/fotos/ficha/tomb_raider_definitive_edition-2423681.jpg");

            outlast= new Game();;
            outlast.setName("Outlast");
            outlast.setGenre(Genre.SurvivalHorror);
            outlast.setPlatform(Platform.PC);
            outlast.setSinopsis("");
            outlast.setUrlImage("http://3.bp.blogspot.com/-oAjKCdJ3DKk/VlSmnD-2PnI/AAAAAAAAAQs/msEpmqwS8Pk/s1600/out.png");



            outlast2= new Game();
            outlast2.setName("Outlast 2");
            outlast2.setGenre(Genre.SurvivalHorror);
            outlast2.setPlatform(Platform.PC);
            outlast2.setSinopsis("");
            outlast2.setUrlImage("https://http2.mlstatic.com/outlast-2-juego-pc-envio-gratis-oferta-D_NQ_NP_600246-MLC27226125224_042018-F.jpg");

            outlastWhistleblower= new Game();;
            outlastWhistleblower.setName("Outlast Whistleblower");
            outlastWhistleblower.setGenre(Genre.SurvivalHorror);
            outlastWhistleblower.setPlatform(Platform.PC);
            outlastWhistleblower.setSinopsis("");
            outlastWhistleblower.setUrlImage("https://www.blizzboygames.net/wp-content/uploads/2014/07/i9659_outlast-whistleblower_zps061a7da6.jpg");

            godOfWar= new Game();
            godOfWar.setName("God of war");
            godOfWar.setGenre(Genre.Adventure);
            godOfWar.setPlatform(Platform.PS2);
            godOfWar.setSinopsis("The game tells the adventures of Kratos, a Spartan general at the service of the gods of Greek mythology. The development revolves around the idea of the hibris (excessiveness) of Kratos to rebel against the gods and their own destiny.");
            godOfWar.setUrlImage("https://images-na.ssl-images-amazon.com/images/I/51K3DNEZN8L._AC_.jpg");

            godOfWarAscension= new Game();;
            godOfWarAscension.setName("God of war Ascension");
            godOfWarAscension.setGenre(Genre.Adventure);
            godOfWarAscension.setPlatform(Platform.PS3);
            godOfWarAscension.setSinopsis("Events are set before those of Chains of Olympus (2008), and ten years before the first installment of 2005 God of War");
            godOfWarAscension.setUrlImage("https://i11c.3djuegos.com/juegos/7537/god_of_war_4/fotos/ficha/god_of_war_4-1982746.jpg");

            godOfWar2= new Game();;
            godOfWar2.setName("God of war 2");
            godOfWar2.setGenre(Genre.Adventure);
            godOfWar2.setPlatform(Platform.PS2);
            godOfWar2.setSinopsis("The game begins when Kratos, become the god of war, threatens to destroy all of Greece as a Spartan general invokes him to achieve the glory of Sparta.");
            godOfWar2.setUrlImage("https://http2.mlstatic.com/god-of-war-ii-ps2-espanol-en-caja-D_NQ_NP_637542-MLA28789724740_112018-F.webp");

            godOfWar3= new Game();
            godOfWar3.setName("God of war 3");
            godOfWar3.setGenre(Genre.Adventure);
            godOfWar3.setPlatform(Platform.PS3);
            godOfWar3.setSinopsis("After killing the Sisters of Destiny, Kratos uses his power to travel instantly in which Zeus betrayed him and manages to avoid his death at the hands of the King of the Gods.");
            godOfWar3.setUrlImage("https://i11a.3djuegos.com/juegos/1950/god_of_war_3/fotos/ficha/god_of_war_3-1693200.jpg");

            superHot= new Game();
            superHot.setName("Super hot");
            superHot.setGenre(Genre.Shooter);
            superHot.setPlatform(Platform.PC);
            superHot.setSinopsis("");
            superHot.setUrlImage("");



            callofDutyBlackOps= new Game();
            callofDutyBlackOps.setName("Call of duty black ops");
            callofDutyBlackOps.setGenre(Genre.Shooter);
            callofDutyBlackOps.setPlatform(Platform.PC);
            callofDutyBlackOps.setSinopsis("");
            callofDutyBlackOps.setUrlImage("https://i11b.3djuegos.com/juegos/4240/call_of_duty_7__nombre_temporal_/fotos/ficha/call_of_duty_7__nombre_temporal_-1713413.jpg");


            callofDutyBlackOps2= new Game();;
            callofDutyBlackOps2.setName("Call of duty black ops 2");
            callofDutyBlackOps2.setGenre(Genre.Shooter);
            callofDutyBlackOps2.setPlatform(Platform.PC);
            callofDutyBlackOps2.setSinopsis("");
            callofDutyBlackOps2.setUrlImage("https://i11b.3djuegos.com/juegos/7387/call_of_duty_10/fotos/ficha/call_of_duty_10-1992857.jpg");



            callofDutyBlackOps3= new Game();
            callofDutyBlackOps3.setName("Call of duty black ops 3");
            callofDutyBlackOps3.setGenre(Genre.Shooter);
            callofDutyBlackOps3.setPlatform(Platform.PS4);
            callofDutyBlackOps3.setSinopsis("");
            callofDutyBlackOps3.setUrlImage("https://gameplanet-53f8.kxcdn.com/media/catalog/product/cache/4/thumbnail/9df78eab33525d08d6e5fb8d27136e95/c/a/call-of-duty-black-ops-3_2_1.jpg");






            callofDutyBlackOps4= new Game();
            callofDutyBlackOps4.setName("Call of duty black ops 4");
            callofDutyBlackOps4.setGenre(Genre.Shooter);
            callofDutyBlackOps4.setPlatform(Platform.PS4);
            callofDutyBlackOps4.setSinopsis("");
            callofDutyBlackOps4.setUrlImage("https://www.wog.ch/nas/cover_xl/p4/ps4_callofdutyblackops4.jpg");







            leftOfDead= new Game();;
            leftOfDead.setName("Left 4 dead");
            leftOfDead.setGenre(Genre.SurvivalHorror);
            leftOfDead.setPlatform(Platform.PC);
            leftOfDead.setSinopsis("");
            leftOfDead.setUrlImage("https://i11c.3djuegos.com/juegos/2004/left4dead/fotos/ficha/left4dead-1690378.jpg");







            leftOfDead2= new Game();;
            leftOfDead2.setName("Left 4 dead 2");
            leftOfDead2.setPlatform(Platform.XBOX360);
            leftOfDead2.setSinopsis("");
            leftOfDead2.setUrlImage("https://images-na.ssl-images-amazon.com/images/I/51YbyBBzfDL._SY445_.jpg");





            halfLife= new Game();;
            halfLife.setName("Half life");
            halfLife.setGenre(Genre.Adventure);
            halfLife.setPlatform(Platform.PC);
            halfLife.setSinopsis("");
            halfLife.setUrlImage("https://www.blizzboygames.net/wp-content/uploads/2014/05/Gordon-Freeman-on-Half-Life-1-box-cover-gordon-freeman-25689139-500-6451_zpsa4f6bf69.jpg");







            halfLife2= new Game();;
            halfLife2.setName("Half life 2");
            halfLife2.setGenre(Genre.Adventure);
            halfLife2.setPlatform(Platform.PC);
            halfLife2.setSinopsis("");
            halfLife2.setUrlImage("https://http2.mlstatic.com/half-life-2-pc-D_NQ_NP_955491-MLM28319236642_102018-F.jpg");







            legendOfZelda= new Game();
            legendOfZelda.setName("Legend Of Zelda");
            legendOfZelda.setGenre(Genre.Adventure);
            legendOfZelda.setPlatform(Platform.WIIU);
            legendOfZelda.setSinopsis("");
            legendOfZelda.setUrlImage("https://cl.buscafs.com/www.levelup.com/public/uploads/images/440107_832x1190.jpg");







            luigiMansion= new Game();
            luigiMansion.setName("Luigi Mansion");
            luigiMansion.setGenre(Genre.Adventure);
            luigiMansion.setPlatform(Platform.SWITCH);
            luigiMansion.setSinopsis("");
            luigiMansion.setUrlImage("https://images-na.ssl-images-amazon.com/images/I/51Ryo2TFP1L._SY445_.jpg");







            tetris= new Game();;
            tetris.setName("Tetris");
            tetris.setGenre(Genre.Rol);
            tetris.setPlatform(Platform.PC);
            tetris.setSinopsis("");
            tetris.setUrlImage("https://www.elotrolado.net/w/images/6/6f/Tetris_%28Caratula_NES%29.jpg");






            deathStranding= new Game();;
            deathStranding.setName("Death stranding");
            deathStranding.setGenre(Genre.Adventure);
            deathStranding.setPlatform(Platform.PS4);
            deathStranding.setSinopsis("");
            deathStranding.setUrlImage("https://i11d.3djuegos.com/juegos/12624/proyecto_hideo_kojima/fotos/ficha/proyecto_hideo_kojima-4922491.jpg");


            naruto= new Game();
            naruto.setName("Naruto");
            naruto.setGenre(Genre.Fighting);
            naruto.setPlatform(Platform.XBOXONE);
            naruto.setSinopsis("");
            naruto.setUrlImage("");





            narutoShippudenUltimate= new Game();;
            narutoShippudenUltimate.setName("Naruto shippuden ultimate");
            narutoShippudenUltimate.setGenre(Genre.Fighting);
            narutoShippudenUltimate.setPlatform(Platform.PS3);
            narutoShippudenUltimate.setSinopsis("");
            narutoShippudenUltimate.setUrlImage("http://juegosdigitalescr.com/wp-content/uploads/2016/08/Naruto-Shippuden-Ultimate-Ninja-Storm-Revolution.jpg");

            dragonBallZXenoverse= new Game();;
            dragonBallZXenoverse.setName("Dragon Ball Xenoverse");
            dragonBallZXenoverse.setGenre(Genre.Fighting);
            dragonBallZXenoverse.setPlatform(Platform.PS3);
            dragonBallZXenoverse.setSinopsis("Unlike previous games in the series that usually follow the story of Dragon Ball, Xenoverse will present a whole new story, including a character created by the player never seen before in the franchise.");
            dragonBallZXenoverse.setUrlImage("https://i11d.3djuegos.com/juegos/11002/dragon_ball_new_project/fotos/ficha/dragon_ball_new_project-2682283.jpg");

            battlefield= new Game();
            battlefield.setName("Battlefield");
            battlefield.setGenre(Genre.War);
            battlefield.setPlatform(Platform.PC);
            battlefield.setSinopsis("");
            battlefield.setUrlImage("");





            battlefield1= new Game();
            battlefield1.setName("Battlefield 1");
            battlefield1.setGenre(Genre.War);
            battlefield1.setPlatform(Platform.PC);
            battlefield1.setSinopsis("");
            battlefield1.setUrlImage("");



            battlefield2= new Game();;
            battlefield2.setName("Battlefield 2");
            battlefield2.setGenre(Genre.War);
            battlefield2.setPlatform(Platform.PC);
            battlefield2.setSinopsis("");
            battlefield2.setUrlImage("");


            battlefield3= new Game();;
            battlefield3.setName("Battlefield 3");
            battlefield3.setGenre(Genre.War);
            battlefield3.setPlatform(Platform.PC);
            battlefield3.setSinopsis("");
            battlefield3.setUrlImage("");



            battlefield4= new Game();;
            battlefield4.setName("Battlefield 4");
            battlefield4.setGenre(Genre.War);
            battlefield4.setPlatform(Platform.PC);
            battlefield4.setSinopsis("");
            battlefield4.setUrlImage("");


            diablo3= new Game();
            diablo3.setName("Diablo 3");
            diablo3.setGenre(Genre.SurvivalHorror);
            diablo3.setPlatform(Platform.PC);
            diablo3.setSinopsis("The demons of Burning Hells have wanted to invade the kingdom of men forever.");
            diablo3.setUrlImage("https://webimg.secondhandapp.com/w-i-mgl/5bdf880286fec3205417d6e6");

            justDance = new Game();
            justDance.setName("Just Dance 2018");
            justDance.setGenre(Genre.Music);
            justDance.setPlatform(Platform.WII);
            justDance.setSinopsis("Just Dance is a rhythm game series developed and published by Ubisoft. The series was named after the Lady Gaga song of the same title.");
            justDance.setUrlImage("https://images-na.ssl-images-amazon.com/images/I/81qDt6oYMoL._SL1500_.jpg");

            qbert = new Game();
            qbert.setName("Q*bert");
            qbert.setGenre(Genre.Puzzle);
            qbert.setPlatform(Platform.XBOXONE);
            qbert.setSinopsis("It is a 2D action game with puzzle elements that uses isometric graphics to create a pseudo-3D effect. The objective of each level in the game is to change the color of every cube in a pyramid by making Q*bert while avoiding obstacles and enemies");
            qbert.setUrlImage("https://media.vandal.net/t200/36244/qbert-rebooted-the-xbox-one-edition-20162511514_2.jpg");

            //ESTUDIO y sus Juegos
            nintendo.addGame(marioBros);
            nintendo.addGame(sonic);
            nintendo.addGame(fifa2019);
            nintendo.addGame(sonicMania);
            nintendo.addGame(legendOfZelda);
            nintendo.addGame(luigiMansion);
            nintendo.addGame(tetris);
            //RED
            redBarrels.addGame(outlast);
            redBarrels.addGame(outlast2);
            redBarrels.addGame(outlastWhistleblower);
            //Activision
            activision.addGame(callofDutyBlackOps);
            activision.addGame(callofDutyBlackOps2);
            activision.addGame(callofDutyBlackOps3);
            activision.addGame(callofDutyBlackOps4);
            //Valve
            valve.addGame(leftOfDead);
            valve.addGame(leftOfDead2);
            valve.addGame(halfLife);
            valve.addGame(halfLife2);
            //EaDigitalIllusionsCe
            eaDigitalIllusionsCe.addGame(battlefield);
            eaDigitalIllusionsCe.addGame(battlefield1);
            eaDigitalIllusionsCe.addGame(battlefield2);
            eaDigitalIllusionsCe.addGame(battlefield3);
            eaDigitalIllusionsCe.addGame(battlefield4);
            //Capcom
            capcom.addGame(dragonBallZXenoverse);
            capcom.addGame(dragonBallZ);
            capcom.addGame(dragonAgeOrigins);
            capcom.addGame(resident);
            capcom.addGame(residentEvil);
            capcom.addGame(residentEvil3);
            capcom.addGame(batman);
            capcom.addGame(batmanArkhamKnight);
            capcom.addGame(superman);
            capcom.addGame(iroMan);
            //sCESantaMonicaStudio
            sCESantaMonicaStudio.addGame(godOfWar);
            sCESantaMonicaStudio.addGame(godOfWar2);
            sCESantaMonicaStudio.addGame(godOfWar3);
            sCESantaMonicaStudio.addGame(godOfWarAscension);
            //generation
            generation.addGame(lol);
            generation.addGame(digimon);
            generation.addGame(minecraft);
            generation.addGame(theLastOfUs);
            generation.addGame(naruto);
            generation.addGame(narutoShippudenUltimate);
            generation.addGame(diablo3);
            generation.addGame(deathStranding);
            generation.addGame(superHot);
            generation.addGame(tombRaider);
            generation.addGame(metroExodus);
            generation.addGame(theSimpsons);
            generation.addGame(assassinsCreed);
            generation.addGame(braid);
            generation.addGame(bastion);
            generation.addGame(bayonetta);
            generation.addGame(invisibleInc);
            generation.addGame(devilMayCry);
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
            markusPersson.addGame(qbert);
            markusPersson.addGame(justDance);
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
            studioDAO.save(nintendo);
            studioDAO.save(redBarrels);
            studioDAO.save(activision);
            studioDAO.save(valve);
            studioDAO.save(eaDigitalIllusionsCe);
            studioDAO.save(capcom);
            studioDAO.save(sCESantaMonicaStudio);
            studioDAO.save(generation);

            //DAOS DEVELODER
            developerDAO.save(hideoKojima);
            developerDAO.save(markusPersson);
            developerDAO.save(johnRomero);
            developerDAO.save(johnCarmack);



        });
    }
}