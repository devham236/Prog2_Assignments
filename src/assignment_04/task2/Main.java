package assignment_04.task2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HalfAdder halfAdder = new HalfAdder();

        System.out.print("Geben Sie den ersten boolean Wert an: ");
        boolean input_1 = scanner.nextBoolean();

        System.out.print("Geben Sie den zweiten boolean Wert an: ");
        boolean input_2 = scanner.nextBoolean();

        boolean[] result = halfAdder.add(input_1, input_2);
        System.out.printf("Die Summe lautet: %d, der Übertrag beträgt: %d", result[0] ? 1 : 0, result[1] ? 1 : 0);

        System.out.println();

        halfAdder.info();
        
        scanner.close();
    }
}
