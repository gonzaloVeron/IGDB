package model;

import javax.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;
    private Genre genre;
    private Platform platform;
    private String sinopsis;
    private String urlImage;

    public Game(){ }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String url){
        this.urlImage = url;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId(){ return this.id;}

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void addPlataforma(Platform platform) {

        this.platform = platform;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
