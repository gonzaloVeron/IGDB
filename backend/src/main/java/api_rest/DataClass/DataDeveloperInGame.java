package api_rest.DataClass;

public class DataDeveloperInGame {

    public long id;
    public String name;
    public String lastName;
    public String imageUrl;

    public  DataDeveloperInGame(long id, String name, String lastName, String imageUrl){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
    }

}
