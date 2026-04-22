package assignment_03.conway;

import conway.gui.ConwayGUI;
import conway.game.GameOfLife;

public class Main {

    public static void main(String[] args) {
        
        GameOfLife gameOfLife = new GameOfLife(15);


        // Start configuration
        gameOfLife.getGeneration()[1][2] = 1;
        gameOfLife.getGeneration()[2][3] = 1;
        gameOfLife.getGeneration()[3][1] = 1;
        gameOfLife.getGeneration()[3][2] = 1;
        gameOfLife.getGeneration()[3][3] = 1;

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
