package Prog_III_2023.tp_02.SortingAlgorithms;

public class AdaptiveBubbleSort extends SortingAlgorithm {

    public AdaptiveBubbleSort() {}

    /**
     * Adaptive Bubble Sort
     * CC O(n^2)
     *
     * !  Adaptive Bubble sort -unlike simple bubble sort- does recognize if the array is already ordered o semi ordered,
     *    by cheking if any of the elements in the array has been "swapped" during the first round.
     *    So, in this case -the better case-, it reduces the complexity from 0(n^2) to 0(n), as it improves the
     *    complexicity in other cases, acording to the quantity of elements in the array that needs to be swapped.
     *
     * @param arr
     * @return ascending ordered arr
     *
     */

    public int[] sort(int[] arr) {
        boolean swapped = true;
        int j = 0;
        while(swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if(arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    swapped = true;
                }
            }
        }
        return arr;
    }
}
