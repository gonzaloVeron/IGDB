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
            ctx.json("Error 404 Not Found");
        }).start(7000);



        app.routes(() -> {

            path("game", () -> {
                path(":id", () -> {
                    get(controller::searchGameById);
                });
            });

            path("gamename", () -> {
                path(":name", () -> {
                    get(controller::searchGameByName);
                });
            });

            path("dev", () -> {
                path(":id", () -> {
                    get(controller::searchDeveloperById);
                });
            });

            path("devname", () -> {
                path(":name", () -> {
                    get(controller::searchDeveloperByName);
                });
            });


            path("studio", () -> {
                path(":id", () -> {
                    get(controller::searchStudioById);
                });
            });

            path("studioname", () -> {
                path(":name", () -> {
                    get(controller::searchStudioByName);
                });
            });

            path("search", () -> {
               path(":name", () -> {
                  path(":genre", () -> {
                     path(":platform", () -> {
                        get(controller::searchGameDevStdByNameGenrePlatform);
                     });
                  });
               });
            });

        });
    }
}
