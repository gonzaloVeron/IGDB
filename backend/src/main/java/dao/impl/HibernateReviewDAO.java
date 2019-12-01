package dao.impl;

import dao.interf.ReviewDAO;
import model.Review;

public class HibernateReviewDAO extends HibernateDAO<Review>  implements ReviewDAO {
    public HibernateReviewDAO() {
        super(Review.class);
    }
}
