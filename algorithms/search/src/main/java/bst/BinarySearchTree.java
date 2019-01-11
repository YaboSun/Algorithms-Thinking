package bst;

/**
 * @author YaboSun
 */
public class BinarySearchTree {

    private Node root;
    private int count;

    public BinarySearchTree() {
        root = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private class Node {
        String key;
        int value;
        Node left;
        Node right;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
