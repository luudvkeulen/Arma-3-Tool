package nl.luudvankeulen.arma3tool.models;

import nl.luudvankeulen.arma3tool.WeaponType;

public class WeaponItem {
    private String name;
    private int pictureId;
    private WeaponType weaponType;

    public String getName() {
        return name;
    }

    public int getPictureId() {
        return pictureId;
    }

    public WeaponItem(String name, int pictureId, WeaponType weaponType) {
        this.name = name;
        this.pictureId = pictureId;
        this.weaponType = weaponType;
    }
}
