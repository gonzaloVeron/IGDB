package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
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

    private Date dateOfBirth;

    private Boolean actuallyWorking;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    @JoinTable(name = "estudios",
            joinColumns = @JoinColumn(name = "deve_id"),
            inverseJoinColumns = @JoinColumn(name = "study_id"))
    private List<Study> studies;

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "estudios",
            joinColumns = @JoinColumn(name = "deve_id"),
            inverseJoinColumns = @JoinColumn(name = "study_id"))
    private List<Study> previousStudies;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SELECT)
    private List<Game> games;




    public Developer() {
        this.games = new ArrayList<Game>();
        this.studies = new ArrayList<Study>();
        this.previousStudies = new ArrayList<>();

    }

    public void addPreviousStudies(Study s){
        this.previousStudies.add(s);
    }

    public Long getId() {
        return id;
    }

    public void addStudy(Study study) {
        studies.add(study);
    }

    public List<Study> getStudies() {
        return studies;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public List<Game> getGames() {
        return games;
    }

    public Boolean getActuallyWorking() {
        return actuallyWorking;
    }

    public Date getDateOfBirth() {
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

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setActuallyWorking(Boolean actuallyWorking) {
        this.actuallyWorking = actuallyWorking;
    }
}
