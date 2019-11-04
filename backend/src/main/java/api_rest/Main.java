package api_rest;

import io.javalin.Javalin;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static org.eclipse.jetty.util.component.LifeCycle.start;

public class Main {

    public void main() {
        AppController controller = new AppController();

        Javalin app = Javalin.create().apply {
            exception(Exception:: class.java){
                e, ctx -> e.printStackTrace()
            }
            error(404) {
                ctx -> ctx.json("Not Found")
            }
        }.start(7000)

        app.routes(() -> {

            path("juegos", () -> {
                path(":nombre", () -> {
                    get(controller::buscarPorNombre);
                });
                path(":genero", () -> {
                    get(controller::buscarPorGenero)
                });
                path("plataforma", () -> {
                    get(controller::buscarPorPlataforma);
                });
                path("nombre", () -> {
                    path(":nombre", () -> {
                        get(controller::buscarJuegoPorNombre)
                    });
                });
            });
        });
    }
}
