package Prog_III_2023.tp_02.ej_03;

import Prog_III_2023.tp_02.SortMethods.SortMethod;
import Prog_III_2023.tp_02.SortMethods.AdaptiveBubbleSort;
import Prog_III_2023.tp_02.SortMethods.BubbleSort;
import Prog_III_2023.tp_02.SortMethods.SelectionSort;
import Prog_III_2023.tp_02.SortMethods.MergeSort;
import Prog_III_2023.tp_02.SortMethods.QuickSort;

public class Main {

    public static void main(String[] args) {

        TimeComplexityTest test = new TimeComplexityTest();

        SortMethod selection = new SelectionSort();
        SortMethod bubble = new BubbleSort();
        SortMethod bubbleAdapt = new AdaptiveBubbleSort();
        SortMethod merge = new MergeSort();
        SortMethod quick = new QuickSort();

        int n = 10;

        double time0 = test.run(selection, n);
        double time1 = test.run(bubble, n);
        double time2 = test.run(bubbleAdapt, n);
        double time3 = test.run(merge, n);
        double time4 = test.run(quick, n);
        double time5 = test.runArraysSort(n);


        System.out.println(" ");
        System.out.println("Selection sort: " + time0);
        System.out.println("Bubble sort: " + time1);
        System.out.println("Adaptive Bubble sort: " + time2);
        System.out.println("Merge sort: " + time3);
        System.out.println("Quick sort: " + time4);
        System.out.println("Arrays sort: " + time5);



    }
}
