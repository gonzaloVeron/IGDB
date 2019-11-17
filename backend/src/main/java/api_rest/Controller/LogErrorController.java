package api_rest.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogErrorController {
    public List<IllegalArgumentException> listaDeErrores = new ArrayList <IllegalArgumentException>();
    public List<NullPointerException> listaDeNullPointerException = new ArrayList <NullPointerException>();

    public void log(IllegalArgumentException err) {
        this.listaDeErrores.add(err);
        System.out.println("error: ===============>");
        System.out.println(new Date().toString());
        System.out.println("-----------------------");
        System.out.println(err.getMessage());
        System.out.println("<=====================>");
    }

     public void  logNullPointerException(NullPointerException err){
        listaDeNullPointerException.add(err);

        System.out.println("error: ===============>");
        System.out.println(new Date().toString());
        System.out.println("-----------------------");
        System.out.println(err);
        System.out.println("<=====================>");
    }
}
