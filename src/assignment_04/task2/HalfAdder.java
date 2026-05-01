package assignment_04.task2;

public class HalfAdder {
    Gate[] gates = {new AndGate(), new OrGate(), new NotGate(), new XorGate()};
    private static int gate_for_sum = 3;
    private static int gate_for_carry = 0;

    public boolean[] add(boolean a, boolean b){
        boolean[] results = new boolean[2];
        results[0] = gates[gate_for_carry].evaluate(a, b);
        results[1] = gates[gate_for_sum].evaluate(a, b);

        return results;
    }

    public void info(){
        System.out.println();
        gates[3].table();
        System.out.println();
        gates[0].table();
    }
}
