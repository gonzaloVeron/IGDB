package api_rest;

import io.javalin.ExceptionHandler;
import io.javalin.Javalin;

import java.io.FileNotFoundException;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static org.eclipse.jetty.util.component.LifeCycle.start;

public class Main {

    public static void main(String[] args){
        AppController controller = new AppController();

        Javalin app = Javalin.create().enableRouteOverview("/routes").exception(FileNotFoundException.class, (e, ctx) -> {
            e.printStackTrace();
        }).error(404, ctx -> {
            ctx.json("Generic 404 message");
        }).start(7000);

        app.routes(() -> {

            path("juegos", () -> {
                path(":nombre", () -> {
                    get(controller::buscarPorNombre);
                });
            });

            path("genero", () -> {
                path(":gender", () -> {
                    get(controller::buscarPorGenero);
                });
            });

            path("plataforma", () -> {
                path(":platform", () ->{
                    get(controller::buscarPorPlataforma);
                });
            });

            path("game", () -> {
                path(":searchvalue", () -> {
                    get(controller::buscarJuegoPorNombre);
                });
            });

            path("games", () -> {
               path(":name", () -> {
                  path(":gender", () -> {
                     path(":platform", () -> {
                        get(controller::buscarJuegosPorNombreGeneroPlataforma);
                     });
                  });
               });
            });

        });
    }
}
