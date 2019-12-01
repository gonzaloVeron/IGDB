package api_rest.DataClass;

public class DataUserLogin {
    public String name;
    public String password;

    public DataUserLogin() {}

    public DataUserLogin(String name, String  password){
        this.name = name;
        this.password = password;
    }
}
