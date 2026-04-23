package assignment_03.conway;

import assignment_03.conway.component.CellType;
import assignment_03.conway.gui.ConwayGUI;
import assignment_03.conway.game.GameOfLife;

public class Main {

    public static void main(String[] args) {
        
        GameOfLife gameOfLife = new GameOfLife(15);


        // Start configuration
        gameOfLife.getGeneration()[0][0] = CellType.LIVING;
        gameOfLife.getGeneration()[14][0] = CellType.LIVING;
        gameOfLife.getGeneration()[1][0] = CellType.LIVING;
        gameOfLife.getGeneration()[3][2] = CellType.DEAD;
        gameOfLife.getGeneration()[3][3] = CellType.DEAD;

        int[] test1 = {0, 0, 1, 1};
        int[] test2 = {0, 1, 0, 1};
        gameOfLife.setup(test1, test2);

        System.out.printf("Living neighbors: %d", gameOfLife.countLivingNeighbors(0, 0));

        // Optional graphical interface
        ConwayGUI gui = new ConwayGUI(gameOfLife);

        /**
        for (int i = 0; i < 10; i++) {
            gameOfLife.calculateNextGeneration();
            System.out.println("Iteration: " + gameOfLife.getIteration());
            System.out.println(gameOfLife);
            System.out.println("-----------------------------------------");
        }
        */

    }
    
}
