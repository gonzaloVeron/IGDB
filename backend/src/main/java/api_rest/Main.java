package api_rest;

import io.javalin.Javalin;

import java.io.FileNotFoundException;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

public class Main {

    public static void main(String[] args){
        AppController controller = new AppController();

        controller.initializeDatabase();

        Javalin app = Javalin.create().enableRouteOverview("/routes")
                .enableCorsForAllOrigins()
                .exception(FileNotFoundException.class, (e, ctx) -> {
            e.printStackTrace();
        }).error(404, ctx -> {
            ctx.json("Generic 404 message");
        }).start(7000);



        app.routes(() -> {

            path("game", () -> {
                path(":searchvalue", () -> {
                    get(controller::buscarJuegoPorNombre);
                });
            });

            path("games", () -> {
               path(":name", () -> {
                  path(":genre", () -> {
                     path(":platform", () -> {
                        get(controller::buscarJuegosPorNombreGeneroPlataforma);
                     });
                  });
               });
            });

        });
    }
}
