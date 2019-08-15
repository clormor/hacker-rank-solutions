import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String[] nd = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nd[0]);
            int d = Integer.parseInt(nd[1]);
            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            scanner.close();

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            // perform the rotation - print straight to STDOUT
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                result.append(a[(d + i) % n]).append(" ");
            }
            System.out.print(result);
        }
    }
}
