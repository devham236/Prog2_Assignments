package assignment_04.task2;

public class XorGate extends Gate {
    private AndGate and;
    private OrGate or;
    private NotGate not;

    public XorGate(){
        this.and = new AndGate();
        this.or = new OrGate();
        this.not = new NotGate();

        this.symbol = "XOR";
    }

    @Override
    public boolean evaluate(boolean a, boolean b){
        // Formel für XOR: (A ODER B) UND Nicht(A UND B)

        boolean a_or_b = or.evaluate(a, b);
        boolean a_and_b = and.evaluate(a, b);
        boolean not_a_or_b = not.evaluate(a_and_b, b);

        return and.evaluate(a_or_b, not_a_or_b);
    }
}
