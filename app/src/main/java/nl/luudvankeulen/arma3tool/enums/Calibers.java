package nl.luudvankeulen.arma3tool.enums;

public enum Calibers {
    POINT338(".338 Norma Magnum"),
    POINT556STANAG("5.56mm 30rnd STANAG"),
    POINT556DUALPURPOSE("5.56mm Dual Purpose"),
    POINT65STANAG("6.5mm STANAG"),
    POINT65CASELESS("6.5mm STANAG"),
    POINT762("7.62mm"),
    POINT408(".408 LRR"),
    POINT127("12.7mm"),
    POINT9("9mm"),
    ROCKET("Rocket"),
    MISSILE("Missile"),
    POINT40("40mm"),
    POINT45(".45 ACP"),
    POINT58("5.8mm"),
    POINT50(".50 BW"),
    POINT545("5.45mm");

    private final String name;

    Calibers(String s) {
        this.name = s;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
