import java.util.Scanner;

public class Solution {

    static void insertionSort1(int n, int[] arr) {
        int toSort = arr[n - 1];
        int compare = n - 2;
        while (compare >= 0 && arr[compare] > toSort) {
            arr[compare + 1] = arr[compare];
            compare = compare - 1;
            printArray(arr);
            System.out.println("");
        }
        arr[compare + 1] = toSort;
        printArray(arr);
    }

    static void printArray(int[] arr) {
        for (int n : arr) {
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

        insertionSort1(n, arr);

        scanner.close();
    }
}
