import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] result = new int[queries.length];
        Map<String, Integer> queriesMap = new HashMap<>();

        // initialise the map
        for (String query : queries) {
            queriesMap.put(query, 0);
        }

        // loop through each string
        for (int i = 0; i < strings.length; i++) {
            String key = strings[i];
            if (queriesMap.containsKey(key)) {
                queriesMap.put(key, queriesMap.get(key) + 1);
            }
        }

        // return the resulting counts
        for (int i = 0; i < queries.length; i++) {
            result[i] = queriesMap.get(queries[i]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int stringsCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            // construct the strings
            String[] strings = new String[stringsCount];
            for (int i = 0; i < stringsCount; i++) {
                String stringsItem = scanner.nextLine();
                strings[i] = stringsItem;
            }

            int queriesCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            // construct the queries
            String[] queries = new String[queriesCount];
            for (int i = 0; i < queriesCount; i++) {
                String queriesItem = scanner.nextLine();
                queries[i] = queriesItem;
            }

            // compute the matches
            int[] res = matchingStrings(strings, queries);

            for (int i = 0; i < res.length; i++) {
                bufferedWriter.write(String.valueOf(res[i]));
                if (i != res.length - 1) {
                    bufferedWriter.write("\n");
                }
            }

            bufferedWriter.newLine();
        }
    }
}
