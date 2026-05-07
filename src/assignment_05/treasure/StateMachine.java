package assignment_05.treasure;
import java.util.Scanner;

public class StateMachine {
    public static State start = Island.PIRATES_ISLAND;
    public static State end = Island.TREASURE_ISLAND;

    public static void main(String[] args) {
        State[] journey = {start};
        State currentState = start;
        Scanner scanner = new Scanner(System.in);

        while(currentState != end){
            System.out.printf("Current State: %s \n", currentState.str());
            System.out.print("Enter Action (A) or (B): ");

            String input = scanner.nextLine();
            try {
                Action action = Action.valueOf(input.toUpperCase());
                currentState = currentState.transition(action);
                journey = addToJourney(journey, currentState);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input!");
            }

        }

        System.out.println();
        System.out.println("You found the treasure!");
        System.out.println();

        System.out.println("Your Journey:");
        for (State state : journey) {
            System.out.println(state.str());
        }

        scanner.close();
    }

    public static State[] addToJourney(State[] arr, State val){
        State[] newArray = new State[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }

        newArray[newArray.length - 1] = val;

        return newArray;
    }
}
