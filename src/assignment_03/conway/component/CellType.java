package assignment_03.conway.component;
import java.awt.Color;

public enum CellType {
    LIVING,
    DEAD;

    public int getValue() {
        return switch(this) {
            case LIVING -> 1;
            case DEAD -> 0;
        };
    }

    public Color getColor() {
        return switch(this) {
            case LIVING -> Color.green;
            case DEAD -> Color.gray;
        };
    }
}