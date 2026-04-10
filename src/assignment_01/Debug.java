package assignment_01;

public class Debug { // 'class' keyword falsch geschrieben (ckass)
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        printPrime(arr); // Invalider Methoden Aufruf, 'arr' und 'printPrime' müssen in separate main function
    }
    // Methode that checks whether a given number is prime
    public static boolean isPrime(int n) {
        // Return false if number is one, zero or negative
        if (n < 2) { // alle Zahlen kleiner als 2 geben false wieder, nicht kleiner gleich 2
            return false;
        }
        // Check for all factors smaller and equal to n/2 whether it is a prime factor.
        // If it is a prime factor, return false.
        for (int i = 2; i <= n / 2; i++) { // i muss in jedem Schritt erhöht werden, nicht verringert
            if (n % i == 0) {
                return false; // wenn ein Primfaktor vorliegt dann soll false wiedergegeben werden, nicht true
            }
        }
        // If no prime factor was found, return true.
        return true;
    }


    // Method that prints all numbers in an array that are prime
    public static void printPrime(int[] arr) { // printPrime hat String als return type, gibt aber nichts wieder
        for (int i = 0; i <= arr.length - 1; i++) { // i soll bis index 9,
            if (isPrime(arr[i])) {
                System.out.println(arr[i]);
            }
        }
    }

        // output should be as follows:
    // 2
    // 3
    // 5
    // 7
}

/*
* Zeile 1: 'class' keyword falsch geschrieben
* Fehlermeldung: Cannot resolve symbol 'ckass'
*
* Zeile 9: (n <= 2) if Abfrage würde bei einer 2 ein false wiedergeben, also keine Primzahl, stimmt aber nicht,
* daher muss (n < 2) stehen
*
* Zeile 14: i-- verringert bei jedem Schritt das i, wir wollen aber bei jedem Schritt i erhöhen,
* also muss i++ stehen
*
* Zeile 16: Wenn ein Primfaktor vorliegt, soll false wiedergegeben, weil die Zahl
* einen weiteren Teiler hat und somit keine Primzahl ist
*
* Zeile 25: 'printPrime' function hat String als return type, returned aber nichts. Soll eigentlich eine void
* function sein, weil sie nur etwas printet
* Fehlermeldung: Missing return statement
*
* Zeile 26: Der loop geht von 0 bis array.length, also 10. In jedem Schritt übergeben wir
* arr[i] an die isPrime Funktion, gelangen wir zum letzten Schleifendurchlauf, also wo i = 10 ist, versuchen
* wir auf einen index im array zuzugreifen der nicht existiert, daher gehen wir nur bis zu array.length - 1
* Fehlermeldung: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 10
*
* Zeile 33: 'printPrime(arr)' wird als ungültige Methoden Deklaration gewertet, weil es sich noch in der class
* befindet. Funktionsaufruf muss in eine separate main function
* Fehlermeldungen:
* - Invalid method declaration; return type required
* - Method body expected
* - Unknown class: 'arr'
* - Identifier expected
* */