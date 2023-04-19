package Prog_III_2023.tp_01.ej_08;

public class Main {

    public static void main(String[] args) {

        System.out.println(" ");
        DoublyLinkedList<String> namesList = new DoublyLinkedList<String>();
        System.out.println(namesList.toString());

        System.out.println(" ");
        System.out.println("Insert front");
        namesList.insertFront("Juan");
        namesList.insertFront("Horacio");
        namesList.insertFront("Gonzalo");
        System.out.println(namesList.toString());

        System.out.println(" ");
        System.out.println("Insert last");
        namesList.insertLast("Liliana");
        namesList.insertLast("Mariano");
        namesList.insertLast("Nicolas");
        System.out.println(namesList.toString());

        System.out.println(" ");
        System.out.println("Getting info by index:");
        int ind = -3;
        String info = namesList.get(ind);
        System.out.println("The info in index '" + ind + "' is = " + info);

        /*
        La CC requerida por la mayoría de los métodos (Cambiar la información, eliminar, etc...) no cambia significativamente
        en comparación con la lista simplemente vinculada, excepto por el acceso directo a los valores del primer y último nodo y
        la reducción de O(n) a O(n/2) en el resto de los casos.
        La CC del método insertar último baja de O(n) a O(1).
         */
    }
}
