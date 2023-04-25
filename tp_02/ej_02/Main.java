package Prog_III_2023.tp_02.ej_02;

import Prog_III_2023.tp_02.SortingAlgorithms.QuickSort;

public class Main {

    public static void main(String[] args) {

        int[] ar = {4, 3, -4, 2, 1};
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        int[] arr2 = {8, 5, 7, 9, 11, 15, 25, 32, 41, 50};

        System.out.println(" ");
        String st = "[ ";
        for(int el: arr) st += " " + el;
        System.out.println(st + " ]");

        /*----------------------------------------------------------------------------------------------*/


//        ----------- Mergesort ---------------------------------
//        MergeSort ms = new MergeSort();
//        int[] result = ms.sort(ar);

//        ----------- QuickSort ---------------------------------
        QuickSort qs = new QuickSort();
        int[] result = qs.sort(ar);



        /*----------------------------------------------------------------------------------------------*/

        System.out.println(" ");
        String st2 = "[ ";
        for(int el: result) st2 += " " + el;
        System.out.println(st2 + " ]");

    }
}
