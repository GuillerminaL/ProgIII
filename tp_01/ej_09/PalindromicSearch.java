package Prog_III_2023.tp_01.ej_09;

import Prog_III_2023.tp_01.ej_08.DoublyLinkedList;
import Prog_III_2023.tp_01.ej_08.DoublyLinkedListNode;

public class PalindromicSearch<T> {

    public PalindromicSearch() {
    }

    public boolean isPalindromic(DoublyLinkedList<T> list) {
        boolean isPalindromic = false;
        if(!list.isEmpty() && list.size() > 1) {
            DoublyLinkedListNode<T> first = list.getFirst();
            DoublyLinkedListNode<T> last = list.getLast();
            int i = 0;
            int j = list.size() - 1;
            while(first.getInfo() == last.getInfo() && i < j) {
                first = first.getNext();
                last = last.getPrevious();
                i++;
                j--;
            }
            if(j <= i) {
                isPalindromic = true;
            }
        }
        return isPalindromic;
    }
    //CC O(n/2)
}
