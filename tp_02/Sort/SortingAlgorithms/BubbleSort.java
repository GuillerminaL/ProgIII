package Prog_III_2023.tp_02.Sort.SortingAlgorithms;

public class BubbleSort extends SortingAlgorithm {

    public BubbleSort() {}

    /**
     * Bubble Sort
     * CC O(n^2)
     *
     * !  Bubble sort does not recognize if the array is already ordered o semi ordered.
     *    Always consumes O(n^2)
     *
     * @param arr
     * @return ascending ordered arr
     */
    public int[] sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

}
