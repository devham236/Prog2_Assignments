package assignment_03.conway.game;

public class GameOfLife {

    private int[][] generation;
    private long iteration;


    public GameOfLife(int size) {
        this.generation = new int[size][size];
        iteration = 0L;

        // init of the grid
        for (int i = 0; i < generation.length;i++) {
            for (int j = 0; j < generation[i].length; j++) {
                generation[i][j] = 0;
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

                result += generation[i][j];
            }
        }
        return result;
    }

    public void calculateNextGeneration() {
        iteration++;
        int[][] nextGeneration = new int[generation.length][generation[0].length];

         for (int i = 0; i < generation.length;i++) {
            for (int j = 0; j < generation[i].length; j++) {
                int livingNeighbours = countLivingNeighbors(i, j);

                if (generation[i][j] == 0 && livingNeighbours == 3) {
                    // 3 living neighbours and dead cell
                    nextGeneration[i][j] = 1;
                } else if (generation[i][j] == 1 && (livingNeighbours < 2 || livingNeighbours > 3)) {
                    // living cell dies
                    nextGeneration[i][j] = 0;
                } else {
                    // case cell is dead and not exactly 3 living neighbours -> cell dead in next step
                    // case cell lives but has 2 or 3 living neighbours -> cell does not die
                    nextGeneration[i][j] = generation[i][j];
                }

            }
         }

        generation = nextGeneration;
    }

    public int[][] getGeneration() {
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