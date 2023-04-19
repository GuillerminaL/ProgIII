package Prog_III_2023.tp_01.ej_09;

import Prog_III_2023.tp_01.ej_08.DoublyLinkedList;

public class Main {

    public static void main(String[] args) {

        DoublyLinkedList<String> key = new DoublyLinkedList<String>();

//        key.insertFront("o");
//        key.insertFront("j");
//        key.insertFront("o");
//
//        key.insertFront("s");

//        key.insertFront("a");
//        key.insertFront("n");
//        key.insertFront("i");
//        key.insertFront("l");
//        key.insertFront("i");
//        key.insertFront("n");
//        key.insertFront("a");
//        key.insertFront("s");


        PalindromicSearch<String> search = new PalindromicSearch<String>();
        boolean result = search.isPalindromic(key);

        System.out.println(" ");
        System.out.println(key.toString());
        if(result) System.out.println("Is Palindromic");
        else System.out.println("Is not palindromic");
    }
}
