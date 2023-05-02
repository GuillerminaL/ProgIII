package Prog_III_2023.tp_02.Trees.SimpleBinaryTree;

public class BTNode<T extends Comparable<T>> {

    private boolean visited;
    private T value;
    private BTNode left;
    private BTNode right;

    public BTNode(T value) {
        this.visited = false;
        this.value = value;
    }

    public BTNode(T value, BTNode left, BTNode right) {
        this.visited = false;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isALeaf() {
        return this.getLeft() == null && this.getRight() == null;
    }
}
