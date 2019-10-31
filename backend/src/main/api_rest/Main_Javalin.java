import io.javalin.Javalin;

public class Main_Javalin {

    public static void main(String[] args){
        Javalin app = Javalin.create().start(7777);
        app.get("/", ctx -> ctx.result("Hello Javalin"));
    }

}
