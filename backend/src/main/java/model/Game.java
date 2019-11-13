package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<String> videos;
    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<String> images;

    public Game(){
        this.videos = new ArrayList<>();
        this.images = new ArrayList<>();
    }

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

    public void addVideo(String video){ this.videos.add(video); }

    public void removeVideo(String video){ this.videos.remove(video); }

    public List<String> getVideos() { return this.videos; }

    public void addImage(String image) { this.images.add(image); }

    public void removeImage(String image) { this.images.remove(image); }

    public List<String> getImages() { return this.images; }
}
