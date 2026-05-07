package assignment_05.treasure;

public enum Action {
    A,
    B;

    public char str() {
        return switch (this){
            case A -> 'A';
            case B -> 'B';
        };
    }
}
