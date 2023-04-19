package Prog_III_2023.tp_01.ej_12;

import Prog_III_2023.tp_01.ej_05.IterableLinkedList;

public class Main {

    public static void main(String[] args) {


        BinaryNotationConverter converter = new BinaryNotationConverter();
        IterableLinkedList<Integer> result = converter.convert(26);


        /*---------------------------------------------------------------*/
        System.out.println(" ");
        String binary = "";
        for(int i: result) binary += i;
        System.out.println(binary);

    }
}
