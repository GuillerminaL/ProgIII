package Prog_III_2023.tp_02.Trees.SimpleBinaryTree.ej_04;

import Prog_III_2023.tp_02.Trees.SimpleBinaryTree.BTNode;
import Prog_III_2023.tp_02.Trees.SimpleBinaryTree.BinaryTree;

public class Main_NumericalPyramid {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();


        //Level 2
        BTNode a = new BTNode(14);

        BTNode b = new BTNode(0, new BTNode(7), new BTNode(-5));

        BTNode c = new BTNode(0, null, new BTNode(9));

        //Level 1
        BTNode d = new BTNode(0, a, b);

        BTNode e = new BTNode(0, c, new BTNode(20));

        //Level 0
        BTNode f = new BTNode(0, d, e);

        tree.setRoot(f);


        /*------------------- Subtracting Fill -----------------------------*/

        tree.printPreOrder();

        System.out.println("\nSubtracting fill...");
        tree.subtractingFill();

        tree.printPreOrder();

    }
}
