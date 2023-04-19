package Prog_III_2023.tp_01.ej_10;

public class AscendingOrderSearch<T> {

    public AscendingOrderSearch() { }

    //-- Resolución 1: Sin recursión...
    public boolean hasAscendingOrder_NonRecursive(int[] arr) {
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) return false;
            }
        }
        return true;   //Si el array está vacío, tiene un elemento o llegó al final del for
    }

    //-- Resolución 2: Con recursión...
    public boolean hasAscendingOrder_Recursive(int[] arr) {
        if(arr.length < 2) return true;  //Si está vacío o tiene un elemento
        else return this.hasAscendingOrder_Recursive(arr, 1);
    }

    private boolean hasAscendingOrder_Recursive(int[] arr, int i) {
        if(i == arr.length) return true;
        else {
            if(arr[i] > arr[i - 1]) {
                i = i + 1;
                return hasAscendingOrder_Recursive(arr, i);
            } else {
                return false;
            }
        }
    }

}
