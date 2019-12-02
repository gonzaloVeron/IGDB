package api_rest.DataClass;

import model.Review;

public class DataReviewClass {
    public Long id;
    public String description;
    public
    int score;
    public String nameUser;
    public Long userID;
    public String nameGame;
    public Long gameID;
    public String imageUrl;

    public DataReviewClass(Review review) {
        this.id = review.getId();
        this.description = review.getDescription();
        this.score = review.getStar();
        this.nameUser = review.getUser().getName();
        this.userID = review.getUser().getId();
        this.nameGame = review.getGame().getName();
        this.gameID = review.getGame().getId();
        this.imageUrl = review.getUser().getPhoto();
    }
}
