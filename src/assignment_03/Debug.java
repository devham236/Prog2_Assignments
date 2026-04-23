package assignment_03;

public class Debug {

  public static void main(String[] args) {
    Operator[] ops = new Operator[4];
    ops[0] = Operator.DIVIDE;
    ops[1] = Operator.SUBTRACT;
    ops[2] = Operator.MULTIPLY;
    ops[3] = Operator.ADD;

    Expression[] exp = new Expression[ops.length];
    for (int i = 0; i < ops.length; i++) {
      exp[i] = new Expression(i, i + 1, ops[i]);
    }

    for (int i = 0; i < ops.length; i++) {
      System.out.println(exp[i].evaluate());
    }
  }
}

/*
Zeile 6
Fehlermeldung: Exception in thread "main" java.lang.NullPointerException: Cannot invoke "assignment_03.Operator.ordinal()" because "this.op_" is null
- Array hat Länge 5, es werden aber nur 4 Indizes belegt (0-3)
- Array hat an letzter Stelle ein "null", im switch ist dann "this.op_" gleich null und schmeißt dann einen Error
- Wir wissen enum hat 4 Operationen, also setzen wir Länge der array gleich 4

Zeile 14
- Expression class sagt als Kommentar, das Instanz nicht mit right_ = 0 und op_ = divide erzeugt werden sollte, um
nicht durch 0 zu teilen.
- Im ersten durchlauf des loops ist i = 0, das heißt new Expression(1, 0, DIVIDE) würde 1 durch 0 teilen, Konsole
zeigt dann "Infinity" an.
- Daher addiert man 1 zum rechten Operanden, also new Expression(i, i + 1, ops[i])

Struktur
- Debug class separat
 */