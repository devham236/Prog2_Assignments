package assignment_05.conway;

import conway.game.Seeds;
import conway.game.GameOfLife;

import java.util.Scanner;

import conway.gui.ConwayGUI;

public class Main {

    public static void main(String[] args) {
        
        
        int[] xStart = {1,2,3,3,3};
        int[] yStart = {2,3,1,2,3};

        // 4
        GameOfLife gameOfLife;
        
        if (args.length > 0 && args[0].equals("--gui")) {
            gameOfLife = new Seeds();

            gameOfLife.setUp(xStart, yStart);

            ConwayGUI gui = new ConwayGUI(gameOfLife);
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Spielfeldgröße: ");
            int size = Math.max(sc.nextInt(), 10);
            System.out.print("Iterationsanzahl: ");
            int iteration = Math.max(sc.nextInt(), 5);

            gameOfLife = new GameOfLife(size);
            gameOfLife.setUp(xStart, yStart);

            for (int i = 0; i < iteration; i++) {
                gameOfLife.calculateNextGeneration();
                System.out.println("Iteration: " + gameOfLife.getIteration());
                System.out.println(gameOfLife);
                System.out.println("-----------------------------------------");
            }
        
            sc.close();
        }
       

       
    }
    
}
