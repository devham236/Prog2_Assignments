package assignment_05.conway.game;

import assignment_05.conway.component.CellType;

// 4
public class Seeds extends GameOfLife {

     /**
     *  Calculates the next generation of the current game state inplace with the default rule set
     */
    @Override
    public void calculateNextGeneration() {
        iteration++;
        CellType[][] nextGeneration = new CellType[generation.length][generation[0].length];

         for (int i = 0; i < generation.length;i++) {
            for (int j = 0; j < generation[i].length; j++) {
                int livingNeighbours = countLivingNeighbors(i, j);

                if (generation[i][j].getValue() == 0 && livingNeighbours == 2) {
                    // 3 living neighbours and dead cell
                    nextGeneration[i][j] = CellType.LIVING;
                } else if (generation[i][j].getValue() == 1) {
                    // living cell dies
                    nextGeneration[i][j] = CellType.DEAD;
                } else {
                    // nothing happens
                    nextGeneration[i][j] = generation[i][j];
                }

            }
         }

        generation = nextGeneration;
    }
}