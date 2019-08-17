import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

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

public class Solution {

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int[][] result = new int[queries.length][];
        Node root = buildTree(indexes);
        for (int i = 0; i < queries.length; i++) {
            doSwap(root, queries[i], 1);
            result[i] = inOrder(root);
        }
        return result;
    }

    private static void doSwap(Node node, int k, int depth) {
        if (node == null) {
            return;
        }
        if (depth % k == 0) {
            Node tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        doSwap(node.left, k, ++depth);
        doSwap(node.right, k, depth);
    }

    private static Node buildTree(int[][] indexes) {
        Node root = new Node(1);
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        for (int i = 0; i < indexes.length; i++) {
            Node current = nodes.remove();
            if (indexes[i][0] != -1) {
                Node left = new Node(indexes[i][0]);
                current.left = left;
                nodes.add(left);
            }
            if (indexes[i][1] != -1) {
                Node right = new Node(indexes[i][1]);
                current.right = right;
                nodes.add(right);
            }
        }

        return root;
    }

    private static int[] inOrder(Node root) {
        List<Integer> nodes = doInorder(root);
        int[] result = new int[nodes.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = nodes.get(i);
        }
        return result;
    }

    private static List<Integer> doInorder(Node node) {
        List<Integer> result = new ArrayList<>();
        if (node != null) {
            result = doInorder(node.left);
            result.add(node.data);
            result.addAll(doInorder(node.right));
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))
        ) {
            int n = Integer.parseInt(scanner.nextLine().trim());
            int[][] indexes = new int[n][2];

            for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
                String[] indexesRowItems = scanner.nextLine().split(" ");

                for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                    int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                    indexes[indexesRowItr][indexesColumnItr] = indexesItem;
                }
            }

            int queriesCount = Integer.parseInt(scanner.nextLine().trim());
            int[] queries = new int[queriesCount];
            for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
                int queriesItem = Integer.parseInt(scanner.nextLine().trim());
                queries[queriesItr] = queriesItem;
            }

            int[][] result = swapNodes(indexes, queries);

            for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
                for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                    bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                    if (resultColumnItr != result[resultRowItr].length - 1) {
                        bufferedWriter.write(" ");
                    }
                }

                if (resultRowItr != result.length - 1) {
                    bufferedWriter.write("\n");
                }
            }

            bufferedWriter.newLine();
        }
    }
}
