import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    static int runningTime(int[] arr) {
        int shifts = 0;

        // sort increasing subset of the array, starting at size 2
        for (int i = 1; i < arr.length; i++) {
            int toSort = arr[i];
            int compare = i - 1;

            // shuffle elements larger than the right-most element
            while (compare >= 0 && arr[compare] > toSort) {
                arr[compare + 1] = arr[compare];
                compare = compare - 1;
                shifts++;
            }

            arr[compare + 1] = toSort;
        }

        return shifts;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = runningTime(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
