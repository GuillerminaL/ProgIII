package Prog_III_2023.tp_01.ej_12;

import Prog_III_2023.tp_01.ej_01_02_04.LinkedList;
import Prog_III_2023.tp_01.ej_05.IterableLinkedList;

import java.util.ArrayList;

public class BinaryNotationConverter {

    public BinaryNotationConverter() {}


    public IterableLinkedList convert(int num) {
        IterableLinkedList result = new IterableLinkedList();
        boolean isNegative = false;
        if(num < 0) {
            isNegative = true;
            num = num * -1;
        }
        if(num == 0 || num == 1) result.insertFront(num);
        else {
            result = this.convert(num, result);
        }
        if(isNegative) result.insertFront(1);
        return result;
    }

    private IterableLinkedList convert(int num, IterableLinkedList result) {
        if(num < 2) {
            if(num == 1) result.insertFront(num);
            return result;
        } else {
            if(num % 2 == 0) result.insertFront(0);
            else result.insertFront(1);
            return convert(num/2, result);
        }
    }
}
