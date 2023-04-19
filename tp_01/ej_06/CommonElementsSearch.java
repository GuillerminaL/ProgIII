package Prog_III_2023.tp_01.ej_06;

import Prog_III_2023.tp_01.ej_01_02_04.Node;
import Prog_III_2023.tp_01.ej_05.IterableLinkedList;
import Prog_III_2023.tp_01.ej_05.LinkedListIterator;

import java.util.ArrayList;
import java.util.Iterator;

public class CommonElementsSearch<T> {

    public CommonElementsSearch() {
    }

    //1.
    // Búsqueda en listas desordenadas...
    // CC O(n*h) → se puede representar como O(n^2) si n >= h
    public ArrayList<T> searchCommonElements(IterableLinkedList<T> list1, IterableLinkedList<T> list2) {
        ArrayList<T> result = new ArrayList<T>();
        for (T el : list1) {
            for (T el2 : list2) {
                if (el == el2) {
                    result.add(el);
                    break;
                }
            }
        }
        return result;
    }

    // 2.
    // Búsqueda con segunda lista ordenada...
    // CC O(n*h) → En el peor de las casos, cuando todos los números de la lista 1 son mayores a los de la segunda, O(n^2)
    // Convendría utilizar una lista que guarde el last y, si debe retornarse una lista ordenada, insertarlos al final.
    public ArrayList<Integer> searchCommonElements_SecondOrderedList(IterableLinkedList<Integer> list1, IterableLinkedList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer el : list1) {
            for (Integer el2 : list2) {
                if (el2 > el) {
                    break;
                }
                if (el == el2) {
                    result.add(el);
                    break;
                }
            }
        }
        return result;
    }

    public ArrayList<Integer> searchCommonElements_OrderedLists(IterableLinkedList<Integer> list1, IterableLinkedList<Integer> list2) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        LinkedListIterator<Integer> it1 = list1.iterator();
        Integer el = null;
        Integer el2 = null;
        while (it1.hasNext()) {
            el = it1.next();
            LinkedListIterator<Integer> it2 = list2.iterator();
            while (it2.hasNext()) {
                el2 = it2.next();
                if (el2 > el) {
                    break;
                }
                if (el == el2) {
                    result.add(el);
                    break;
                }
            }
            if (!it2.hasNext() && el2 < el) {
                break;
            }
        }
        return result;
    }


    //-- Ej 6: Buscar elementos comunes en dos listas ordenadas utilizando iteradores
    //-- Resolución a: Con iteradores chequeando null...
//    public IterableLinkedList<Integer> searchCommonElements_OrderedLists_withIterators (IterableLinkedList<Integer> list1, IterableLinkedList<Integer> list2) {
//        IterableLinkedList<Integer> result = new IterableLinkedList<Integer>();
//        Iterator<Integer> it1 = list1.iterator();
//        Iterator<Integer> it2 = list2.iterator();
//        Integer el = null;
//        Integer el2 = null;
//        if (it1.hasNext()) el = it1.next();
//        if (it2.hasNext()) el2 = it2.next();
//        while (el != null && el2 != null) {
//            if(el == el2) {
//                result.insertFirst(el); //CC!!! Insert last permitiría retornar la lista ordenada, pero aumentaría exponencialmente la complejidad
//                if (it1.hasNext() ) el = it1.next(); else el = null;
//                if (it2.hasNext()) el2 = it2.next(); else el2 = null;
//            } else {
//                if(el < el2) {
//                    if(it1.hasNext()) {
//                        el = it1.next();
//                    } else {
//                        el = null;
//                    }
//                }  else {
//                    if (it2.hasNext()) {
//                        el2 = it2.next();
//                    } else {
//                        el2 = null;
//                    }
//                }
//            }
//        }
//        return result;
//    }

    //-- Resolución b: Con iteradores sin chequeo de null...
//    public IterableLinkedList<Integer> searchCommonElements_OrderedLists_withIterators (IterableLinkedList<Integer> list1, IterableLinkedList<Integer> list2) {
//        IterableLinkedList<Integer> result = new IterableLinkedList<Integer>();
//        Iterator<Integer> it1 = list1.iterator();
//        Iterator<Integer> it2 = list2.iterator();
//        while(it1.hasNext() && it2.hasNext()) {
//            Integer el = it1.next();
//            Integer el2 = it2.next();
//            while(!(el == el2)) {
//                if(el > el2) {
//                    if(it2.hasNext()) {
//                        el2 = it2.next();
//                    } else {
//                        break;
//                    }
//                }
//                if(el < el2) {
//                    if(it1.hasNext()) {
//                        el = it1.next();
//                    } else {
//                        break;
//                    }
//                }
//            }
//            if(el == el2) {
//                result.insertFirst(el); //CC!!! Insert last permitiría retornar la lista ordenada, pero aumentaría exponencialmente la complejidad
//            }
//        }
//        return result;
//    }

    //--Resolución c: Sin iteradores, nodo a nodo... O(n + h) --> O(n*2) --> O(n)
    public IterableLinkedList<T> searchCommonElements_OrderedLists_withIterators(IterableLinkedList<T> list1, IterableLinkedList<T> list2) {
        IterableLinkedList<T> result = new IterableLinkedList<T>();
        Node<T> node1 = list1.getFirst();
        Node<T> node2 = list2.getFirst();
        while (node1 != null && node2 != null) {
            if (node1.getInfo() == node2.getInfo()) {
                result.insertFront(node1.getInfo());
                node1 = node1.getNext();
                node2 = node2.getNext();
            } else {
                if ((Integer) node1.getInfo() > (Integer) node2.getInfo()) {    //Asigno tipo para poder comparar
                    node2 = node2.getNext();
                } else {
                    node1 = node1.getNext();
                }
            }
        }
        return result;
    }
}