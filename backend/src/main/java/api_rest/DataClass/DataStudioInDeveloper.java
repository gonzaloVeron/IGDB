package api_rest.DataClass;

import model.Studio;

public class DataStudioInDeveloper {
    public Long id;
    public String name;
    public String logo;

    public DataStudioInDeveloper(Studio studio) {
        id = studio.getId();
        name = studio.getName();
        logo = studio.getCoverPage();
    }
}
