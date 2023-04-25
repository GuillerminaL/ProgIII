package Prog_III_2023.tp_02.SortMethods;

import Prog_III_2023.tp_02.SortMethods.SortMethod;

public class MergeSort extends SortMethod {

    private int[] arr;
    private int[] helper;

    public MergeSort() {}


    /**
     * Merge
     * CC O(n)
     *
     * @param start
     * @param mid
     * @param end
     */
    private void merge(int start, int mid, int end) {
        //guarda los números en el helper
        for (int i = start; i <= end; i++) {
            this.helper[i] = this.arr[i];
        }
        //los copia de manera ordenada en el array original, comparando mitad derecha con mitad izquierda
        int i= start;
        int j = mid+1;
        int k = start;
        while(i <= mid && j <= end) {
            if(helper[i] < helper[j]) {
                arr[k] = helper[i];
                i++;
            } else  if (helper[i] > helper[j]) {
                arr[k] = helper[j];
                j++;
            } else {
                arr[k] = helper[i];
                k++;
                arr[k] = helper[j];
                i++;
                j++;
            }
            k++;
        }
        while(i <= mid) {
            arr[k] = helper[i];
            k++;
            i++;
        }
        while(j <= end) {
            arr[k] = helper[j];
            k++;
            j++;
        }
    }


    /**
     * Mergesort
     * CC O(log2 n)
     *
     * Recursive division of array in left and right parts, until it reaches the last unique element from each side.
     * Then, ascending order merge of the original array, using a helper array.
     *
     * @param start
     * @param end
     */
    private void mergeSort(int start, int end) {
        if(start < end) {
            int mid = (start + end)/2;
            this.mergeSort(start, mid);
            this.mergeSort(mid + 1, end);
            this.merge(start, mid, end);
        }
    }


    /**
     * Mergesort
     * CC (n.log2 n)
     *
     * ! Requires additional memory (array of n elements)
     *
     * @param array
     * @return ascending order array
     */
    public int[] sort(int[] array) {
        if(array.length > 1) {
            this.arr = array;
            this.helper = new int[arr.length];
            this.mergeSort(0, arr.length-1);
        }
        return array;
    }

}
