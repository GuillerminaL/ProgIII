package Prog_III_2023.tp_01.ej_10;

public class Main {

    public static void main(String[] args) {

//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] array = {1};
//        int[] array = {1, 25};
        int[] array = {100, 5, 26};

        AscendingOrderSearch<Integer> search = new AscendingOrderSearch<Integer>();
//        boolean isOrdered = search.hasAscendingOrder_NonRecursive(array);
        boolean isOrdered = search.hasAscendingOrder_Recursive(array);

        System.out.println(" ");
        String arr = "[ ";
        for(int el: array) arr += " " + el;
        System.out.println(arr + " ]");

        if(isOrdered) System.out.println("Has ascending order");
        else System.out.println("Does not have ascending order");
    }

    /*
    Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado
    1. ¿Qué complejidad O tiene? (La complejidad en el peor caso)
        O(n)
    2. ¿Trae algún problema hacerlo recursivo? ¿Cuál?
        La duplicación de métodos inicial -que podría obviarse si se llamara al índice con un array y el índice inicial-,
        la complejidad de procesamiento propia de la recursión que, al funcionar como una pila -almacenando cada llamada
        con sus variables de entorno-, supone un costo mayor de procesamiento.
    3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo?
        Puesto que se trata de un recorrido secuencial, en principio, no habría mayores diferencias. No obstante,
        dado que no puede accederse a los elementos de una lista por índice -de poder hacerlo, sería muy costoso-,
        debería ir almacenándose el elemento anterior a fin de poder realizar la comparación con el actual. Además,
        sería más eficiente si la lista almacenara en una variable su tamaño.
     */
}
