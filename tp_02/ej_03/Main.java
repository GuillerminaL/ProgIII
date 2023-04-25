package Prog_III_2023.tp_02.ej_03;

import Prog_III_2023.tp_02.SortingAlgorithms.SortingAlgorithm;
import Prog_III_2023.tp_02.SortingAlgorithms.AdaptiveBubbleSort;
import Prog_III_2023.tp_02.SortingAlgorithms.BubbleSort;
import Prog_III_2023.tp_02.SortingAlgorithms.SelectionSort;
import Prog_III_2023.tp_02.SortingAlgorithms.MergeSort;
import Prog_III_2023.tp_02.SortingAlgorithms.QuickSort;

public class Main {

    public static void main(String[] args) {

        TimeComplexityTest test = new TimeComplexityTest();

        SortingAlgorithm selection = new SelectionSort();
        SortingAlgorithm bubble = new BubbleSort();
        SortingAlgorithm bubbleAdapt = new AdaptiveBubbleSort();
        SortingAlgorithm merge = new MergeSort();
        SortingAlgorithm quick = new QuickSort();

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
