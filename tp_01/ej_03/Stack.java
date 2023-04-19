package Prog_III_2023.tp_01.ej_03;
import Prog_III_2023.tp_01.ej_01_02_04.LinkedList;

public class Stack<T> {

    private LinkedList<T> list;

    public Stack() {
        this.list = new LinkedList<T>();
    }

    public void push(T info) {
        this.list.insertFront(info);
    }

    public T pop() {
       return this.list.extractFront();
    }

    public T top() {
        return this.list.getFirst().getInfo();
    }

    public void reverse() {    //CC O(n*2) --> O(n)
        LinkedList<T> tmp = new LinkedList<T>();
        int i = 0;
        while(i < this.list.size()) {
            tmp.insertFront(this.pop());
        }
        this.list = tmp;
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder("Stack{");
        tmp.append(this.list.toString()).append('}');
        return tmp.toString();
    }

    //------------------------------------------------------------------------------------------------------------------
    public LinkedList<T> getList() {
        return this.list;
    }
}
