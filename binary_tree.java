import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public boolean breathFirstSearch(Node root, int target) {
        if (root == null) {
            return false;
        }
        Queue<Node> values = new LinkedList<>();
        values.offer(root);
        while (!values.isEmpty()) {
            Node node = values.poll();
            if (node.value == target) {
                return true;
            }
            if (node.left != null) {
                values.offer(node.left);
            }
            if (node.right != null) {
                values.offer(node.right);
            }
        }
        return false;
    }

    public boolean depthFirstSearch(Node root, int target) {
        if (root == null) {
            return false;
        }
        if (root.value == target) {
            return true;
        }
        return depthFirstSearch(root.left, target) || depthFirstSearch(root.right, target);
    }

    public int sumOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        return root.value + sumOfTree(root.left) + sumOfTree(root.right);
    }

    public int minValueOfTree(Node root) {
        int smallest = Integer.MAX_VALUE;
        if (root == null) {
            return smallest;
        }
        return Math.min(root.value, Math.min(minValueOfTree(root.left), minValueOfTree(root.right)));
    }

    public int maxSumOfBranch(Node root) {
        if (root == null) {
            return 0;
        }
        return root.value + Math.max(maxSumOfBranch(root.left), maxSumOfBranch(root.right));
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        Tree tree = new Tree(a);
        System.out.println(tree.breathFirstSearch(tree.root, 5));
        System.out.println(tree.depthFirstSearch(tree.root, 5));
        System.out.println(tree.sumOfTree(tree.root));
        System.out.println(tree.minValueOfTree(tree.root));
        System.out.println(tree.maxSumOfBranch(tree.root));
    }
}