package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Study {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String portada;
    private Date fechaDeFundacion;
    private Boolean estaActivo;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Developer> desarrolladoresActuales;

    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Developer> desarrolladoresHistoricos;


    @OneToMany(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Game> juegosDesarrolladros;



    public Study(){
        this.desarrolladoresActuales = new ArrayList<>();
        this.desarrolladoresHistoricos = new ArrayList<>();
        this.juegosDesarrolladros = new ArrayList<>();
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

    public List<Game> getJuegosDesarrolladros() {
        return juegosDesarrolladros;
    }

    public void addJuego(Game game) {
        this.juegosDesarrolladros.add(game);
    }

    public void addDeveloper(Developer developer){
        this.desarrolladoresActuales.add(developer);
    }
}
