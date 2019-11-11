package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Studio {
    @Id
    @Column(name = "studio_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String portada;
    private Date fechaDeFundacion;
    private Boolean estaActivo;

    @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "developers",
            joinColumns = @JoinColumn(name = "studio_id"),
            inverseJoinColumns = @JoinColumn(name = "deve_id"))
    private List<Developer> desarrolladoresActuales;

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "developers",
            joinColumns = @JoinColumn(name = "studio_id"),
            inverseJoinColumns = @JoinColumn(name = "deve_id"))
    private List<Developer> historicalDevelopers;



    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Game> juegosDesarrollados;



    public Studio(){
        this.desarrolladoresActuales = new ArrayList<>();

        this.juegosDesarrollados = new ArrayList<>();


        this.historicalDevelopers = new ArrayList<>();
    }
    public void addHistoricalDeveloper(Developer d){
        this.historicalDevelopers.add(d);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public Date getFechaDeFundacion() {
        return fechaDeFundacion;
    }

    public void setFechaDeFundacion(Date fechaDeFundacion) {
        this.fechaDeFundacion = fechaDeFundacion;
    }

    public Boolean getEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(Boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    public List<Game> getJuegosDesarrollados() {
        return juegosDesarrollados;
    }

    public void addJuego(Game game) {
        this.juegosDesarrollados.add(game);
    }

    public void addDeveloper(Developer developer){
        this.desarrolladoresActuales.add(developer);
    }
}
