package api_rest.DataClass;

import model.User;

public class DataUserReturn {
    public Long id;
    public String name;

    public DataUserReturn(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}
