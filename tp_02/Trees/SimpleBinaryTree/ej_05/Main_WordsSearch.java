package Prog_III_2023.tp_02.Trees.SimpleBinaryTree.ej_05;

import Prog_III_2023.tp_02.Trees.SimpleBinaryTree.BTNode;
import Prog_III_2023.tp_02.Trees.SimpleBinaryTree.BinaryTree;

import java.util.List;

public class Main_WordsSearch {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        //*---------- Árbol 1 ---------------------------------------------*/
        //Level 2
        BTNode a = new BTNode("N", new BTNode("A"), new BTNode("O"));
        BTNode b = new BTNode("S", null, new BTNode("A"));

        //Level 1
        BTNode c = new BTNode("A", new BTNode("L"), a);
        BTNode d = new BTNode("I", b, new BTNode("O"));

        //Level 0
        BTNode e = new BTNode("M", c, d);

        tree.setRoot(e);

        //*------------ Árbol 2 -------------------------------------------
        //Level 4
//        BTNode k1 = new BTNode("A", null, new BTNode("S"));
//        BTNode k2 = new BTNode("O", new BTNode("S"), null);
//        BTNode k3 = new BTNode("A", new BTNode("O"), null);
//
//
//        //Level 3
//        BTNode e1 = new BTNode("N", new BTNode("O"), k1);
//        BTNode e2 = new BTNode("R", new BTNode("A"), k2);
//        BTNode e3 = new BTNode("N");
//        BTNode e4 = new BTNode("B", k3, null);
//
//
//        //Level 2
//        BTNode b1 = new BTNode("E", e1, null);
//        BTNode b2 = new BTNode("R", null, e2);
//        BTNode b3 = new BTNode("E", e3, null);
//        BTNode b4 = new BTNode("L", e4, null);
//
//
//        //Level 1
//        BTNode i1 = new BTNode("U", b1, b2);
//        BTNode i2 = new BTNode("I", b3, b4);
//
//        //Level 0
//        BTNode o = new BTNode("B", i1, i2);
//        tree.setRoot(o);



        /*------------------- Words search -----------------------------*/

        System.out.println("");
        System.out.println("Words in tree: ");
        System.out.println(tree.getWords().toString());

        int n = 2;
        List result = tree.searchWordsWithNVowels(n);
        System.out.println("");
        System.out.println("Words with " + n + " vowels: ");
        System.out.println(result.toString());

    }
}
