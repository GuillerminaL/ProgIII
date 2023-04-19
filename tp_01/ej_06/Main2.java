package Prog_III_2023.tp_01.ej_06;

import Prog_III_2023.tp_01.ej_05.IterableLinkedList;

import java.util.Iterator;

public class Main2 {

    public static void main(String[] args) {

        IterableLinkedList<Integer> list1 = new IterableLinkedList<Integer>();
        IterableLinkedList<Integer> list2 = new IterableLinkedList<Integer>();

//        list1.insertFront(23);
//        list1.insertFront(20);
//        list1.insertFront(11);
//        list1.insertFront(10);
//        list1.insertFront(7);
//
//        list2.insertFront(23);
//        list2.insertFront(20);
//        list2.insertFront(11);
//        list2.insertFront(10);
//        list2.insertFront(7);

        list1.insertFront(2);
        list2.insertFront(2);


//      //-- Resolución 1 ----------------------------------------------------------------------------------------------
//        Iterator<Integer> iterator1 = list1.iterator();
//        Iterator<Integer> iterator2 = list2.iterator();
//
//        Integer num1 = iterator1.next();
//        Integer num2 = iterator2.next();
//
//        while (iterator1.hasNext() && iterator2.hasNext()) {
//            if (num1.equals(num2)) {
//                System.out.println(num1);
//                num1 = iterator1.next();
//                num2 = iterator2.next();
//            } else if (num1 < num2) {
//                num1 = iterator1.next();
//            } else {
//                num2 = iterator2.next();
//            }
//        }

        //-- Resolución 2----------------------------------------------------------------------------------------------

        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();

        Integer num1 = null;
        Integer num2 = null;

        while (iterator1.hasNext() && iterator2.hasNext()) {
            if (num1 == null) {
                num1 = iterator1.next();
            }
            if (num2 == null) {
                num2 = iterator2.next();
            }
            if (num1.equals(num2)) {
                System.out.println(num1);
                num1 = iterator1.hasNext() ? iterator1.next() : null;
                num2 = iterator2.hasNext() ? iterator2.next() : null;
            } else if (num1 < num2) {
                num1 = iterator1.hasNext() ? iterator1.next() : null;
            } else {
                num2 = iterator2.hasNext() ? iterator2.next() : null;
            }
        }
        if (num1 != null && num2 != null && num1.equals(num2)) {
            System.out.println(num1);
        }
    }
}

