package assignment_03.jumpNrun;

/**
 * Represents the Non-Player Character (NPC) in the Jump 'n' Run game.
 * The NPC maintains a horizontal position and a state (standing or crouching),
 * which determines how it interacts with the environment and its movement speed.
 * @author Hamza Mirza
 */
public class NPC {
    private int xCoordinate;
    boolean isCrouching;

    /**
     * Constructs a new NPC with a specified position and a state.
     * @param x the initial x-coordinate of the NPC.
     * @param c the initial crouching state (true if crouching, false if standing).
     */
    public NPC(int x, boolean c){
        this.xCoordinate = x;
        this.isCrouching = c;
    }

    /**
     * Changes the NPC's state to standing.
     * This allows the NPC to perform actions restricted by crouching, such as dashing.
     */
    public void StandUp(){
        this.isCrouching = false;
    }

    /**
     * Changes the NPC's state to crouching.
     * This is typically used to pass under low-hanging air obstacles.
     */
    public void crouch(){
        this.isCrouching = true;
    }

    /**
     * Moves the NPC one unit to the right.
     * This movement is possible regardless of the crouching state.
     */
    public void walkRight(){
        this.xCoordinate += 1;
    }

    /**
     * Moves the NPC two units to the right in a single action.
     * Dashing is only possible if the NPC is not crouching.
     * If isCrouching is true, the NPC remains at his current state.
     */
    public void dashRight(){
        if(!isCrouching){
            this.xCoordinate += 2;
        }
    }

    /**
     * Retrieves the current horizontal position of the NPC.
     * @return the current x-coordinate.
     */
    public int getxCoordinate(){
        return this.xCoordinate;
    }

}
