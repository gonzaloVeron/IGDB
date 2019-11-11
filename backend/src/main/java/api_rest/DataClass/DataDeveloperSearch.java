package api_rest.DataClass;

import model.Developer;

public class DataDeveloperSearch {
    public Long id;
    public String name;
    public String lastName;
    public String image;

    public DataDeveloperSearch(Developer developer) {
        this.id = developer.getId();
        this.name = developer.getName();
        this.lastName = developer.getLastName();
        this.image = developer.getUrlPhoto();
    }
}
