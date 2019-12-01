package api_rest.Controller;

import api_rest.DataClass.DataUserChangePhoto;
import dao.impl.HibernateUserDAO;
import model.User;
import service.impl.ServiceUserimpl;
import service.interf.ServiceUser;
import io.javalin.Context;

public class UserController {
    private ServiceUser serviceUser = new ServiceUserimpl(new HibernateUserDAO());

    public void changePhotoUser(Context ctx){
        Long idUser = Long.parseLong(ctx.pathParam("id"));
        DataUserChangePhoto userPhoto = ctx.bodyAsClass(DataUserChangePhoto.class);

        serviceUser.changeProfilePhoto(idUser, userPhoto.photo);

        ctx.status(200);
    }
}
