package Prog_III_2023.tp_01.ej_13;

import java.util.ArrayList;

public class FibonacciSequencePrinter {


    public FibonacciSequencePrinter() {}


    public ArrayList print(int n) {
        ArrayList result = new ArrayList();
        if(n > 0) {
            result.add(0, 0);
            this.print(n, result, 1, 0, 1);
        }
        return result;
    }

    private ArrayList print(int n, ArrayList result, long num1, long num2, int index) {
        if(index == n) return result;
        else {
            long current = num1 + num2;
            result.add(index, current);
            index = index + 1;
            return print(n, result, num2, current, index);
        }
    }
}
