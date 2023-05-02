package Prog_III_2023.tp_02.Trees.BinarySearchTree;

public class TreeNode<T extends Comparable<T>>{

    private T key;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T key) {
        this.key = key;
        this.left = this.right = null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

}
