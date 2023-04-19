package Prog_III_2023.tp_01.ej_07;

import Prog_III_2023.tp_01.ej_01_02_04.Node;
import Prog_III_2023.tp_01.ej_01_02_04.LinkedList;
import Prog_III_2023.tp_01.ej_03.Stack;
import Prog_III_2023.tp_01.ej_05.IterableLinkedList;

public class NonCommonElementsSearch<T> {

    public NonCommonElementsSearch() {
    }

    //-- Resolución 1: Listas desordenadas... O(n)*O(h) --> O(n^2)
    public LinkedList<T> nonCommonElementsSearch_UnorderedLists(IterableLinkedList<T> list1, IterableLinkedList<T> list2) {
        Stack<T> result = new Stack<T>();
        for (T el : list1) {
            boolean found = false;
            for (T el2 : list2) {
                if (el == el2) {
                    found = true;
                    break;
                }
            }
            if (!found) result.push(el);
        }
        return result.getList();
    }

    //-- Resolución 2: Listas ordenadas, nodo a nodo... O(n + h) --> O(n*2) --> O(n)
    //                 Devolución de lista ordenada usando stack.reverse... O(n*2) --> O(n)
    public LinkedList<T> nonCommonElementsSearch_OrderedLists(IterableLinkedList<T> list1, IterableLinkedList<T> list2) {
        Stack<T> result = new Stack<T>();
        Node<T> node1 = list1.getFirst();
        Node<T> node2 = list2.getFirst();
        while (node1 != null && node2 != null) {
            if (node1.getInfo() == node2.getInfo()) {
                node1 = node1.getNext();
                node2 = node2.getNext();
            } else {
                if ((Integer) node1.getInfo() > (Integer) node2.getInfo()) { //Asigno tipo para poder comparar
                    node2 = node2.getNext();
                } else {
                    result.push(node1.getInfo());
                    node1 = node1.getNext();
                }
            }
        }
        if(node1 != null && node2 == null) {
            while(node1 != null) {
                result.push(node1.getInfo());
                node1 = node1.getNext();
            }
        }
        result.reverse();
        return result.getList();
    }
}
