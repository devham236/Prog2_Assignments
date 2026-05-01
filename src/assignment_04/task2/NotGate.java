package assignment_04.task2;

public class NotGate extends Gate {
    public NotGate(){
        this.symbol = "NOT";
    }

    @Override
    public boolean evaluate(boolean a, boolean b){
        return !a;
    }
}
