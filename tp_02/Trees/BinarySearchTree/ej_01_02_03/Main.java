package Prog_III_2023.tp_02.Trees.BinarySearchTree.ej_01_02_03;

import Prog_III_2023.tp_02.Trees.BinarySearchTree.BinarySearchTree;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree<Integer> bstree = new BinarySearchTree<Integer>();

        /*----------------------- Is empty --------------------------------*/
        System.out.println("");
        System.out.println("Is empty? " + bstree.isEmpty());

        /*-------------------------- Add ----------------------------------*/
        bstree.add(6);
        bstree.add(3);
        bstree.add(7);
        bstree.add(9);
        bstree.add(1);
        bstree.add(5);
        bstree.add(4);

        System.out.println("");
        System.out.println("Is empty? " + bstree.isEmpty());


        /*-------------------------- Has element --------------------------------*/
        System.out.println("");
        int element = 0;
        System.out.println("Has element " + element + "? " + bstree.hasElement(element));


        /*------------------------------ Delete ----------------------------------*/
        System.out.println("");
        bstree.delete(element);
        boolean hasIt = bstree.hasElement(element);
        System.out.println("Has element " + element + "? " + hasIt);


        /*-------------------------- Get height ----------------------------------*/
        System.out.println(" ");
        int height = bstree.getHeight();
        System.out.println("Height: " + height);


        /*-------------------------- Print --------------------------------*/
        bstree.printPreOrder();
//        bstree.printInOrder();
//        bstree.printPosOrder();

        /*-------------------- Get longest branch --------------------------------*/
        List<Integer> longestBranch = bstree.getLongestBranch();
        System.out.println("");
        System.out.println("Longest branch: " + longestBranch.toString());

        /*-------------------- Get frontier --------------------------------*/
        List<Integer> frontier = bstree.getFrontier();
        System.out.println("");
        System.out.println("Frontier: " + frontier);

        /*-------------------- Get max element--------------------------------*/
        Integer max = bstree.getMaxElement();
        System.out.println("");
        System.out.println("Max element: " + max);


        /*-------------------- Get element at level --------------------------*/
        int level = -5;
        List<Integer> elsPerLevel = bstree.getElementAtLevel(level);
        System.out.println("");
        System.out.println("Level " + level + ": " + elsPerLevel);


        /*------------------------------------ Ej 02 --------------------------------------------------------*/
        int sum = bstree.getAddition();
        System.out.println("");
        System.out.println("Nodes value total addition is: " + sum);


        /*------------------------------------ Ej 03 --------------------------------------------------------*/
        int key = 0;
        List<Integer> elsGreaterThan = bstree.getValuesGreaterThan(key);
        System.out.println("");
        System.out.println("Elements greater than " + key + " are: " + elsGreaterThan.toString());
    }
}
