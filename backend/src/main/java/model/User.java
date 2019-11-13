package model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class User {

    private String name;
    private String password;
    private String phote;
    private LocalDate suscriptionDate;


    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhote() {
        return phote;
    }

    public void setPhote(String phote) {
        this.phote = phote;
    }

    public LocalDate getSuscriptionDate() {
        return suscriptionDate;
    }

    public void setSuscriptionDate(LocalDate suscriptionDate) {
        this.suscriptionDate = suscriptionDate;
    }
}
