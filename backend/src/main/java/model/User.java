package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @Column(name = "studio_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<Review> myReviews;



    public User(){
        myReviews = new ArrayList<>();

    }

    public User(String name, String password){
        this.name = name;
        this.password = password;
        myReviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Long getId(){ return this.id; }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Review> getMyReviews() {
        return myReviews;
    }
    public void addReview(Review review){
        this.myReviews.add(review);
        review.setUser(this);
    }

    public void removeReview(Review review) {
        this.myReviews.remove(review);
    }
}
