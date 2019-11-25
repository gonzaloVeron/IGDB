package model;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private int star;
    @ManyToOne
    private User user;
    @ManyToOne
    private Game game;

    public Review(){

    }

    public Long getId(){
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame(){return this.game;}

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){return this.user;}
}
