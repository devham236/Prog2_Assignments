package assignment_04.conway.game;

import assignment_04.conway.component.CellType;

public class Seeds extends GameOfLife{
    public Seeds(int size) {
        super(size);
    }

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
