package model;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class User {

    private String name;
    private String password;



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

}
