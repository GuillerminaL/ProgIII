package Prog_III_2023.tp_01.ej_11;

public class Main {

    public static void main(String[] args) {


        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        ElementSearch search = new ElementSearch();
        int index = search.searchInAscendingOrderArray(array, 9);



        /*-------------------------------------------------------------------------------------------------------*/
        System.out.println(" ");
        String arr = "[ ";
        for(int el: array) arr += " " + el;
        System.out.println(arr + " ]");

        if(index < 0) System.out.println("Element is not in the array") ;
        else System.out.println("Element is in index: " + index);


    }
}
