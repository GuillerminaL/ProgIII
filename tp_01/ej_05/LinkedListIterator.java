package Prog_III_2023.tp_01.ej_05;

import Prog_III_2023.tp_01.ej_01_02_04.Node;

import java.util.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {

    private Node<T> current;

    public LinkedListIterator(Node<T> first) {
        this.current = first;
    }

    @Override
    public boolean hasNext() {
        return this.current != null;
    }

    @Override
    public T next() {
        T result = this.current.getInfo();
        this.current = this.current.getNext();
        return result;
    }

    @Override
    public void remove() {

    }

}
