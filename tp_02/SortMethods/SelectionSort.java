package Prog_III_2023.tp_02.SortMethods;

import Prog_III_2023.tp_02.SortMethods.SortMethod;

public class SelectionSort extends SortMethod {

    public SelectionSort() {}


    /**
     * Selection sort
     * CC O(n^2)
     *
     * ! Selection sort searches for the index of the lower element in an array. Once it findes it, it switches the values
     *  with the first index of the array, so the left side of it is always in order. Then, it starts again, but beggining
     *  from the second place in the array and so on...
     *  It results in one more element left in order to the left in each round, and one less element to compare to to the
     *  right, reducing the general complexity.
     *
     * @param arr
     * @return ascending order arr
     */
    public int[] sort(int[] arr) {
        if(arr.length > 0) {
            for (int i = 0; i < arr.length; i++) {
                int lowest = i;
                for (int j = i+1; j < arr.length; j++) {
                    if(arr[j] < arr[lowest]) lowest = j;
                }
                if(arr[lowest] != arr[i]) {
                    int aux = arr[i];
                    arr[i] = arr[lowest];
                    arr[lowest] = aux;
                }
            }
        }
        return arr;
    }


}
