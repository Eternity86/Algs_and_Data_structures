package Lesson6;

import java.util.NoSuchElementException;

public class BSTFull<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size; //РєРѕР»-РІРѕ СѓР·Р»РѕРІ РІ РґРµСЂРµРІРµ, РєРѕСЂРЅРµРј РєРѕС‚РѕСЂРѕРіРѕ СЏРІР»СЏРµС‚СЃСЏ СѓР·РµР» Node
        private int height = 0;
        public Node(Key key, Value value, int size, int height) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.height = height;
        }
    }

    private Node root;

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return this.size(root);
    }

    public int height() { return height(root); }

    private int height(Node node) {
        if(node == null) {
            return 0;
        }
        else return node.height;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        else {
            return node.size;
        }
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) < 2 &&
                isBalanced(node.left) &&
                isBalanced(node.right);
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть равен Null");
        }
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        }
        else if (cmp < 0) {
            return get(node.left, key);
        }
        else {
            return  get(node.right, key);
        }
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть равен Null");
        }
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1, 0);
        }

        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        }
        else if (cmp < 0) {
            node.left = put(node.left, key, value);
        }
        else {
            node.right = put(node.right, key, value);
        }

        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        else {
            return min(node.left);
        }
    }

    private Node max(Node node) {
        if (node.right == null) {
            return  node;
        }
        else {
            return max(node.right);
        }
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            return node.left;
        }
        node.right = deleteMin(node.right);
        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        root = deleteMax(root);
    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return  null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        }
        else if (cmp > 0) {
            node.right = delete(node.right, key);
        }
        else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node tmp = node;
            node = max(node.left);
            node.left = deleteMax(tmp.left);
            node.right = tmp.right;
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    public static void main(String[] args) {
        BSTFull<Character, Integer> bst = new BSTFull<>();
        bst.put('S', 1);
        bst.put('E', 2);
        bst.put('A', 3);
        bst.put('C', 4);
        bst.put('R', 5);
        bst.put('H', 6);
        bst.put('M', 7);
        bst.put('X', 8);    // Дерево, которое мы исследовали на занятии - оно несбалансированное
        bst.put('B', 9);    // Ещё несбалансированное
        bst.put('T', 9);    // Ещё несбалансированное
        bst.put('Z', 9);    // Ещё несбалансированное
        bst.put('U', 9);    // А вот теперь сбалансированное
        System.out.println(bst.isBalanced());
    }
}
