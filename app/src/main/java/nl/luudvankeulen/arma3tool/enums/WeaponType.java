package nl.luudvankeulen.arma3tool.enums;

public enum WeaponType {
    HANDGUN("Handgun"),
    SMG("Submachine gun"),
    RIFLE("Rifle"),
    DMR("DMR"),
    SNIPER("Sniper rifle"),
    MACHINEGUN("Machine gun"),
    LAUNCHER("Launcher");

    private final String name;

    WeaponType(String s) {
        this.name = s;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
