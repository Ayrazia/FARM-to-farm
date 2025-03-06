package Game;

import java.io.Serializable;

public class TerrainUser extends Terrain implements Serializable {
    private String cropType;

    public TerrainUser() {
        super("Terrain User");
        this.cropType = "Aucune culture";
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }
}
