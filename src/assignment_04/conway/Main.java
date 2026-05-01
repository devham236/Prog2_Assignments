package assignment_04.conway;
import java.util.Scanner;
import assignment_04.conway.game.Seeds;
import assignment_04.conway.gui.ConwayGUI;
import assignment_04.conway.game.GameOfLife;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean with_gui = false;

        for (int i = 0; i < args.length; i++) {
            if(args[i].equals("--gui")){
                with_gui = true;
                break;
            }
        }

        GameOfLife gameOfLife;
        int generations = 0;

        if (with_gui){
            gameOfLife = new Seeds(30);
        } else {
            System.out.print("Enter size of field: ");
            int input = scanner.nextInt();

            System.out.print("Enter number of generations: ");
            generations = scanner.nextInt();

            gameOfLife = new GameOfLife(input);
        }


        // Start configuration
        //gameOfLife.getGeneration()[1][2] = CellType.LIVING;
        //gameOfLife.getGeneration()[2][3] = CellType.LIVING;
        //gameOfLife.getGeneration()[3][1] = CellType.LIVING;
        //gameOfLife.getGeneration()[3][2] = CellType.LIVING;
        //gameOfLife.getGeneration()[3][3] = CellType.LIVING;


        int[] xStart = {1,2,3,3,3};
        int[] yStart = {2,3,1,2,3};
        gameOfLife.setup(xStart, yStart);

        // Optional graphical interface
        if (with_gui){
            ConwayGUI gui = new ConwayGUI(gameOfLife);
        }

        if(!with_gui && generations > 0){
            for (int i = 0; i < generations; i++) {
                gameOfLife.calculateNextGeneration();
                System.out.println("Iteration: " + gameOfLife.getIteration());
                System.out.println(gameOfLife);
                System.out.println("-----------------------------------------");
            }
        }

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
