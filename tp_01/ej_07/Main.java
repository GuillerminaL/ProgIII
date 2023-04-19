package Prog_III_2023.tp_01.ej_07;

import Prog_III_2023.tp_01.ej_01_02_04.LinkedList;
import Prog_III_2023.tp_01.ej_05.IterableLinkedList;

public class Main {

    public static void main(String[] args) {

        IterableLinkedList<Integer> list1 = new IterableLinkedList<Integer>();
        IterableLinkedList<Integer> list2 = new IterableLinkedList<Integer>();

        list1.insertFront(2);
        list1.insertFront(22);
        list1.insertFront(155);
        list1.insertFront(10);
        list1.insertFront(6);

        list2.insertFront(58);
        list2.insertFront(4);
        list2.insertFront(3);
        list2.insertFront(2);
        list2.insertFront(1);

        System.out.println("List 1: " + list1.toString());
        System.out.println("List 2: " + list2.toString());

//        NonCommonElementsSearch<Integer> search = new NonCommonElementsSearch<Integer>();
//        LinkedList<Integer> result = search.nonCommonElementsSearch_UnorderedLists(list1, list2);
//        System.out.println(result.toString());

        NonCommonElementsSearch<Integer> search = new NonCommonElementsSearch<Integer>();
        LinkedList<Integer> result = search.nonCommonElementsSearch_OrderedLists(list1, list2);
        System.out.println(result.toString());
    }
}

