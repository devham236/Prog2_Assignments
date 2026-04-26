package assignment_03.jumpNrun;

public class GameView {
    GameObject[][] view = new GameObject[20][3];
    NPC npc = new NPC(0, false);

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

            // 3. Logik-Kette (Reihenfolge ist hier entscheidend!)

            if (nextAir == GameObject.AIROBSTACLE) {
                npc.crouch();
                npc.walkRight();
            }
            else if (nextGround == GameObject.LAVA) {
                // Wenn Lava kommt, MUSS er dashen, um nicht reinzufallen.
                // Falls er noch geduckt war, sollte er vorher aufstehen.
                if (npc.isCrouching) {
                    npc.StandUp();
                }
                npc.dashRight();
                // dashRight() bringt ihn von x=7 direkt auf x=9 (über die Lava bei x=8 drüber)
            }
            else {
                // Wenn er kriecht, aber kein Hindernis mehr über ihm ist, sollte er aufstehen
                if (npc.isCrouching && (nextAir != GameObject.AIROBSTACLE)) {
                    npc.StandUp();
                }
                npc.walkRight();
            }
        }
    }
}
