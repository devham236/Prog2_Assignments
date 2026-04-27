package assignment_03.jumpNrun;

/**
 * Defines the types of objects that can occupy space within the Jump 'n' Run game field.
 * Each constant represents a specific element.
 * * @author Hamza
 */
public enum GameObject {
    /**
     * Represents the space the NPC can walk on
     */
    GROUND,

    /**
     * Represents space the NPC can not walk on (game will be over)
     */
    LAVA,

    /**
     * Represents object above NPC, which can be crouched under
     */
    AIROBSTACLE,

    /**
     * Represents empty object, where NPC can freely move on
     */
    EMPTY,

    /**
     * Represents the end of the game, game is over when NPC reaches it
     */
    GOAL;

    /**
     *  * Returns the character representation associated with the current game object.
     *  * This symbol is primarily used for simulating the game world in a text-based format.
     *  * @author Hamza Mirza
     */
    public char getSymbol(){
        switch(this){
            case GROUND -> {
                return 'G';
            }
            case LAVA -> {
                return 'L';
            }
            case AIROBSTACLE -> {
                return 'O';
            }
            case EMPTY -> {
                return ' ';
            }
            case GOAL -> {
                return 'Z';
            }
            default -> {
                return 'X';
            }
        }
    }
}
