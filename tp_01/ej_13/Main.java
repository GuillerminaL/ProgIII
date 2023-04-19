package Prog_III_2023.tp_01.ej_13;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        FibonacciSequencePrinter printer = new FibonacciSequencePrinter();
        ArrayList result = printer.print(50);


        /*---------------------------------------------------------------------------------------------*/
        System.out.println(" ");
        System.out.println(result.toString());

    }
}
