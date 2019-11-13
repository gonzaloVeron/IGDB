package api_rest.DataClass;

import model.Studio;

public class DataStudioSearch {
    public Long id;
    public String name;
    public String logo;

    public DataStudioSearch(Studio studio) {
        this.id = studio.getId();
        this.name = studio.getName();
        this.logo = studio.getCoverPage();
    }
}
