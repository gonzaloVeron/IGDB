package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Developer {

    @Id
    @Column(name = "deve_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String urlPhoto;

    private LocalDate dateOfBirth;

    private String actuallyWorking;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    @JoinTable(name = "studios",
            joinColumns = @JoinColumn(name = "deve_id"),
            inverseJoinColumns = @JoinColumn(name = "studio_id"))
    private List<Studio> studies;

    @ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "studios",
            joinColumns = @JoinColumn(name = "deve_id"),
            inverseJoinColumns = @JoinColumn(name = "studio_id"))
    private List<Studio> previousStudies;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<Game> games;




    public Developer() {
        this.games = new ArrayList<Game>();
        this.studies = new ArrayList<Studio>();
        this.previousStudies = new ArrayList<>();

    }

    public void addPreviousStudies(Studio s){
        this.previousStudies.add(s);
    }

    public Long getId() {
        return id;
    }

    public void addStudy(Studio study) {
        studies.add(study);
    }

    public List<Studio> getCurrentStudios(){return this.studies;}

    public List<Studio> getStudies() {
        return this.previousStudies;
    }

    public void addGame(Game game) {

        games.add(game);
        game.addDevelopers(this);
    }

    public List<Game> getGames() {
        return games;
    }

    public String getActuallyWorking() {
        return this.actuallyWorking;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setActuallyWorking(String whereHeWorks) {
        this.actuallyWorking = whereHeWorks;
    }
}
