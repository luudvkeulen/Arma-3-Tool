package nl.luudvankeulen.arma3tool.enums;

public enum WeaponType {
    NONE("All weapons"),
    HANDGUN("Handguns"),
    SMG("Submachine guns"),
    RIFLE("Rifles"),
    DMR("DMR's"),
    SNIPER("Sniper rifles"),
    MACHINEGUN("Machine guns"),
    LAUNCHER("Launchers");

    private final String name;

    WeaponType(String s) {
        this.name = s;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
