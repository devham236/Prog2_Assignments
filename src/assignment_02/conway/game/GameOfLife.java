package assignment_02.conway.game;

public class GameOfLife {
    public int[][] field;
    public long iter;

    public GameOfLife(int x, int y) {
        this.field = new int[x][y];
    }

    public int countLivingNeighbors(int x, int y){
        int count = 0;

        for (int i = x-1; i <= x+1; i++) {
            for (int j = y-1; j <= y+1; j++) {
                if(i >= 0 && i < field.length && j >= 0 && j < field[0].length){
                    if(!(i == x && j == y)){
                        if(field[i][j] == 1){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public void calculateNextGeneration(){
        int rows = field.length;
        int cols = field[0].length;
        int[][] nextGen = new int[rows][cols];

        for (int i = 0; i < field.length; i++) {
            System.out.println();
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] >= 1 && countLivingNeighbors(i, j) < 2){
                    nextGen[i][j] = 0;
                }
                if(field[i][j] >= 1 && countLivingNeighbors(i, j) > 3){
                    nextGen[i][j] = 0;
                }
                if(field[i][j] < 1 && countLivingNeighbors(i, j) == 3){
                    nextGen[i][j] = 1;
                }
                else if (field[i][j] >= 1 && (countLivingNeighbors(i, j) == 2 || countLivingNeighbors(i, j) == 3)){
                    nextGen[i][j] = 1;
                }
            }
        }
        this.iter++;
        this.field = nextGen;
    }

    public void printGeneration(int[][] field){
        for (int i = 0; i < field.length; i++){
            System.out.println();
            for (int j = 0; j < field[i].length; j++){
                System.out.printf("%d ", field[i][j]);
            }
        }
    }

    public int[][] getGeneration() {
        return this.field;
    }

    public long getIteration() {
        return this.iter;
    }

    public String toString() {
        String str = "";

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                str += field[i][j];
            }
            str += "\n";
        }

        return str;
    }
}
