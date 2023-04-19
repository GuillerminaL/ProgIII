package Prog_III_2023.tp_01.ej_06;

import Prog_III_2023.tp_01.ej_05.IterableLinkedList;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        IterableLinkedList<Integer> list1 = new IterableLinkedList<Integer>();
        IterableLinkedList<Integer> list2 = new IterableLinkedList<Integer>();

//        list1.insertFront(20);
//        list1.insertFront(15);
//        list1.insertFront(3);
//        list1.insertFront(8);
//        list1.insertFront(2);

//        list2.insertFront(14);
//        list2.insertFront(4);
//        list2.insertFront(9);
//        list2.insertFront(2);
//        list2.insertFront(3);

//        System.out.println("List 1: " + list1.toString());
//        System.out.println("List 2: " + list2.toString());

//        CommonElementsSearch<Integer> search = new CommonElementsSearch<Integer>();
//        ArrayList<Integer> commonEls = search.searchCommonElements(list1, list2);
//        System.out.println("Common elements: " + commonEls);

        //-------------- Ej 2: Segunda lista ordenada ------------------------------------------------------------------

//        list1.insertFront(20);
//        list1.insertFront(15);
//        list1.insertFront(3);
//        list1.insertFront(8);
//        list1.insertFront(13);
//
//        list2.insertFront(20);
//        list2.insertFront(17);
//        list2.insertFront(14);
//        list2.insertFront(12);
//        list2.insertFront(9);
//
//        System.out.println("List 1: " + list1.toString());
//        System.out.println("List 2: " + list2.toString());

//        CommonElementsSearch<Integer> search = new CommonElementsSearch<Integer>();
//        ArrayList<Integer> commonEls = search.searchCommonElements_SecondOrderedList(list1, list2);
//        System.out.println("Common elements: " + commonEls);

        //-------------- Ej 4: Dos listas ordenadas con iteradores------------------------------------------------------
        list1.insertFront(20);
        list1.insertFront(17);
        list1.insertFront(14);
        list1.insertFront(10);
        list1.insertFront(9);

        list2.insertFront(23);
        list2.insertFront(20);
        list2.insertFront(11);
        list2.insertFront(10);
        list2.insertFront(7);

        System.out.println("List 1: " + list1.toString());
        System.out.println("List 2: " + list2.toString());

        CommonElementsSearch<Integer> search = new CommonElementsSearch<Integer>();
        IterableLinkedList<Integer> commonEls = search.searchCommonElements_OrderedLists_withIterators(list1, list2);
        if(commonEls.isEmpty()) {
            System.out.println("The lists doesn't have common elements");
        } else {
            System.out.println("Common elements: " + commonEls.toString());
        }



    }
}
