package Prog_III_2023.tp_02.SortingAlgorithms;

public class QuickSort extends SortingAlgorithm {


    public QuickSort() {}


    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if(arr[j] <= pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = tmp;

        return i + 1;
    }


    /**
     * QuickSort
     * CC O(n^2)   -->   Average n.log2 n
     *
     *  !Not additional memory required
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int[] sort(int[] arr, int start, int end) {
        if(start < end) {
            int partition_index = partition(arr, start, end);
            sort(arr, start, partition_index - 1);
            sort(arr, partition_index + 1, end);
        }
        return arr;
    }

    public int[] sort(int[] arr) {
        if(arr.length > 1) {
            this.sort(arr, 0, arr.length-1);
        }
        return arr;
    }
}
