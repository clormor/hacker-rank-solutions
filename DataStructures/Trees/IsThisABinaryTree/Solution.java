class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

/**
 * Solution minus the hidden code, which is... well... hidden.
 */
public class Solution {

    boolean checkBST(Node root) {
        return checkBST(root, -1, -1);
    }

    private boolean checkBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if ((min != -1 && node.data <= min) || (node.data >= max && max != -1)) {
            return false;
        }
        return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
    }

}
