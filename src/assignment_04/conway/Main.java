package assignment_04.conway;

import conway.gui.ConwayGUI;
import conway.game.GameOfLife;

public class Main {

    public static void main(String[] args) {
        
        GameOfLife gameOfLife = new GameOfLife(10);


        // Start configuration
        //gameOfLife.getGeneration()[1][2] = CellType.LIVING;
        //gameOfLife.getGeneration()[2][3] = CellType.LIVING;
        //gameOfLife.getGeneration()[3][1] = CellType.LIVING;
        //gameOfLife.getGeneration()[3][2] = CellType.LIVING;
        //gameOfLife.getGeneration()[3][3] = CellType.LIVING;

        int[] xStart = {1,2,3,3,3};
        int[] yStart = {2,3,1,2,3};
        gameOfLife.setup(xStart, yStart);

        // Optional grphical interface
        ConwayGUI gui = new ConwayGUI(gameOfLife);

        /*
        for (int i = 0; i < 10; i++) {
            gameOfLife.calculateNextGeneration();
            System.out.println("Iteration: " + gameOfLife.getIteration());
            System.out.println(gameOfLife);
            System.out.println("-----------------------------------------");
        }
        */
    }
    
}
