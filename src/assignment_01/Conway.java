package assignment_01;

public class Conway {
    public static void main(String[] args){
        int[][] field = {{0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0 ,0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 0 ,0},
                        {0, 1, 1, 1, 0, 0, 0, 0, 0 ,0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0}};

        for (int i = 0; i < 20; i++) {
            System.out.printf("\nGeneration %d", i);
            printGeneration(field);
            field = calculateNextGeneration(field);
        }
    }

    public static void printGeneration(int[][] field){
        for (int i = 0; i < field.length; i++){
            System.out.println();
            for (int j = 0; j < field[i].length; j++){
                System.out.printf("%d ", field[i][j]);
            }
        }
    }

    public static int countLivingNeighbors(int[][] field, int x, int y){
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

    public static int[][] calculateNextGeneration(int[][] field){
        int[][] newField = copy2dArray(field);

        for (int i = 0; i < field.length; i++) {
            System.out.println();
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] >= 1 && countLivingNeighbors(field, i, j) < 2){
                    newField[i][j] = 0;
                }
                if(field[i][j] >= 1 && countLivingNeighbors(field, i, j) > 3){
                    newField[i][j] = 0;
                }
                if(field[i][j] < 1 && countLivingNeighbors(field, i, j) == 3){
                    newField[i][j] = 1;
                }
            }
        }
        return newField;
    }

    public static int[][] copy2dArray(int[][] array){
        int[][] newArray = new int[array.length][];

        for (int i = 0; i < array.length; i++) {
            newArray[i] = new int[array[i].length];
            for (int j = 0; j < array[i].length; j++) {
                newArray[i][j] = array[i][j];
            }
        }
        return newArray;
    }
}
