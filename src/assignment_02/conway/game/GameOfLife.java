package assignment_02.conway.game;

public class GameOfLife {
    int[][] field;
    long iter;

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
        return "";
    }

    public static void main(String[] args) {
        GameOfLife test = new GameOfLife(15, 15);

        test.field[1][2] = 1;
        test.field[2][3] = 1;
        test.field[3][1] = 1;
        test.field[3][2] = 1;
        test.field[3][3] = 1;


        for (int i = 0; i < 20; i++) {
            test.printGeneration(test.field);
            test.calculateNextGeneration();
        }
    }
}
