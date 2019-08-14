import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    static void countSort(Map<Integer, List<String>> words) {
        StringBuilder result = new StringBuilder();
        for (int i : words.keySet()) {
            for (String j : words.get(i)) {
                result.append(j).append(" ");
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        Map<Integer, List<String>> words = new HashMap<>(100);

        // BufferedReader is fast - wrapping this in a Scanner is much slower
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            // Construct a Map, way faster than the default List<List<String>>
            for (int i = 0; i < n; i++) {
                String[] pair = br.readLine().split(" ");
                int key = Integer.parseInt(pair[0]);
                String value = (i < n / 2) ? "-" : pair[1];
                words.computeIfAbsent(key, k -> new ArrayList<>());
                words.get(key).add(value);
            }

            countSort(words);
        }
    }
}
