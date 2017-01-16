package nl.luudvankeulen.arma3tool.enums;

public enum DLCType {
    NONE("Base game"),
    APEX("Apex DLC"),
    KARTS("Karts DLC"),
    MARKSMEN("Marksmen DLC"),
    HELICOPTER("Helicopter DLC");

    private final String name;

    DLCType(String s) {
        this.name = s;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
