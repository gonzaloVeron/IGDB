package model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Prueba {

    @Id
    @Column(name = "id", nullable = false, unique = true, length=190)
    private int idPrueba;

    private String nombre;

    private int edad;

    public Prueba(String nombre, int edad, int idPrueba){
        this.nombre = nombre;
        this.edad = edad;
        this.idPrueba = idPrueba;
    }

    public Prueba(){

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdPrueba(int idPrueba) {
        this.idPrueba = idPrueba;
    }

    public int getIdPrueba() {
        return idPrueba;
    }

}
