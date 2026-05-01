package assignment_04.task2;

public class AndGate extends Gate{

    public AndGate(){
        this.symbol = "AND";
    }

    @Override
    public boolean evaluate(boolean a, boolean b){
        return a && b ? true : false;
    }
}
