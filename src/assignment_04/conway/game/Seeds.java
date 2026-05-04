package assignment_04.conway.game;
import assignment_04.conway.component.CellType;

/**
 * This class runs a version of the Game of Life called "Seeds."
 *
 * Cells only get born if they have exactly 2 neighbors, and
 * everything else dies immediately in the next turn.
 * @author hamza Mirza
 */
public class Seeds extends GameOfLife{
    /**
     * Constructor that sets up the game board size.
     * @param size The width/height of the grid.
     */
    public Seeds(int size) {
        super(size);
    }

    /**
     * This method handles the logic for moving from one turn to the next.
     * It looks at every cell on the board and counts its living neighbors.
     * If a cell is currently dead and has exactly 2 neighbors, it "seeds"
     * a new living cell. If not, the cell stays dead or dies off.
     * @author Hamza Mirza
     */
    @Override
    public void calculateNextGeneration(){
        iteration++;
        CellType[][] nextGeneration = new CellType[generation.length][generation[0].length];

        for (int i = 0; i < generation.length;i++) {
            for (int j = 0; j < generation[i].length; j++) {
                int livingNeighbours = countLivingNeighbors(i, j);

                if (generation[i][j].getValue() == 0 && livingNeighbours == 2){
                    nextGeneration[i][j] = CellType.LIVING;
                } else {
                    nextGeneration[i][j] = CellType.DEAD;
                }

            }
        }

        generation = nextGeneration;
    }
}
