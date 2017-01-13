package nl.luudvankeulen.arma3tool.models;

public class WeaponItem {
    public String name;
    public int pictureId;

    public String getName() {
        return name;
    }

    public int getPictureId() {
        return pictureId;
    }

    public WeaponItem(String name, int pictureId) {
        this.name = name;
        this.pictureId = pictureId;
    }
}
