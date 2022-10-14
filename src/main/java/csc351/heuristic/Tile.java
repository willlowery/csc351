package csc351.heuristic;

import java.util.Random;

public enum Tile {
    HOUSE("H"),
    STORE("S"),
    OFFICE("O"),
    PARK("P"),
    FACTORY("F"),
    EMPTY("_")
    ;

    String tile;

    Tile(String tile) {
        this.tile = tile;
    }

    private static Random r = new Random();

    public static Tile random() {
        int t = r.nextInt(Tile.values().length);
        return Tile.values()[t];
    }
}
