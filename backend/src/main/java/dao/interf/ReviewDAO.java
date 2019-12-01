package dao.interf;

import model.Review;

public interface ReviewDAO {
    void save(Review review);
    void update(Review review);
    Review recover(Long id);

}
