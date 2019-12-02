package api_rest;

import api_rest.Controller.*;
import api_rest.Exceptions.ElementAlreadyExistsException;
import io.javalin.Javalin;

import java.io.FileNotFoundException;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {

    public static void main(String[] args){
        SearchController controller = new SearchController();
        LoginController loginController = new LoginController();
        LogErrorController logErrorController = new LogErrorController();
        ReviewController reviewController = new ReviewController();
        UserController userController = new UserController();

        controller.initializeDatabase();

        Javalin app = Javalin.create().enableRouteOverview("/routes")
                .enableCorsForAllOrigins()
                .exception(FileNotFoundException.class, (e, ctx) -> {
            e.printStackTrace();
        }).start(7000);

        app.exception(ElementAlreadyExistsException.class, (e, ctx) -> {
            ctx.status(404);
        }).error(404, ctx -> {
            ctx.result("BAD_REQUEST");
        });

        app.exception(FileNotFoundException.class, (e, ctx) -> {
            ctx.status(404);
        }).error(404,  ctx -> {
            ctx.result("No se a podido encontrar la consulta");
        });

        app.exception(NullPointerException.class, (e, ctx) -> {
            logErrorController.logNullPointerException(e);
            ctx.status(500);
            ctx.result("No se a podido procesar la consulta");
        });

        app.exception(IllegalArgumentException.class, (e, ctx) -> {
            logErrorController.log(e);
            ctx.status(400);
            ctx.result(e.getMessage());
        });


        app.routes(() -> {

            path("game", () -> {
                path(":id", () -> {
                    get(controller::searchGameById);
                });
            });

            path("user", () -> {
                path(":id", () -> {
                    get(controller::searchUserById);
                });
            });

            path("changephotouser", () -> {
                path(":id", () -> {
                    put(userController::changePhotoUser);
                });
            });

            path("review", () -> {
                path(":id", () -> {
                    put(reviewController::addReviewById);
                });
            });

            path("review", () -> {
                path(":id", () -> {
                    delete(reviewController::deleteReviewById);
                });
            });

            path("dev", () -> {
                path(":id", () -> {
                    get(controller::searchDeveloperById);
                });
            });

            path("login", () -> {
                post(loginController::login);
            });

            path("register", () -> {
                post(loginController::register);
            });

            path("studio", () -> {
                path(":id", () -> {
                    get(controller::searchStudioById);
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
