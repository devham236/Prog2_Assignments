package assignment_03.jumpNrun;

/**
 * The class manages the game world, including the level layout and
 * the game loop logic. It handles the placement of the games objects
 * and controls the interaction between the NPC and the environment.
 * @author Hamza Mirza
 */
public class GameView {
    GameObject[][] view = new GameObject[20][3];
    NPC npc = new NPC(0, false);

    /**
     * Creates a new instance of the Gameview class and initializes the games layout.
     * The layout includes, the NPC character, airobstacles, the ground and the goal of the game.
     * @author Hamza Mirza
     */
    public GameView(){
        view[0][2] = GameObject.GROUND;
        view[1][2] = GameObject.GROUND;
        view[2][2] = GameObject.GROUND;
        view[3][2] = GameObject.GROUND;
        view[4][2] = GameObject.LAVA;

        // loop für GGGL, was drei mal vorkommt
        for (int x = 5; x <= 16; x++) {
            if (x % 4 == 0) {
                view[x][2] = GameObject.LAVA;
            } else {
                view[x][2] = GameObject.GROUND;
            }
        }

        view[17][2] = GameObject.GROUND;
        view[18][2] = GameObject.GROUND;
        // Das letzte Feld in Zeile 2 ist das Ziel
        view[19][2] = GameObject.GOAL;

        // loop für Hindernisse in der ersten Zeile
        for (int x = 2; x < 20; x += 4) {
            view[x][0] = GameObject.AIROBSTACLE;
        }
    }

    /**
     * Generates a string representation of the current game state.
     * This method renders the 2D grid as a multi-line string. It
     * places the player character 'P' based on the NPC's current coordinates
     * and crouching state.
     * @return string which gets printed to console in the main function
     */
    public String str(){
        String output = "";

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 20; x++) {
                boolean isNpcX = (npc.getxCoordinate() == x);
                boolean isStandingBody = (y == 1 && isNpcX);
                boolean isStandingHead = (y == 0 && isNpcX && !npc.isCrouching);

                if (isStandingHead || isStandingBody) {
                    output += "P";
                } else {
                    GameObject obj = view[x][y];
                    if (obj != null) {
                        output += obj.getSymbol();
                    } else {
                        output += " ";
                    }
                }
            }
            output += "\n";
        }

        return output;
    }

    /**
     * Starts and manages the main game loop.
     * The loop continues until the NPC reaches the goal, falls into lava,
     * or moves out of bounds.
     * @author Hamza Mirza
     */
    public void play(){
        while(true){
            System.out.println(this.str());

            int npc_location = npc.getxCoordinate();

            if(npc_location >= 20){
                break;
            }

            GameObject current_location = view[npc_location][2];

            if(current_location == GameObject.LAVA){
                break;
            }
            else if(current_location == GameObject.GOAL){
                break;
            }

            GameObject nextAir = (npc_location + 1 < 20) ? view[npc_location + 1][0] : null;
            GameObject nextGround = (npc_location + 1 < 20) ? view[npc_location + 1][2] : null;

            if (nextAir == GameObject.AIROBSTACLE) {
                npc.crouch();
                npc.walkRight();
            }
            else if (nextGround == GameObject.LAVA) {
                if (npc.isCrouching) {
                    npc.StandUp();
                }
                npc.dashRight();
            }
            else {
                if (npc.isCrouching && (nextAir != GameObject.AIROBSTACLE)) {
                    npc.StandUp();
                }
                npc.walkRight();
            }
        }
    }
}
