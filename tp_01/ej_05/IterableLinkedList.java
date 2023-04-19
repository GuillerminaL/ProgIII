package Prog_III_2023.tp_01.ej_05;

import Prog_III_2023.tp_01.ej_01_02_04.LinkedList;

public class IterableLinkedList<T> extends LinkedList<T> implements Iterable<T> {

    @Override
    public LinkedListIterator<T> iterator() {
        return new LinkedListIterator<T>(this.getFirst());
    }


}
