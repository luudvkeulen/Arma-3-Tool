package nl.luudvankeulen.arma3tool.models;

import nl.luudvankeulen.arma3tool.enums.DLCType;
import nl.luudvankeulen.arma3tool.enums.WeaponType;

public class WeaponItem {
    private String name;
    private int pictureId;
    private WeaponType weaponType;
    private DLCType dlcType;

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
        this.dlcType = DLCType.NONE;
    }

    public WeaponItem(String name, int pictureId, WeaponType weaponType, DLCType dlcType) {
        this.name = name;
        this.pictureId = pictureId;
        this.weaponType = weaponType;
        this.dlcType = dlcType;
    }
}
