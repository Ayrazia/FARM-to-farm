package Game;

import java.io.Serializable;

public class TerrainLibre extends Terrain implements Serializable {
    private boolean isCultivated;

    public TerrainLibre() {
        super("Terrain Libre");
        this.isCultivated = false;  // Un terrain libre est initialement non cultivé
    }

    public boolean isCultivated() {
        return isCultivated;
    }

    public void setCultivated(boolean cultivated) {
        isCultivated = cultivated;
    }
}
