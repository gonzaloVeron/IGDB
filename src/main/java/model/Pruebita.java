package model;

import javax.persistence.*;

@Entity
public class Pruebita {

    @Id
    @Column(name = "id", nullable = false, unique = true, length=190)
    int idPruebita;

    public Pruebita(int idPruebita){
        this.idPruebita = idPruebita;
    }

    public Pruebita(){}

}
