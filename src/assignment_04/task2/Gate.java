package assignment_04.task2;

public class Gate {
    String symbol = "XOR";
    boolean[][] test = {
                       {false, false, false},
                       {false, true, false},
                       {true, false, false},
                       {true, true, false},};

    public boolean evaluate(boolean a, boolean b){
        return false;
    }

    public void table(){
        System.out.printf("A B Y = A %s B", symbol);
        for (int i = 0; i < test.length; i++) {
            System.out.println();
            for (int j = 0; j < test[i].length; j++) {
                if (j == 2) {
                    boolean result = evaluate(test[i][0], test[i][1]);
                    System.out.printf("%d ", result ? 1 : 0);
                } else {
                    System.out.printf("%d ", test[i][j] ? 1 : 0);
                }
            }
        }
        System.out.println();
    }
}
