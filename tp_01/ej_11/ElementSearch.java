package Prog_III_2023.tp_01.ej_11;

public class ElementSearch {

    public ElementSearch() {}

    //Resolución 1:
    // Búsqueda recursiva de elemento en array ordenado ascendentemente
    // CC O(logn)
    public int searchInAscendingOrderArray(int[] arr, int key) {
        if(arr.length == 0 || key < arr[0] || key > arr[arr.length-1])
            return  -1;
        if(arr.length == 1)
            return (arr[0] == key) ? 0 : -1;

        return recursive_search(arr, 0, arr.length, key);
    }

    private int recursive_search(int[] arr, int start, int end, int key) {
        if(start == end) {
            if(end == arr.length || arr[start] != key)
                return -1;
            else
                return start;
        } else {
            int mid = ((end - start)/2) + start;
            if(arr[mid] == key)
                return mid;
            if(arr[mid] < key) {                                            //--- Cómo se comparan genéricos???
                return recursive_search(arr, mid+1, end, key);
            } else {
                return recursive_search(arr, start, mid-1, key);
            }
        }
    }

    //Resolución 2:
    // Búsqueda no recursiva de elemento en array desordenado
    // CC O(n)
    public int searchInUnorderedArray(int[] arr, int key) {
        if(arr.length > 0 && key <= arr[0] && key <= arr[arr.length-1]) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == key)
                    return i;
            }
        }
        return -1;
    }
}
