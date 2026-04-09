public class Conway {
    public static void main(String[] args){
//        int[][] field = {{0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 0 ,0}};
        int[][] field = {{1, 0, 0},
                        {0, 0, 0},
                        {1, 0, 1}};

        printGeneration(field);
        System.out.printf("Lebende Nachbarzellen: %d \n", countLivingNeighbors(field, 0,  1));
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
        System.out.println();

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
}
