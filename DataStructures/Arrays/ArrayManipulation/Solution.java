import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    // rather than reading in the whole file to memory, process each line as an input stream
    public static void main(String[] args) throws IOException {
        try (Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int n = s.nextInt();
            int m = s.nextInt();

            long[] arr = new long[n];
            for (int i = 0; i < m; i++) {
                int a = s.nextInt();
                int b = s.nextInt();
                int k = s.nextInt();
                arr[a - 1] += k;
                if (b < n) {
                    arr[b] -= k;
                }
            }

            long max = 0;
            long current = 0;
            for (int i = 0; i < n; i++) {
                current += arr[i];
                max = Math.max(max, current);
            }

            bufferedWriter.write(String.valueOf(max));
            bufferedWriter.newLine();
        }
    }
}
