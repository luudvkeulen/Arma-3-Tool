package nl.luudvankeulen.arma3tool.models;

public class MapItem {
    private int iconId;
    private int pictureId;
    private String name;

    public int getIconId() {
        return iconId;
    }

    public int getPictureId() {
        return pictureId;
    }

    public String getName() {
        return name;
    }

    public MapItem(int iconId, int pictureId, String name) {
        this.iconId = iconId;
        this.pictureId = pictureId;
        this.name = name;
    }
}
