package com.nenrys.mutroleum.species;

public enum OrganismColor {
    WHITE(0xf9ffff), LIGHT_GRAY(0x9c9d97), GRAY(0x474f52), BLACK(0x1d1c21),
    PINK(0x38caa), RED(0xb02e26), MAGENTA(0xc64fbd), PURPLE(0x8932b7),
    BLUE(0x3c44a9), LIGHT_BLUE(0x3ab3da), CYAN(0x169c9d), GREEN(0x5d7c15),
    LIME(0x80c71f), YELLOW(0xffd83d), ORANGE(0xf9801d), BROWN(0x825432);

    public int hexcol;
    private OrganismColor(int hexcol) {
        this.hexcol=hexcol;
    }
}
