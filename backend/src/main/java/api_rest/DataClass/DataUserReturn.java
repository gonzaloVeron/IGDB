package api_rest.DataClass;

import model.User;

public class DataUserReturn {
    public Long id;
    public String name;
    public String userImage;
    public String registerDate;

    public DataUserReturn(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.userImage = user.getPhoto();
        this.registerDate = user.getRegisterDate().toString();
    }
}
