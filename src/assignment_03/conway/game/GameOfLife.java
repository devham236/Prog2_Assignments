package assignment_03.conway.game;

import assignment_03.conway.component.CellType;

public class GameOfLife {

    private CellType[][] generation;
    private long iteration;

    /**
     * Constructs a new field for Conway's Game of Life
     * Modifies the current generation to be a field of given parameter size, where each cell is dead.
       Also resets the iteration to 0.
     * @author Hamza Mirza
     * @param size describes how big the field should be
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
     * Counts the living neighbors of given coordinate and those beyond the eadge
     * Loops through the rows and cols above/under the given coordinate and counts the living neighbors
       and also checks if living neighbors exist on the other side of given coordinate,
       when the coordinate itself is on the edge of one side.
     * @author Hamza Mirza
     * @param x col coordinate
     * @param y row coordinate
     * @return int the count of living neighbors
     */
    public int countLivingNeighbors(int x, int y) {
        int result = 0;
        int rows = generation.length;
        int cols = generation[0].length;

        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                // skip cell itself
                if (i == x && j == y) continue;
                // skip negative indices and indices larger than size
                int neighborX = (i + rows) % rows;
                int neighborY = (j + cols) % cols;

                result += generation[neighborX][neighborY].getValue();
            }
        }
        return result;
    }

    public void setup(int[] x, int[] y) {
        for (int i = 0; i < x.length; i++) {
            generation[x[i]][y[i]] = CellType.LIVING;
        }
    }

    /**
     * Determines the next Generation of cells, based on the current generation
     * Loops through each cell in the field and checks whether the dead or living cell should be dead or alive in
       the next generation, based on conditions provided by the game rules.
       Also keeps track of the iteration count and increases by one every time function is called.
     * @author Hamza Mirza
     */
    public void calculateNextGeneration() {
        iteration++;
        CellType[][] nextGeneration = new CellType[generation.length][generation[0].length];

         for (int i = 0; i < generation.length;i++) {
            for (int j = 0; j < generation[i].length; j++) {
                int livingNeighbours = countLivingNeighbors(i, j);

                if (generation[i][j] == CellType.DEAD && livingNeighbours == 3) {
                    // 3 living neighbours and dead cell
                    nextGeneration[i][j] = CellType.LIVING;
                } else if (generation[i][j] == CellType.LIVING && (livingNeighbours < 2 || livingNeighbours > 3)) {
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

    public String toString() {
        String result = "";
        for (int i = 0; i < generation.length;i++) {
            for (int j = 0; j < generation[i].length; j++) {
                result += generation[i][j];
                if (j + 1 != generation.length) result += " ";
            }
            result += "\n";
        } 
        return result;
    }
}