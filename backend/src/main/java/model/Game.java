package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
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

    public Game(){
        this.developers = new ArrayList<>();
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

    public void addDevelopers(Developer developer) {
        this.developers.add(developer);
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
}
