package Prog_III_2023.tp_01.ej_08;

public class DoublyLinkedList<T> {

    private DoublyLinkedListNode<T> first;
    private DoublyLinkedListNode<T> last;
    private int size;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0 && this.first == null && this.last == null;
    }

    public DoublyLinkedListNode<T> getFirst() {
        return this.first;
    }

    public DoublyLinkedListNode<T> getLast() { return this.last; }

    public int size() { return this.size; }
    //CC List = O(n) --> O(1) con almacenamiento en variable | Array = O(1)

    public void insertFront(T info) {
        if(!this.isEmpty()) {
            DoublyLinkedListNode<T> tmp = new DoublyLinkedListNode<T>(info, null, this.first);
            this.first.setPrevious(tmp);
            this.first = tmp;
        } else {
            this.first = new DoublyLinkedListNode<T>(info, null, null);
            this.last = this.first;
        }
        this.size += 1;
    }
    // CC List = O(1) | Array = O(n)

    public void insertLast(T info) {
        if(!this.isEmpty()) {
            if(this.size == 1) {                //this.first == this.last
                this.last = new DoublyLinkedListNode<T>(info, this.first, null);
                this.first.setNext(this.last);
            } else {                            //this.size > 1
                DoublyLinkedListNode<T> tmp = new DoublyLinkedListNode<T>(info, this.last, null);
                this.last.setNext(tmp);
                this.last = tmp;
            }
            this.size += 1;
        } else {
            this.insertFront(info);
        }
    }
    // CC List = O(1) | Array = O(1) --> O(n) si requiere aumentar espacio

    public T extractFront() {
        T result = null;
        if(!this.isEmpty()) {
            result = this.first.getInfo();
            if(this.size == 1) {
                this.first = null;
                this.last = null;
            } else {
                if(this.size == 2) {
                    this.last.setPrevious(null);
                    this.first = this.last;
                    } else {                            //this.size > 2
                    this.first = this.first.getNext();
                    this.first.setPrevious(null);
                }
            }
            this.size -= 1;
        }
        return result;
    }
    //CC List = O(1) | Array = O(n)

    public T extractLast() {
        T result = null;
        if(!this.isEmpty()) {
            result = this.last.getInfo();
            if(this.size == 1) {
                this.extractFront();
            } else {
                if(this.size == 2) {
                    this.first.setNext(null);
                    this.last = this.first;
                } else {                        //this.size > 2
                    DoublyLinkedListNode<T> prev = this.last.getPrevious();
                    prev.setNext(null);
                    this.last = prev;
                }
                this.size -= 1;
            }
        }
        return result;
    }
    //CC List = O(1) | Array = O(1)

    public T get(int index) {
        T result = null;
        if(!this.isEmpty() && index >= 0 && index < this.size) {
            if(index == 0) result = this.first.getInfo();                   //CC O(1)
            else if(index == this.size - 1) result = this.last.getInfo();   //CC O(1)
            else {
                int mid = this.size/2;                                      //CC O(n/2) --> O(n)
                DoublyLinkedListNode<T> current;
                if(index <= mid) {
                    current = this.first;
                    int i = 0;
                    while(i < index) {
                        current = current.getNext();
                        i++;
                    }
                } else {
                    current = this.last;
                    int i = this.size - 1;
                    while(i > index) {
                        current = current.getPrevious();
                        i--;
                    }
                }
                result = current.getInfo();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("LinkedList{");
        if(this.first != null) {
            int i = 0;
            DoublyLinkedListNode<T> current = this.getFirst();
            while(i < size && current != null) {
                tmp.append("index=").append(i).append(" ").append(current.getInfo()).append(", ");
                current = current.getNext();
                i++;
            }
        }
        tmp.append("size=").append(size).append('}');
        return tmp.toString();
    }

}
