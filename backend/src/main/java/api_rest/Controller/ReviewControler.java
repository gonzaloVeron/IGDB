package api_rest.Controller;

import api_rest.DataClass.DataDeleteReview;
import dao.impl.HibernateGameDAO;
import dao.impl.HibernateUserDAO;
import io.javalin.Context;
import model.Game;
import model.Review;
import service.impl.GameServiceImpl;
import service.impl.ServiceUserimpl;
import service.interf.ServiceUser;

import java.util.stream.Collectors;

public class ReviewControler {
    private GameServiceImpl gameService = new GameServiceImpl(new HibernateGameDAO());
    private ServiceUser serviceUser = new ServiceUserimpl(new HibernateUserDAO());

    public void addReviewById(Context ctx){
        Game game = gameService.searchGameById(Long.parseLong(ctx.pathParam("id")));
        Review reviewData = ctx.bodyAsClass(Review.class);
        if(game.getMyReviews().stream().map(review -> review.getNameUser()).collect(Collectors.toList()).contains(reviewData.getNameUser())){
            //gameService.updateReviewGame(reviewData);
        }else {
            serviceUser.reviewGame(reviewData.getNameUser(), reviewData.getDescription(), reviewData.getStar(), reviewData.getNameGame());
        }
        ctx.status(200);
    }

    public void deleteReviewById(Context ctx){
        Long idGame = Long.parseLong(ctx.pathParam("id"));
        Long idUser = ctx.bodyAsClass(DataDeleteReview.class).userId;

        //serviceUser.deleteReviewGame(idUser ,idGame);

        ctx.status(200);
    }
}
