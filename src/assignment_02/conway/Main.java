package assignment_02.conway;

import assignment_02.conway.game.GameOfLife;

public class Main {
    public static void main(String[] args) {
        GameOfLife test = new GameOfLife(5, 5);

        test.field[1][2] = 1;
        test.field[2][3] = 1;
        test.field[3][1] = 1;
        test.field[3][2] = 1;
        test.field[3][3] = 1;


        for (int i = 0; i < 20; i++) {
            test.printGeneration(test.field);
            test.calculateNextGeneration();
        }

        System.out.println(test.toString());
    }
}
