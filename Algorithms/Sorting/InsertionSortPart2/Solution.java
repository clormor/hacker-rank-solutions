import java.util.Scanner;

public class Solution {

    public static void insertionSort2(int n, int[] as) {

        // sort increasing subset of the array, starting at size 2
        for (int i = 1; i < n; i++) {
            int toSort = as[i];
            int compare = i - 1;

            // shuffle elements larger than the right-most element
            while (compare >= 0 && as[compare] > toSort) {
                as[compare + 1] = as[compare];
                compare = compare - 1;
            }

            // insert the value
            as[compare + 1] = toSort;
            printArray(as);
            System.out.println("");
        }

        printArray(as);
    }

    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort2(n, arr);

        scanner.close();
    }

}

