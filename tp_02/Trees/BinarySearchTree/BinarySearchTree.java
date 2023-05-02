package Prog_III_2023.tp_02.Trees.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(T root) {
        this.root = new TreeNode<T>(root);
    }



    public T getRoot() {
        return (this.root != null) ? this.root.getKey() : null;
    }
    //CC O(1)



    private void setRoot(T root) {
        if (this.root == null)
            this.root = new TreeNode<T>(root);
        else
            this.root.setKey(root);
    }
    //CC O(1)



    public boolean isEmpty() {
        return this.root == null;
    }
    //CC O(1)



    private boolean hasElement(TreeNode<T> node, T key) {
        if (node != null) {
            if (node.getKey().equals(key)) return true;
            if (node.getKey().compareTo(key) < 0) {
                if (node.getRight() != null)
                    return this.hasElement(node.getRight(), key);

            } else {
                if (node.getLeft() != null)
                    return this.hasElement(node.getLeft(), key);

            }
        }
        return false;
    }

    public boolean hasElement(T key) {
        return this.hasElement(this.root, key);
    }
    //CC O(log2 n)



    private void add(TreeNode<T> node, T key) {
        if (node.getKey().compareTo(key) < 0) {
            if (node.getRight() == null) {
                TreeNode<T> tmp = new TreeNode<T>(key);
                node.setRight(tmp);
            } else {
                this.add(node.getRight(), key);
            }
        } else {
            if(node.getLeft() == null) {
                TreeNode<T> tmp = new TreeNode<T>(key);
                node.setLeft(tmp);
            } else {
                this.add(node.getLeft(), key);
            }
        }
    }

    public void add(T key) {
        if (this.root == null) this.root = new TreeNode<T>(key);
        else this.add(this.root, key);
    }
    //CC O(log2 n)



    private TreeNode<T> searchExtremeLeftNode(TreeNode<T> node) {
        if (node.getLeft() == null) return node;
        return searchExtremeLeftNode(node.getLeft());
    }
    //CC O(log2 n)
    // Worst scenario: Climbing tree to left
    // Best scenario: Tree without left branch



    private TreeNode<T> delete(TreeNode<T> current, T key) {
        if (current == null) return null;
        if (current.getKey().equals(key)) {
            if (current.getLeft() == null && current.getRight() == null) return null;
            if (current.getLeft() == null) return current.getRight();
            if (current.getRight() == null) return current.getLeft();
            TreeNode<T> extremeLeft = this.searchExtremeLeftNode(current.getRight());
            this.delete(current.getRight(), extremeLeft.getKey());
            current.setKey(extremeLeft.getKey());
        } else {
            if (current.getKey().compareTo(key) < 0) {
                current.setRight(this.delete(current.getRight(), key));
            } else {
                current.setLeft(this.delete(current.getLeft(), key));
            }
        }
        return current;
    }

    public boolean delete(T key) {
        if (this.root == null) return false;
        this.root = this.delete(this.root, key);
        return true;
    }
    //CC O(2*log2 n)  --Implies finding the selected element--
    /*
     The method operates over the current node so, as its father is unknown, when a deleting with replacement take
     place (intern node with children), it's needed to delete the replacement as well -instead of setting the
     reference from the father as null-.
     When this secondary delete is called inside the original operation, it starts not all over again, but from the
     current node's right tree root, where the replacement was found.
                                                  ...    or     ...
     Worst scenario:                             /                 \
     Deleting the last nodes of a               N                   N
     branch which its right side then          l. r.              l. r.
     continues growing as a climbing              /                  /
     tree to the left.                           /                  /
                                               ...                ...
    */



    private int getHeight(TreeNode<T> current, int height) {
        if (current == null) return height;
        int left = height + this.getHeight(current.getLeft(), 1);
        int right = height + this.getHeight(current.getRight(), 1);
        return (left >= right) ? left : right;
    }

    public int getHeight() {
        return this.getHeight(this.root, -1);
    }
    //CC O(n)  --Implies getting the longest branch--
    // Having the method "getLongestBranch" allows to simply return its size.
    // The difference between "getLongestBranch" and "getHeight" is in the additional memory required for the
    // return (list or integer).


    private String print(String stg, TreeNode<T> node, int order) {
        if (node == null) stg += "-";
        else {
            switch (order) {
                case -1:
                    stg += node.getKey();
                    stg = this.print(stg, node.getLeft(), order);
                    stg = this.print(stg, node.getRight(), order);
                    break;
                case 0:
                    stg = this.print(stg, node.getLeft(), order);
                    stg += node.getKey();
                    stg = this.print(stg, node.getRight(), order);
                    break;
                case 1:
                    stg = this.print(stg, node.getLeft(), order);
                    stg = this.print(stg, node.getRight(), order);
                    stg += node.getKey();
                    break;
            }
        }
        return stg;
    }

    public void printPreOrder() {
        String stg = "\nPreOrder Tree = [";
        stg = this.print(stg, this.root, -1);
        System.out.println(stg + "]");
    }

    public void printInOrder() {
        String stg = "\nInOrder Tree = [";
        stg = this.print(stg, this.root, 0);
        System.out.println(stg + "]");
    }

    public void printPosOrder() {
        String stg = "\nPosOrder Tree = [";
        stg = this.print(stg, this.root, 1);
        System.out.println(stg + "]");
    }
    //CC O(n)



    private List<T> getLongestBranch(TreeNode<T> node, List<T> result) {
        if (node == null) return result;
        result = this.getLongestBranch(node.getLeft(), result);
        List<T> right = this.getLongestBranch(node.getRight(), new ArrayList<T>());
        if ((right.size() > result.size())) {
            result = right;
        }
        result.add(0,node.getKey());
        return result;
    }

    public List<T> getLongestBranch() {
        List<T> result = new ArrayList<T>();
        result = this.getLongestBranch(this.root, result);
        return result;
    }
    //CC 0(n)
    // Worst scenario: always the worst, given that it requires to traverse both branches in order to compare them and
    // return the longest one's elements.
    // Requires addition memory -a second arraylist to save the branch to compare-



    private List<T> getFrontier(TreeNode<T> node, List<T> result) {
        if (node == null) return result;
        if (node.getLeft() == null && node.getRight() == null) {
            result.add(node.getKey());
        } else {
            result = this.getFrontier(node.getLeft(), result);
            result = this.getFrontier(node.getRight(), result);
        }
        return result;
    }

    public List<T> getFrontier() {
        List<T> result = new ArrayList<T>();
        result = this.getFrontier(this.root, result);
        return result;
    }
    //CC O(n)
    // Worst scenario: always the worst, given that both branches need to be completely traverse in order to get the frontier.



    private T searchExtremeRightNode(TreeNode<T> node) {
        if (node == null) return null;
        if (node.getRight() == null) return node.getKey();
        else return searchExtremeRightNode(node.getRight());
    }

    public T getMaxElement() {
        return this.searchExtremeRightNode(this.root);
    }
    //CC O(log2 n)
    // Worst scenario: Climbing tree to the right
    // Best scenario: Tree without right branch



    private List<T> getElementAtLevel(List<T> result, TreeNode<T> node, int level, int currentLevel) {
        if (node == null) return result;
        if (currentLevel == level) {
            result.add(node.getKey());
        } else {
            if (currentLevel < level) {
                int aux = currentLevel;
                this.getElementAtLevel(result, node.getLeft(), level, aux + 1);
                this.getElementAtLevel(result, node.getRight(), level, aux + 1);
            }
        }
        return result;
    }

    public List<T> getElementAtLevel(int level) {
        if(level < 0) return null;
        return this.getElementAtLevel(new ArrayList<T>(), this.root, level, 0);
    }
    //CC O(n)
    // Worst scenario: receiving the last level of a complete tree, given that both branches -all nodes-
    // should be traversed in order to list them.




    /*------------------------------------ Ej 02 --------------------------------------------------------*/
    private int getAddition(TreeNode<T> node, int cont) {
        if (node != null) {
            cont = this.getAddition(node.getLeft(), cont);
            cont = this.getAddition(node.getRight(), cont);
            cont = cont + (Integer) node.getKey();
        }
        return cont;
    }

    public int getAddition() {
        return this.getAddition(this.root, 0);
    }



    /*------------------------------------ Ej 03 --------------------------------------------------------*/
    private List<T> getValuesGreaterThan(TreeNode<T> node, T key, List<T> list) {
        if (node == null) return list;
        T nodeKey = node.getKey();
        if (nodeKey.compareTo(key) > 0) {
            list = this.getValuesGreaterThan(node.getLeft(), key, list);
            list.add(0, nodeKey);
        }
        list = this.getValuesGreaterThan(node.getRight(), key, list);
        return list;
    }

    public List<T> getValuesGreaterThan(T key) {
        return this.getValuesGreaterThan(this.root, key, new ArrayList<T>());
    }
}
