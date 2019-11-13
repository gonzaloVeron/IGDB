package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Studio {
    @Id
    @Column(name = "studio_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String coverPage;
    private LocalDate fundationDate;
    private String isActive;

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "developers",
            joinColumns = @JoinColumn(name = "studio_id"),
            inverseJoinColumns = @JoinColumn(name = "deve_id"))
    private List<Developer> currentDevelopers;

    @ManyToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "developers",
            joinColumns = @JoinColumn(name = "studio_id"),
            inverseJoinColumns = @JoinColumn(name = "deve_id"))
    private List<Developer> historicalDevelopers;

    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Game> developedGames;

    public Studio(){
        this.currentDevelopers = new ArrayList<>();

        this.developedGames = new ArrayList<>();

        this.historicalDevelopers = new ArrayList<>();
    }

    public void addHistoricalDeveloper(Developer d){
        this.historicalDevelopers.add(d);
    }

    public List<Developer> getHistoricalDevelopers() {
        return this.historicalDevelopers;
    }

    public List<Developer> desarrolladoresActuales(){
        return this.currentDevelopers;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

    public String getCoverPage() {
        return coverPage;
    }

    public void setCoverPage(String portada) {
        this.coverPage = portada;
    }

    public LocalDate getFundationDate() {
        return fundationDate;
    }

    public void setFundationDate(LocalDate fechaDeFundacion) {
        this.fundationDate = fechaDeFundacion;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String estaActivo) {
        this.isActive = estaActivo;
    }

    public List<Game> getDevelopedGames() {
        return developedGames;
    }

    public void addGame(Game game) {

        this.developedGames.add(game);
        game.setStudio(this);
    }

    public void addDeveloper(Developer developer){
        this.currentDevelopers.add(developer);
    }
}
