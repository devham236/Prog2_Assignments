package assignment_04.task2;

public class OrGate extends Gate{
    public OrGate(){
        this.symbol = "OR";
    }

    @Override
    public boolean evaluate(boolean a, boolean b){
        return a || b ? true : false;
    }
}
