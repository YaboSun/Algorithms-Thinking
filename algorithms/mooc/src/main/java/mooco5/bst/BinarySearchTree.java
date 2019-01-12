package mooco5.bst;

/**
 * @author YaboSun
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

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

    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }

    /**
     * 判断二叉搜索树中是否包含元素key
     * @param key 元素key
     * @return 存在则返回true
     */
    public boolean contain(Key key) {
        return contain(root, key);
    }

    /**
     * 根绝给定的key查找在二叉搜索树中对应的下标
     * @param key 要查找的值
     * @return 存在则返回对应key的下标，否则返回null
     */
    public Value search(Key key) {
        return search(root, key);
    }

    /**
     * 前序遍历递归方法定义
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 中序遍历定义
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 后序遍历定义
     */
    public void postOrder() {
        postOrder(root);
    }

    /**
     * 释放整个二叉树
     * @param node 以node为根节点的二叉树
     */
    public void destroy(Node node) {
        if (node != null) {
            destroy(node.left);
            destroy(node.right);

            node = null;
            count--;
        }
    }
    /**
     * 向以node为根的二叉搜索树中插入节点(key, value) 辅助函数
     * 递归实现
     * @param node 当前根节点
     * @param key 要插入节点的key
     * @param value 要插入节点的value
     * @return 插入新节点后的二叉搜索树的根
     */
    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            count++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    /**
     * 判断二叉搜索树中是否包含元素key 辅助函数
     * @param key 元素key
     * @param node 当前根节点
     * @return 存在则返回true
     */
    private boolean contain(Node node, Key key) {
        if (node == null) {
            return false;
        }
        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }

    /**
     * 在以node为根的二叉搜索树中查找key所对应的value
     * @param node
     * @param key
     * @return
     */
    private Value search(Node node, Key key) {
        if (node == null) {
            return null;
        } else if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }

    /**
     * 前序遍历递归实现
     * 对以node为根的二叉搜索树进行前序遍历
     * @param node 当前根节点
     */
    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历实现
     * @param node 当前根节点
     */
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.key);
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历实现
     * @param node 当前节点
     */
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.key);
        }
    }
    /**
     * 二叉搜索树的辅助类
     */
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
