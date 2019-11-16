package api_rest.DataClass;

import model.Studio;

public class DataStudioInGame {
    public Long id;
    public String name;
    public String imageUrl;

    public DataStudioInGame(Studio studio){
        this.id = studio.getId();
        this.name = studio.getName();
        this.imageUrl = studio.getCoverPage();
    }

}
