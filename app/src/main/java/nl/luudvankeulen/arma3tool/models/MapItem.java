package nl.luudvankeulen.arma3tool.models;

public class MapItem {
    private int pictureId;
    private String name;

    public int getPictureId() { return pictureId; }

    public String getName() { return name; }

    public MapItem(int pictureId, String name) {
        this.pictureId = pictureId;
        this.name = name;
    }
}
