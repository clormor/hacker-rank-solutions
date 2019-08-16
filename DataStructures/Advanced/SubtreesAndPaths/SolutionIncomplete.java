import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static int[] values;
    static int[] parents;
    static Map<Integer, Set<Integer>> allEdges;
    static final int ROOT_INDEX = 1;

    public static void main(String[] args) {
        try (Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            StringBuilder result = new StringBuilder();

            int n = s.nextInt();
            values = new int[n + ROOT_INDEX];
            parents = new int[n + ROOT_INDEX];
            allEdges = new HashMap<>(n);

//            System.out.printf("%03d: %d%n", 1, System.currentTimeMillis());

            // process the edges
            for (int i = 0; i < n - 1; i++) {
                int a = s.nextInt();
                int b = s.nextInt();

                Set<Integer> as = allEdges.computeIfAbsent(a, k -> new HashSet<>());
                as.add(b);

                Set<Integer> bs = allEdges.computeIfAbsent(b, k -> new HashSet<>());
                bs.add(a);
            }

//            System.out.printf("%03d: %d%n", 2, System.currentTimeMillis());

            // map parents - i think this is quicker than having a visited array every time we do an add
            List<Integer> qu = new ArrayList<>();
            parents[ROOT_INDEX] = 0;
            qu.add(ROOT_INDEX);
            while (!qu.isEmpty()) {
                int i = qu.remove(0);
                for (Integer ancestor : allEdges.get(i)) {
                    if (ancestor != parents[i]) {
                        parents[ancestor] = i;
                        qu.add(ancestor);
                    }
                }
            }

//            System.out.printf("%03d: %d%n", 3, System.currentTimeMillis());

            // process the queries
            int q = s.nextInt();
            for (int i = 0; i < q; i++) {
                String query = s.next();
                int x = s.nextInt();
                int y = s.nextInt();
                if (query.charAt(0) == 'a') {
                    add(x, y);
                } else {
                    result.append(max(x, y)).append(System.lineSeparator());
                }
            }

            System.out.println(result);
//            System.out.printf("%03d: %d%n", 4, System.currentTimeMillis());
        }

    }

    private static void add(int tree, int value) {
        List<Integer> qu = new ArrayList<>();
        qu.add(tree);
        while (!qu.isEmpty()) {
            int i = qu.remove(0);
            values[i] += value;
            for (Integer ancestor : allEdges.get(i)) {
                if (ancestor != parents[i]) {
                    qu.add(ancestor);
                }
            }
        }
    }

    public static int max(int fromId, int toId) {
        List<Integer> qu = new ArrayList<>();
        List<Integer> maxes = new ArrayList<>();
        boolean visited[] = new boolean[values.length + ROOT_INDEX];
        qu.add(fromId);
        maxes.add(values[fromId]);
        while (!qu.isEmpty()) {
            int i = qu.remove(0);
            int max = Math.max(maxes.remove(0), values[i]);
            visited[i] = true;

            if (i == toId) {
                return max;
            }

            for (Integer ancestor : allEdges.get(i)) {
                if (!visited[ancestor]) {
                    qu.add(ancestor);
                    maxes.add(max);
                }
            }
        }
        throw new RuntimeException("No route existed!");
    }
}
