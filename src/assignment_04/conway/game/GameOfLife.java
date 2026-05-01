package assignment_04.conway.game;

import assignment_04.conway.component.CellType;

/**
 *  Represents a single game of conways game of life with default rules
 */
public class GameOfLife {

    protected CellType[][] generation;
    protected long iteration;

    /**
     * Creates a new game with size N X N and empty configuration
     * @param size the size of the board 
     */
    public GameOfLife(int size) {
        this.generation = new CellType[size][size];
        iteration = 0L;

        // init of the grid
        for (int i = 0; i < generation.length;i++) {
            for (int j = 0; j < generation[i].length; j++) {
                generation[i][j] = CellType.DEAD;
            } 
        }
    }

    /**
     * Counts the number of living neighbours in a 3x3 grid around the given point.
     * With border overflow.
     * @param x the x-coordinate of the point
     * @param y the y-coordinate
     * @return number of living nbeighbours excluding the cell at (x,y)
     */
    protected int countLivingNeighbors(int x, int y) {
        int result = 0;
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                // skip cell itself
                if (i == x && j == y) continue;
            
                // border overflow handled with modulo
                result += generation[(i + generation.length) % generation.length][(j + generation[0].length) % generation[0].length].getValue();
            }
        }
        // System.out.println("Result (" + x + "|" + y + "): " + result);
        return result;
    }

    /**
     *  Calculates the next generation of the curren game state inplace with the default rule set
     */
    public void calculateNextGeneration() {
        iteration++;
        CellType[][] nextGeneration = new CellType[generation.length][generation[0].length];

         for (int i = 0; i < generation.length;i++) {
            for (int j = 0; j < generation[i].length; j++) {
                int livingNeighbours = countLivingNeighbors(i, j);

                if (generation[i][j].getValue() == 0 && livingNeighbours == 3) {
                    // 3 living neighbours and dead cell
                    nextGeneration[i][j] = CellType.LIVING;
                } else if (generation[i][j].getValue() == 1 && (livingNeighbours < 2 || livingNeighbours > 3)) {
                    // living cell dies
                    nextGeneration[i][j] = CellType.DEAD;
                } else {
                    // case cell is dead and not exactly 3 living neighbours -> cell dead in next step
                    // case cell lives but has 2 or 3 living neighbours -> cell does not die
                    nextGeneration[i][j] = generation[i][j];
                }

            }
         }

        generation = nextGeneration;
    }

    public CellType[][] getGeneration() {
        return this.generation;
    }

    public Long getIteration() {
        return iteration;
    }

    /**
     * Given a set of indices x and y as list, this method sets these cells to living
     * @param x the set of x indices
     * @param y the set of y indices
     */
    public void setup(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] < 0 || y[i] < 0 || x[i] >= generation.length || y[i] >= generation[0].length) continue;
            generation[x[i]][y[i]] = CellType.LIVING;
        }
    }


    public String toString() {
        String result = "";
        for (int i = 0; i < generation.length;i++) {
            for (int j = 0; j < generation[i].length; j++) {
                result += generation[i][j].getValue();
                if (j + 1 != generation.length) result += " ";
            }
            result += "\n";
        } 
        return result;
    }
}