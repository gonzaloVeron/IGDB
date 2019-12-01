package api_rest.DataClass;

import model.Review;
import model.User;

import java.util.List;

public class DataUserSearch {
    public Long id;
    public String name;
    public String photo;
    public List<Review> myReviews;

    public DataUserSearch(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.photo = user.getPhoto();
        this.myReviews = user.getMyReviews();
    }
}
