package api_rest.Controller;

import api_rest.DataClass.DataDeleteReview;
import api_rest.DataClass.DataNewReview;
import api_rest.Exceptions.ElementAlreadyExistsException;
import dao.impl.HibernateGameDAO;
import dao.impl.HibernateUserDAO;
import io.javalin.Context;
import model.Game;
import model.User;
import service.impl.GameServiceImpl;
import service.impl.ServiceUserimpl;
import service.interf.ServiceUser;

public class ReviewController {
    private GameServiceImpl gameService = new GameServiceImpl(new HibernateGameDAO());
    private ServiceUser serviceUser = new ServiceUserimpl(new HibernateUserDAO());

    public void addReviewById(Context ctx) throws ElementAlreadyExistsException {
        Game game = gameService.searchGameById(Long.parseLong(ctx.pathParam("id")));
        DataNewReview reviewData = ctx.bodyAsClass(DataNewReview.class);
        if(game.getMyReviews().stream().anyMatch(review -> review.getUser().getId().equals(reviewData.userID))){
            throw new ElementAlreadyExistsException();
        }else {
            User user = serviceUser.searchUser(reviewData.userID);
            serviceUser.reviewGame(user.getId(), reviewData.description, reviewData.score, game.getId());
            ctx.status(200);
        }
    }

    public void deleteReviewById(Context ctx){
        Long idGame = Long.parseLong(ctx.pathParam("id"));
        Long idUser = ctx.bodyAsClass(DataDeleteReview.class).userId;

        serviceUser.deleteReview(idUser ,idGame);

        ctx.status(200);
    }
}
