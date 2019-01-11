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

    public void insert(int key, int value) {
        root = insert(root, key, value);
    }

    /**
     * 向以node为根的二叉搜索树中插入节点(key, value)
     * @param node 当前根节点
     * @param key 要插入节点的key
     * @param value 要插入节点的value
     * @return 插入新节点后的二叉搜索树的根
     */
    private Node insert(Node node, int key, int value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (key == node.key) {
            node.value = value;
        } else if (key < node.key) {
            node.left = insert(node, key, value);
        } else {
            node.right = insert(node, key, value);
        }
        return node;
    }

    private class Node {
        int key;
        int value;
        Node left;
        Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
