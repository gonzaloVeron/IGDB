package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

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

    }

    public void deleteReview(Long id){
        int n = 0;
        Iterator<Review> iterator = this.myReviews.iterator();
        while (iterator.hasNext()){
            Review review1 = iterator.next();
            if(!review1.getId().equals(id)){
                n++;
            }
        }
        Review review = this.myReviews.get(n);
        this.myReviews.remove(review);

    }

}
