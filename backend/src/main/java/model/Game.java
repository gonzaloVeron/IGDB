package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private Genre genre;
    private Platform platform;
    private String sinopsis;
    private String urlImage;

    @ManyToOne
    private Studio studio;

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Developer>developers;

    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<String> videos;
    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<String> images;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<Review> myReviews;


    public void addDevelopers(Developer developer) {
        this.developers.add(developer);
    }

    public Game(){
        this.developers = new ArrayList<>();
        this.videos = new ArrayList<>();
        this.images = new ArrayList<>();
        this.myReviews = new ArrayList<>();
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String url){
        this.urlImage = url;
    }

    public String getName() {
        return name;
    }

    public Long getId(){ return this.id;}

    public void setName(String nombre) {
        this.name = nombre;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setPlatform(Platform p){
        this.platform = p;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void addPlataform(Platform platform) {

        this.platform = platform;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void addVideo(String video){ this.videos.add(video); }

    public void removeVideo(String video){ this.videos.remove(video); }

    public List<String> getVideos() { return this.videos; }

    public void addImage(String image) { this.images.add(image); }

    public void removeImage(String image) { this.images.remove(image); }

    public List<String> getImages() { return this.images; }

    public List<Review> getMyReviews() {
        return myReviews;
    }

    public void addReview(Review review){
        this.myReviews.add(review);
        review.setGame(this);
    }

    public void removeReview(Review review) {
        this.myReviews.remove(review);
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
