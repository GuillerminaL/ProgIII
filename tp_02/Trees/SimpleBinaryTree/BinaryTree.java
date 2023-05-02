package Prog_III_2023.tp_02.Trees.SimpleBinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private BTNode root;

    public BinaryTree() {}

    public void setRoot(BTNode root) {
        this.root = root;
    }


    private String print(String stg, BTNode node) {
        if (node == null) stg += " - ";
        else {
            stg += " " + node.getValue() + " ";
            stg = this.print(stg, node.getLeft());
            stg = this.print(stg, node.getRight());
        }
        return stg;
    }

    public void printPreOrder() {
        String stg = "\nPreOrder Tree = [";
        stg = this.print(stg, this.root);
        System.out.println(stg + "]");
    }


    /*----------------------- Substracting fill --------------------------------------*/

    private void subtractingFill(BTNode node) {
        if (node.getLeft() == null && node.getRight() == null) return;
        if (node.getLeft() != null && node.getRight() != null) {
            this.subtractingFill(node.getLeft());
            this.subtractingFill(node.getRight());
            node.setValue((Integer) node.getRight().getValue() - (Integer)node.getLeft().getValue());
        } else {
            if (node.getLeft() != null) {
                this.subtractingFill(node.getLeft());
                node.setValue(node.getLeft().getValue());
            } else {
                this.subtractingFill(node.getRight());
                node.setValue(node.getRight().getValue());
            }
        }
        return;
    }

    public void subtractingFill() {
        if (this.root == null) return;
        this.subtractingFill(this.root);
    }


    /*------------------- get frontier --------------------------*/
    private List getFrontier(BTNode node, List result) {
        if (node == null) return result;
        if (node.getLeft() == null && node.getRight() == null) {
            result.add(node.getValue());
        } else {
            result = this.getFrontier(node.getLeft(), result);
            result = this.getFrontier(node.getRight(), result);
        }
        return result;
    }

    public List getFrontier() {
        List result = new ArrayList();
        result = this.getFrontier(this.root, result);
        return result;
    }


    /*------------------------------ Words search ------------------------------------*/
    private int countVowel(BTNode node) {
        return (node.getValue().equals("A") || node.getValue().equals("E") || node.getValue().equals("I") ||
                node.getValue().equals("O") || node.getValue().equals("U")) ? 1 : 0;
    }

    private List searchWordsWithNVowels(int n, BTNode node, List result, List current, int v) {
        if (node == null) return current;
        if (node.isALeaf()) {
            int vowel = this.countVowel(node);
            v += vowel;
            if (v == n || n == 100) {
                result.addAll(current);
                result.add(node.getValue());
                result.add("-");
            }
            if (this.countVowel(node) == 1) v -= vowel;
            return current;
        }
        current.add(node.getValue());
        int vowel = this.countVowel(node);
        v += vowel;
        if (v <= n) {
            this.searchWordsWithNVowels(n, node.getLeft(), result, current, v);
            this.searchWordsWithNVowels(n, node.getRight(), result, current, v);
        }
        current.remove(node.getValue());
        v -= vowel;
        return result;
    }

    public List searchWordsWithNVowels(int n) {
        if (this.root == null) return null;
        List result = this.searchWordsWithNVowels(n, this.root, new ArrayList<String>(), new ArrayList<String>(), 0);
        return result;
    }

    public List getWords() {
        return searchWordsWithNVowels(100);
    }



}
