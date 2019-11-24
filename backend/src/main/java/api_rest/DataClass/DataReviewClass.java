package api_rest.DataClass;

public class DataReviewClass {
    public Long id;
    public String description;
    public int star;
    public String nameUser;
    public String nameGame;

    public DataReviewClass(Long id, String description, int star, String nameUser, String nameGame) {
        this.id = id;
        this.description = description;
        this.star = star;
        this.nameUser = nameUser;
        this.nameGame = nameGame;
    }
}
