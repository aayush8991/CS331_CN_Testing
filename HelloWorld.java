public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World! from Java");
    }
}


public class BinarySearchTree {
    class Node {
        int key;
        Node left, right;
        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.key) root.left = insertRec(root.left, key);
        else if (key > root.key) root.right = insertRec(root.right, key);
        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] values = {50, 30, 20, 40, 70, 60, 80};
        for (int val : values) tree.insert(val);
        System.out.println("Inorder traversal:");
        tree.inorder();
    }
}
