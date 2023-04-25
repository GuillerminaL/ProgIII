package Prog_III_2023.tp_02.ej_01;

import Prog_III_2023.tp_02.SortMethods.SelectionSort;

public class Main {

    public static void main(String[] args) {

        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        int[] arr2 = {8, 5, 7, 9, 11, 15, 25, 32, 41, 50};

        System.out.println(" ");
        String st = "[ ";
        for(int el: arr) st += " " + el;
        System.out.println(st + " ]");

        /*----------------------------------------------------------------------------------------------*/


//        ----------- Bubble sort ---------------------------------
//        BubbleSort bubble = new BubbleSort();
//        int[] result = bubble.sort(arr);


//        ----------- Bubble sort adapt ---------------------------
//        AdaptiveBubbleSort bubbleA = new AdaptiveBubbleSort();
//        int[] result = bubbleA.sort(arr);


//        ----------- Selection sort ---------------------------------
        SelectionSort selection = new SelectionSort();
        int[] result = selection.sort(arr2);


        /*----------------------------------------------------------------------------------------------*/

        System.out.println(" ");
        String st2 = "[ ";
        for(int el: result) st2 += " " + el;
        System.out.println(st2 + " ]");


    }
}
