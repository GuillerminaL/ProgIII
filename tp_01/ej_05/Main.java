package Prog_III_2023.tp_01.ej_05;

public class Main {

    public static void main(String[] args) {

        System.out.println(" ");
        IterableLinkedList<String> list = new IterableLinkedList<String>();
        list.insertFront("Juan");
        list.insertFront("Horacio");
        list.insertFront("Gonzalo");
        System.out.println(list.toString());

        System.out.println(" ");
        System.out.println("Print using iterator... ");
        LinkedListIterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
