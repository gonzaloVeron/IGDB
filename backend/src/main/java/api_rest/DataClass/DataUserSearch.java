package api_rest.DataClass;

import model.Review;
import model.User;

import java.util.List;
import java.util.stream.Collectors;

public class DataUserSearch {
    public Long id;
    public String name;
    public String photo;
    public List<DataReviewClass> myReviews;

    public DataUserSearch(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.photo = user.getPhoto();
        this.myReviews = user.getMyReviews().stream().map(e -> new DataReviewClass(e)).collect(Collectors.toList());
    }
}
