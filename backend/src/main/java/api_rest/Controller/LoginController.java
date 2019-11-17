package api_rest.Controller;

import api_rest.DataClass.DataUser;
import dao.impl.HibernateUserDAO;
import jdk.nashorn.internal.runtime.JSONFunctions;
import model.User;
import service.impl.ServiceUserimpl;
import service.interf.ServiceUser;

import io.javalin.Context;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController {

    ServiceUser serviceUser = new ServiceUserimpl(new HibernateUserDAO());

    public User logearUsuario(User user) {
        serviceUser.createUser(user);

        return user;
    }

    /*
    La contraseña debe tener al entre 8 y 16 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula.
    NO puede tener otros símbolos.
            Ejemplo: w3Unpocodet0d0 */

    public Context login(Context ctx) throws Exception {
        DataUser dataUser = ctx.bodyAsClass(DataUser.class);
        Pattern pattern = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{4,16}$");
        Boolean match = pattern.matcher(dataUser.password).matches();

        this.require(dataUser.name.isEmpty(), "Invalid name!");
        this.require(!match,"Invalid password!");
        this.require(dataUser.password.isEmpty(), "Invalid password!");

        User user = serviceUser.searchByName(dataUser.name);

        this.require(!user.getName().equals(dataUser.name) && !user.getPassword().equals(dataUser.password), "Invalid name or password!");

        return ctx.json(dataUser);
    }

    public void register(Context ctx) throws Exception {
        DataUser dataUser = ctx.bodyAsClass(DataUser.class);

        Pattern pattern = Pattern.compile("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{4,16}$");
        Boolean match = pattern.matcher(dataUser.password).matches();

        this.require(dataUser.name.isEmpty(), "missing a name");
        this.require(!match,"Invalid password!" );
        this.require(dataUser.password.isEmpty(), "missing a password");

        User user = new User(dataUser.name, dataUser.password);

        serviceUser.createUser(user);

        ctx.result("Registered user");
    }

    public void require(boolean bool, String messageException) throws Exception {
        if(bool){
            throw new IllegalArgumentException(messageException);
        }
    }
}
