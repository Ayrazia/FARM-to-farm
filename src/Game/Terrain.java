package Game;

import java.io.Serializable;

public class Terrain implements Serializable {
    private static int counter = 0;
    private int idTerrain;
    private String nameTerrain;
    private String typeTerrain;
    private String status;

    public Terrain(String typeTerrain) {
        this.idTerrain = counter++;
        this.nameTerrain = typeTerrain;
        this.typeTerrain = typeTerrain;
        this.status = "TerrainLibre";
    }

    public int getIdTerrain() {
        return idTerrain;
    }

    public String getNameTerrain() {
        return nameTerrain;
    }

    public String getTypeTerrain() {
        return typeTerrain;
    }

    public String getStatus() {
        return status;
    }

    public void setIdTerrain(int idTerrain) {
        this.idTerrain = idTerrain;
    }

    public void setNameTerrain(String nameTerrain) {
        this.nameTerrain = nameTerrain;
    }

    public void setTypeTerrain(String typeTerrain) {
        this.typeTerrain = typeTerrain;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}