package assignment_03;

//Should not be instantiated with right_==0 and op_==DIVIDE
public class Expression {
    double left_, right_;
    Operator op_;

    public Expression(double left, double right, Operator op){
        this.left_  = left;
        this.right_ = right;
        this.op_    = op;
    }

    double evaluate() {
        switch (this.op_) {
            case ADD:
                return this.left_ + this.right_;
            case SUBTRACT:
                return this.left_ - this.right_;
            case MULTIPLY:
                return this.left_ * this.right_;
            case DIVIDE:
                return this.left_ / this.right_;
            default:
                return 0.0;
        }
    }
}

/*
Zeile 16-22
- Die einzelnen cases im switch müssen nur auf die Variablen des Enums zugreifen, nicht "Operator.add".
- Durch switch (this.op_) ist der Typ "Operator" schon bekannt, also muss man den in den cases weglassen.

Zeile 3
- "instanciated" ist falsch geschrieben ("instantiated" wäre richtig) im Kommentar und verwendet falsche
Operatoren. Expression sollte nicht mit right_ = 0 und op_ = DIVIDE erzeugt werden, "==" Vergleichsoperatoren sind
hier falsch und müssen durch Zuweisungsoperatoren "=" ersetzt werden.

Struktur
- Expression separat
 */
