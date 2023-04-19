package Prog_III_2023.tp_01.ej_08;

public class DoublyLinkedListNode<T> {

    private DoublyLinkedListNode<T> previous;
    private DoublyLinkedListNode<T> next;
    private T info;

    public DoublyLinkedListNode() {
        this.previous = null;
        this.next = null;
        this.info = null;
    }

    public DoublyLinkedListNode(T info, DoublyLinkedListNode<T> previous, DoublyLinkedListNode<T> next) {
        this.previous = previous;
        this.next = next;
        this.info = info;
    }

    public T getInfo() { return info; }

    public DoublyLinkedListNode<T> getPrevious() { return this.previous; }

    public DoublyLinkedListNode<T> getNext() { return this.next; }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setPrevious(DoublyLinkedListNode<T> previous) {
        this.previous = previous;
    }

    public void setNext(DoublyLinkedListNode<T> next) { this.next = next; }

}
