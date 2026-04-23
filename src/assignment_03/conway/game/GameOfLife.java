package assignment_03.conway.game;

import assignment_03.conway.component.CellType;

public class GameOfLife {

    private CellType[][] generation;
    private long iteration;


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

    private int countLivingNeighbors(int x, int y) {
        int result = 0;
        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                // skip cell itself
                if (i == x && j == y) continue;
                // skip negative indices and indices larger than size
                if (i < 0 || j < 0 || i >= generation.length || j >= generation[0].length) continue;

                result += generation[i][j].getValue();
            }
        }
        return result;
    }

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