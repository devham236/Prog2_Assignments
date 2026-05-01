package assignment_04.conway.component;

import java.awt.Color;

/**
 * Represents a cell type by the states dead or living each with an integer value
 */
public enum CellType {
    DEAD(0, Color.WHITE),
    LIVING(1, Color.BLACK);

    private final int value;
    private final Color color;

    private CellType(int value, Color color) {
        this.value = value;
        this.color = color;
    }

    public int getValue() {
        return this.value;
    }

    public Color getColor() {
        return this.color;
    }
}